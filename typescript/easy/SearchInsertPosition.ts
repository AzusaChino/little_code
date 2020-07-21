function search(nums: number[], target: number): number {
  let len = nums.length
  for (let i = 0; i < len; i++) {
    if (target <= nums[i]) {
      return i
    }
  }
  return len
}
