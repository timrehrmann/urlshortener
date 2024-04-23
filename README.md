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
  "longUrl": "www.google.com"
}
```

The response will be a JSON looking like this:
```json
{
"shortUrl": -702889725,
"longUrl": "www.google.com",
"timestamp": "2024-04-23T13:15:49.907+00:00"
}
```

### Using the short

To use the shortened URL, you can simply call the endpoint
```
/{shortURL}
```
using the hash value from the shortUrl field.
This endpoint will send a redirect response with the long url.
