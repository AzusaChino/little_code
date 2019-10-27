const remove = nums => {
  let i = 0
  for (let j = 1; j < nums.length; j++) {
    if (nums[i] !== nums[j]) {
      i++
      nums[i] = nums[j]
    }
  }
  return i + 1
}

console.log(remove([1, 222, 2222, 33333, 33333]))
