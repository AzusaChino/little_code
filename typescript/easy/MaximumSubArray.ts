const maximum = (nums: number[]): number => {
  let x, y = 0
  for (let i = 1; i < nums.length; i++) {
    x = Math.max(x, x + nums[i])
    y = Math.max(x, y)
  }
  return y
}

