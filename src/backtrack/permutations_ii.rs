use crate::Solution;

impl Solution {
    pub fn permute_ii(nums: Vec<i32>) -> Vec<Vec<i32>> {
        let mut nums = nums;
        nums.sort();

        let mut ret: Vec<Vec<i32>> = Vec::new();
        let mut tmp: Vec<i32> = Vec::new();
        let mut visited: Vec<bool> = vec![false; nums.len()];

        fn dfs(
            nums: &Vec<i32>,
            tmp: &mut Vec<i32>,
            visited: &mut Vec<bool>,
            ret: &mut Vec<Vec<i32>>,
        ) {
            if tmp.len() == nums.len() {
                ret.push(tmp.to_owned());
            } else {
                for i in 0..nums.len() {
                    // skip visited,
                    if visited[i] || (i > 0 && !visited[i - 1] && nums[i] == nums[i - 1]) {
                        continue;
                    }
                    visited[i] = true;
                    tmp.push(nums[i]);
                    dfs(nums, tmp, visited, ret);
                    tmp.pop();
                    visited[i] = false;
                }
            }
        }
        dfs(&nums, &mut tmp, &mut visited, &mut ret);
        ret
    }
}

#[cfg(test)]
mod tests {
    use super::Solution;

    #[test]
    fn test() {
        let nums = vec![1, 1, 2];
        println!("{:?}", Solution::permute_ii(nums));
    }
}
