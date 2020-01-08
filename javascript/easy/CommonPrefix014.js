const findPrefix = array => {
  if (array.length === 0) {
    return ''
  }
  let prefix = array[0]
  let len = array.length
  for (let i = 1; i < len; i++) {
    while (array[i].indexOf(prefix) !== 0) {
      prefix = prefix.slice(0, prefix.length - 1)
      if (prefix === '') {
        break;
      }
    }
  }
  return prefix;
}

console.log(findPrefix(["flower", "flow", "flight"]))
console.log(findPrefix(["dog", "racecar", "car"]))
