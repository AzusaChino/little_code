use crate::Solution;

impl Solution {
    pub fn single_non_duplicate(nums: Vec<i32>) -> i32 {
        let (mut l, mut r) = (0usize, nums.len() - 1);
        while l < r {
            let mid = l + (r - l) / 2;
            // Simply find the first index whose "partner index" (the index xor 1) holds a different value.
            if nums[mid] == nums[mid ^ 1] {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        nums[l]
    }
}

#[cfg(test)]
mod tests {
    use super::Solution;

    #[test]
    fn test() {
        let nums = vec![1, 1, 2, 3, 3, 4, 4, 8, 8];
        println!("{}", Solution::single_non_duplicate(nums));
        // odd - 1, even + 1
        println!("{}, {}", 5 ^ 1, 6 ^ 1);
    }
}
