use crate::Solution;

impl Solution {
    pub fn shuffle(nums: Vec<i32>, n: i32) -> Vec<i32> {
        let mut ret = Vec::with_capacity((2 * n) as usize);
        for i in 0..n {
            let x = i as usize;
            let y = (n + i) as usize;
            ret.push(nums[x]);
            ret.push(nums[y]);
        }
        ret
    }
}

#[cfg(test)]
mod tests {
    use super::Solution;

    #[test]
    fn test() {
        let nums = vec![2, 5, 1, 3, 4, 7];
        let n = 3;

        assert_eq!(vec![2, 3, 5, 4, 1, 7], Solution::shuffle(nums, n));
    }
}
