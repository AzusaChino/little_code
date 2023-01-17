use crate::Solution;

impl Solution {
    pub fn count_odds(low: i32, high: i32) -> i32 {
        if low % 2 == 0 && high % 2 == 0 {
            return (high - low) / 2;
        } else {
            return 1 + ((high - low) / 2);
        }
    }
}

#[cfg(test)]
mod tests {
    use super::Solution;

    #[test]
    fn test() {
        println!("{}", Solution::count_odds(3, 7));
        println!("{}", Solution::count_odds(8, 10));
    }
}
