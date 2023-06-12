use std::collections::HashMap;

use crate::Solution;

impl Solution {
    pub fn check_subarray_sum(nums: Vec<i32>, k: i32) -> bool {
        let mut map = HashMap::<i32, i32>::new();
        let mut sum = 0;
        for (i, n) in nums.iter().enumerate() {
            sum += n;
            let kk = sum % k;
            if let std::collections::hash_map::Entry::Vacant(e) = map.entry(kk) {
                e.insert((i as i32) + 1);
            } else if map[&kk] < i as i32 {
                return true;
            }
        }
        false
    }
}

#[cfg(test)]
mod tests {
    use super::Solution;

    #[test]
    fn test() {
        let _ = Solution::default();
    }
}
