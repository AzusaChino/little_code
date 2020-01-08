const roman = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}

const convert = str => {
  let ret = 0
  for (let i = 0; i < str.length; i++) {
    if (i > 0 && roman[str.charAt(i)] > roman[str.charAt(i - 1)]) {
      ret += roman[str.charAt(i)] - 2 * roman[str.charAt(i - 1)]
    } else {
      ret += roman[str.charAt(i)]
    }
  }
  return ret
}

console.log(convert('MCMXCIV'))
