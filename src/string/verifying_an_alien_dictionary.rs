use crate::Solution;

impl Solution {
    pub fn is_alien_sorted(words: Vec<String>, order: String) -> bool {
        let order = order
            .as_bytes()
            .iter()
            .enumerate()
            .fold([0; 26], |mut acc, (i, b)| {
                acc[(b - b'a') as usize] = i;
                acc
            });
        words
            .iter()
            .map(|s| {
                s.as_bytes()
                    .iter()
                    .map(|&b| order[(b - b'a') as usize])
                    .collect::<Vec<_>>()
            })
            .collect::<Vec<_>>()
            .windows(2)
            .all(|words| words[0] <= words[1])
    }
}

#[cfg(test)]
mod tests {
    use super::Solution;

    #[test]
    fn test() {
        println!("{}", Solution::default());
    }
}
