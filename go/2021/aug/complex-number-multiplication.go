package aug

import (
	"fmt"
	"strconv"
	"strings"
)

type ComplexNumber struct {
	real      int8
	imaginary int8
}

func Multiply(lhs, rhs *ComplexNumber) *ComplexNumber {

	return nil
}

func (cn *ComplexNumber) ToString() string {
	b := &strings.Builder{}
	b.WriteString(fmt.Sprintf("%d", cn.real))
	b.WriteString("+")
	b.WriteString(fmt.Sprintf("%d", cn.imaginary))
	b.WriteString("i")
	return b.String()
}

func complexNumberMultiply(a string, b string) string {
	realA, imagA := parse(a)
	realB, imagB := parse(b)
	real := realA*realB - imagA*imagB
	imag := realA*imagB + realB*imagA
	return strconv.Itoa(real) + "+" + strconv.Itoa(imag) + "i"
}

func parse(s string) (int, int) {
	ss := strings.Split(s, "+")
	r, _ := strconv.Atoi(ss[0])
	i, _ := strconv.Atoi(ss[1][:len(ss[1])-1])
	return r, i
}
