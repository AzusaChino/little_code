use crate::Solution;

impl Solution {
    pub fn zero_filled_subarray(nums: Vec<i32>) -> i64 {
        let mut ret = 0i64;
        let (mut i, mut j) = (0, 0);
        while i < nums.len() {
            if nums[i] != 0 {
                j = i + 1;
            }
            ret += (i - j) as i64 + 1;
            i += 1;
        }
        ret
    }
}

#[cfg(test)]
mod tests {
    use super::Solution;

    #[test]
    fn test() {
        let nums = vec![1, 0, 0, 1, 0, 0, 1];
        println!("{}", Solution::zero_filled_subarray(nums));
    }
}
