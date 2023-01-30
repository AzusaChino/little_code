use crate::Solution;

impl Solution {
    pub fn find_judge(n: i32, trust: Vec<Vec<i32>>) -> i32 {
        if n == 1 {
            return n;
        }

        let mut counter = vec![0; (n + 1) as usize];
        trust.iter().for_each(|pair| {
            counter[pair[0] as usize] -= 1;
            counter[pair[1] as usize] += 1;
        });

        counter
            .iter()
            .position(|&num| num == n - 1)
            .map_or(-1, |i| i as i32)
    }
}

#[cfg(test)]
mod tests {
    use super::Solution;

    #[test]
    fn test() {
        let v = vec![vec![1, 3], vec![2, 3]];
        println!("{}", Solution::find_judge(3, v));
    }
}
