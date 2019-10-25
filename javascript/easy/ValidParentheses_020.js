const valid = str => {
  const lst = []
  for (let i = 0; i < str.length; i++) {
    if (str[i] === '(' || str[i] === '[' || str[i] === '{') {
      lst.push(str[i])
    } else {
      if (lst.length === 0) {
        return false
      } else {
        if (lst[lst.length - 1] === '(' && str[i] !== ')') {
          return false
        } else if (lst[lst.length - 1] === '[' && str[i] !== ']') {
          return false
        } else if (lst[lst.length - 1] === '{' && str[i] !== '}') {
          return false
        }
        lst.pop()
      }
    }
  }
  return lst.length === 0
}


console.log(valid('[[]]{}'))
console.log(valid('[[(]]{})'))
