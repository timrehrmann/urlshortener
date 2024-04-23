package tim.urlshortener.domains

import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.persistence.Id
import java.util.Date

@Entity
@Table(name = "URLS")
data class Url(
    @Id
    var shortUrl: Int? = null,
    var longUrl: String,
    var timestamp: Date? = null
)
