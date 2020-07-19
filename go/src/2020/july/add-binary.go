package july

func addBinary(a string, b string) string {
	if len(a) == 0 {
		return a
	}
	if len(b) == 0 {
		return b
	}
	if a[len(a)-1] == '1' && b[len(b)-1] == '1' {
		return addBinary(addBinary(a[0:len(a)-2], b[0:len(b)-2]), "1") + "0"
	}
	if a[len(a)-1]== '0' && b[len(b)-1] == '0' {
		return addBinary(a[0:len(a)-2], b[0:len(b)-2]) + "0"
	} else {
		return addBinary(a[0:len(a)-2], b[0:len(b)-2]) + "1"
	}
}
