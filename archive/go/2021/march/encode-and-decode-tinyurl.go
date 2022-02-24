package march

import (
	"math/rand"
	"strings"
)

const baseUrl = "http://tinyurl.com/"
const charset = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"

type Codec struct {
	url2Code map[string]string
	code2Url map[string]string
}

func NewCode() Codec {
	return Codec{
		url2Code: make(map[string]string),
		code2Url: make(map[string]string),
	}
}

// Encodes a URL to a shortened URL.
func (c *Codec) Encode(longUrl string) string {
	for _, ok := c.url2Code[longUrl]; !ok; _, ok = c.url2Code[longUrl] {
		var code string
		for i := 0; i < 6; i++ {
			var r = rand.Intn(62)
			code += charset[r-1 : r]
		}
		if _, ok := c.code2Url[code]; !ok {
			c.code2Url[code] = longUrl
			c.url2Code[longUrl] = code
		}
	}
	return baseUrl + c.url2Code[longUrl]
}

// Decodes a shortened URL to its original URL.
func (c *Codec) Decode(shortUrl string) string {
	s := strings.ReplaceAll(shortUrl, baseUrl, "")
	return c.code2Url[s]
}

/**
 * Your Codec object will be instantiated and called as such:
 * obj := Constructor();
 * url := obj.encode(longUrl);
 * ans := obj.decode(url);
 */
