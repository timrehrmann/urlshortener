# DKB Coding Challenge

This is an MVP version of a URL shortener service for the DKB Coding Challenge.

## Usage

### Creating a short URL

To shorten a given URL, simply make a POST call on the endpoint 
```
/api/createShortUrl
```
with a JSON Body using following syntax:
```json
{
  "longUrl": "https://www.google.com"
}
```

The response will be a JSON looking like this:
```json
{
  "shortUrl": -1632447086,
  "longUrl": "https://www.google.com",
  "timestamp": "2024-04-23T13:24:23.982+00:00"
}
```

### Using the short URL

To use the shortened URL, you can simply call the endpoint
```
/{shortURL}
```
using the hash value from the shortUrl field.
This endpoint will send a redirect response with the long url.


## Further Developments

As this is an MVP version there are a couple of things that need further development:

- Use a real database: This MVP uses a simple H2 database file. If using a real database the config for the database needs to be handled in an outsourced application.properties file, so that each deployment environment can have its own config.
- Logging: This MVP has no dedicated logging other than a simple timestamp of the creation date of a URL entry. For meaningful error logging and maintenance there needs to be more logging and analytics for the service, like tracking usage statistics and use a unified logger.
- Scalability: The read process of getting the long url with the shortened one is probably being used way more than the creation process, so it might be better to split the read and create process into multiple microservices, so the read process can have more computing power. Another bottleneck could be the database, so it might make sense to cache URLs that are used often.
- Testing: This MVP has no testing so far, for further developments there should be automated tests.