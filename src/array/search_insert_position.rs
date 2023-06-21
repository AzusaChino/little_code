use crate::Solution;

impl Solution {
    pub fn search_insert(nums: Vec<i32>, target: i32) -> i32 {
        let (mut l, mut r) = (0usize, nums.len() - 1);

        while l <= r {
            let mid = l + (r - l) / 2;

            if nums[mid] >= target {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        l as i32
    }
}
