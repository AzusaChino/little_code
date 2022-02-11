package main

import (
	"fmt"
	"leetcode/2021/march"
)

func main() {
	c := march.NewCode()
	url := c.Encode("http://abc.com")
	fmt.Println("URL: ", url)
	ans := c.Decode(url)
	fmt.Println("DE: ", ans)
}
