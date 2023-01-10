use crate::Solution;
use std::collections::HashMap;

impl Solution {
    pub fn two_sum(nums: Vec<i32>, target: i32) -> Vec<i32> {
        let mut map = HashMap::<i32, i32>::new();
        // record value->index
        for (i, n) in nums.iter().enumerate() {
            let current_target = target - n;
            if map.contains_key(&current_target) {
                return vec![i as i32, *map.get(&current_target).unwrap()];
            }
            map.insert(*n, i as i32);
        }
        return vec![-1, -1];
    }
}

#[cfg(test)]
mod tests {

    use super::Solution;

    #[test]
    fn test() {
        let v = vec![3, 2, 4];
        println!("{:?}", Solution::two_sum(v, 6));
    }
}
