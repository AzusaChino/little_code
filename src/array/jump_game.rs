use crate::Solution;

impl Solution {
    pub fn can_jump(nums: Vec<i32>) -> bool {
        let len = nums.len() as i32;
        let mut step = nums[0];
        for (i, v) in nums.iter().skip(1).enumerate() {
            let ii = i as i32;
            // before hand step cannot reach current index
            if ii > step {
                return false;
            }
            
            step = step.max(ii + v);
            if step == len - 1 {
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
        let nums = vec![2, 3, 1, 1, 4];
        println!("{}", Solution::can_jump(nums));
    }
}
