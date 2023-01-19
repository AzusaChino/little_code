use crate::Solution;

impl Solution {
    pub fn subarrays_div_by_k(nums: Vec<i32>, k: i32) -> i32 {
        let mut v = vec![0; nums.len() + 1];
        for i in 0..nums.len() {
            v[i + 1] = v[i] + nums[i];
        }

        let mut cnt = vec![0; k as usize];
        for i in v {
            let id = (i % k + k) % k;
            cnt[id as usize] += 1;
        }

        let mut ret = 0;
        for i in cnt {
            ret += (i - 1) * i / 2;
        }
        ret
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
