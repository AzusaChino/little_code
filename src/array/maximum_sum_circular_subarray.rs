use crate::Solution;

impl Solution {
    pub fn max_subarray_sum_circular(nums: Vec<i32>) -> i32 {
        let (mut so_far, mut ending) = (std::i32::MIN, 0);
        for i in &nums {
            ending += i;
            if so_far < ending {
                so_far = ending;
            }
            if ending < 0 {
                ending = 0;
            }
        }

        ending = 0;

        let mut v = vec![0; nums.len()];
        v[0] = nums[0];
        for i in 1..nums.len() {
            ending += nums[i];
            v[i] = v[i - 1].max(ending);
        }

        let mut cur = 0;
        for i in nums.len() - 1..0 {
            cur += nums[i];
            so_far = so_far.max(v[i - 1] + cur);
        }
        so_far
    }
}

#[cfg(test)]
mod tests {
    use super::Solution;

    #[test]
    fn test() {
        let _ = Solution::default();
        let nums = vec![5,-3,5];
        println!("{}", Solution::max_subarray_sum_circular(nums));
    }
}
