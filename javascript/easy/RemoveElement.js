const remove = (nums, val) => {
  let j = 0
  for (let i = 0; i < nums.length; i++) {
    if (val !== nums[i]) {
      nums[j++] = nums[i]
    }
  }
  return j
}
