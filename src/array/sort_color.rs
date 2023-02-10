use crate::Solution;

impl Solution {
    pub fn sort_colors(nums: &mut Vec<i32>) {
        let (mut zero, mut one) = (0, 0);
        for i in 0..nums.len() {
            let n = nums[i];
            nums[i] = 2;
            // 匹配 0 & 1
            if n <= 1 {
                nums[one] = 1;
                one += 1;
            }
            // 匹配 0
            if n == 0 {
                nums[zero] = 0;
                zero += 1;
            }
        }
    }
}

#[cfg(test)]
mod tests {
    use super::Solution;

    #[test]
    fn test() {
        let mut nums = vec![2, 0, 2, 1, 1, 0];
        Solution::sort_colors(&mut nums);
        println!("{:?}", nums);
    }
}
