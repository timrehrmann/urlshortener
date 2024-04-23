package tim.urlshortener.services

import org.springframework.stereotype.Service
import tim.urlshortener.domains.Url
import tim.urlshortener.repositories.ShortenerRepository
import java.util.*

@Service
class ShortenerService (val shortenerRepository: ShortenerRepository) {

    fun createShortUrl(url: Url): Url {
        val shortUrl: Int = url.longUrl.hashCode()
        url.shortUrl = shortUrl
        url.timestamp = Date()
        return shortenerRepository.save(url)
    }

    fun getLongUrl(shortUrl: Int): Optional<Url> = shortenerRepository.findById(shortUrl)

}