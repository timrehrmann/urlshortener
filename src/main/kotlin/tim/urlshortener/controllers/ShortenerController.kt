package tim.urlshortener.controllers

import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import tim.urlshortener.domains.Url
import tim.urlshortener.services.ShortenerService
import java.util.*

@RestController
class ShortenerController(val shortenerService: ShortenerService) {

    @PostMapping("/api/createShortUrl")
    fun createShortUrl(
        @RequestBody url: Url,
        response: HttpServletResponse
    ): Url? {
        if (url.longUrl.isEmpty()) {
            response.sendError(HttpStatus.BAD_REQUEST.value(), "URL NOT PROVIDED")
            return null
        } else {
            return shortenerService.createShortUrl(url)
        }
    }


    @GetMapping("/{shortUrl}")
    fun getLongUrl(
        @PathVariable("shortUrl") shortUrl: Int,
        response: HttpServletResponse
    ) {
        val url: Optional<Url> = shortenerService.getLongUrl(shortUrl)
        if (url.isEmpty || url.get().longUrl.isEmpty()) {
            response.sendError(HttpStatus.BAD_REQUEST.value(), "URL NOT FOUND")
        } else {
            response.sendRedirect(url.get().longUrl)
        }
    }
}