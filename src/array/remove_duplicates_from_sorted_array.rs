use crate::Solution;

impl Solution {
    pub fn remove_duplicates(nums: &mut Vec<i32>) -> i32 {
        if nums.is_empty() {
            return 0;
        }
        let (mut last, mut finder) = (0, 0);

        while last < nums.len() - 1 {
            while nums[finder] == nums[last] {
                finder += 1;
                if finder == nums.len() {
                    return (last + 1) as i32;
                }
            }
            nums[last + 1] = nums[finder];
            last += 1;
        }

        (last + 1) as i32
    }
}

#[cfg(test)]
mod tests {
    use super::Solution;

    #[test]
    fn test() {
        let mut nums = vec![1, 1, 2];
        println!("{}", Solution::remove_duplicates(&mut nums));
    }
}
