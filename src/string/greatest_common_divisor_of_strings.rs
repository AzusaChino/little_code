use crate::Solution;

impl Solution {
    pub fn gcd_of_strings(str1: String, str2: String) -> String {
        fn gcd(a: usize, b: usize) -> usize {
            match b > 0 {
                true => gcd(b, a % b),
                false => a,
            }
        }

        match str1
            .chars()
            .chain(str2.chars())
            .eq(str2.chars().chain(str1.chars()))
        {
            true => str1.chars().take(gcd(str1.len(), str2.len())).collect(),
            false => "".to_string(),
        }
    }
}

#[cfg(test)]
mod tests {
    use super::Solution;

    #[test]
    fn test() {
        println!(
            "{}",
            Solution::gcd_of_strings(String::from("ABABAB"), String::from("ABAB"))
        );
    }
}
