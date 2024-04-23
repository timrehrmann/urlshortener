package tim.urlshortener.repository

import org.springframework.data.repository.CrudRepository
import tim.urlshortener.domains.Url

interface ShortenerRepository: CrudRepository<Url, Int> {
}