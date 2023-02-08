use crate::Solution;

impl Solution {
    pub fn jump(nums: Vec<i32>) -> i32 {
        let len: i32 = nums.len() as i32;
        if len == 1 {
            return 0;
        }

        let (mut need_choose, mut can_reach, mut step) = (0, 0, 0);
        for (i, n) in nums.iter().enumerate() {
            let ii = i as i32;
            if ii + *n > can_reach {
                can_reach = ii + *n;
                if can_reach >= len - 1 {
                    return step + 1;
                }
            }
            if ii == need_choose {
                need_choose = can_reach;
                step += 1;
            }
        }
        step
    }
}

#[cfg(test)]
mod tests {
    use super::Solution;

    #[test]
    fn test() {
        let nums = vec![2, 3, 1, 1, 4];
        assert_eq!(2, Solution::jump(nums));
    }
}
