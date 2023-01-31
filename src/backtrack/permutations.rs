use crate::Solution;

impl Solution {
    pub fn permute(nums: Vec<i32>) -> Vec<Vec<i32>> {
        let mut ret: Vec<Vec<i32>> = Vec::new();
        let mut tmp: Vec<i32> = Vec::new();

        fn dfs(nums: &Vec<i32>, tmp: &mut Vec<i32>, ret: &mut Vec<Vec<i32>>) {
            if tmp.len() == nums.len() {
                ret.push(tmp.to_owned());
            } else {
                for n in nums {
                    // skip same value
                    if tmp.contains(n) {
                        continue;
                    }
                    tmp.push(*n);
                    dfs(nums, tmp, ret);
                    tmp.pop();
                }
            }
        }
        dfs(&nums, &mut tmp, &mut ret);
        ret
    }
}

#[cfg(test)]
mod tests {
    use super::Solution;

    #[test]
    fn test() {
        let nums = vec![1, 2, 3];
        println!("{:?}", Solution::permute(nums));
    }
}
