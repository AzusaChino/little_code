use crate::Solution;

impl Solution {
    pub fn my_atoi(s: String) -> i32 {
        let s = s.trim_start();
        if s.is_empty() {
            return 0;
        }

        let (s, sign) = match s.strip_prefix('-') {
            Some(s) => (s, -1),
            // incase of postive indicator
            None => (s.strip_prefix('+').unwrap_or(s), 1),
        };

        s.chars()
            .map(|c| c.to_digit(10))
            .flatten()
            .fold(0, |acc, d| {
                acc.saturating_mul(10).saturating_add(sign * d as i32)
            })
    }
}

#[cfg(test)]
mod tests {
    use super::Solution;

    #[test]
    fn test() {
        println!("{}", Solution::my_atoi("   -43".to_owned()));
        println!("{}", Solution::my_atoi("words and 987".to_owned()));
    }
}
