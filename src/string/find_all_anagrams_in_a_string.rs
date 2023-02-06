use crate::Solution;

const SIZE: usize = 26;

impl Solution {
    pub fn find_anagrams(s: String, p: String) -> Vec<i32> {
        // Closure to (hopefully, elegantly) convert char into its counter position:
        let cc = 'a' as u8;
        let idx = |c: u8| (c - cc) as usize;

        // Create the anagram's counter:
        let mut anagram = [0u8; SIZE];
        for c in p.as_bytes() {
            anagram[idx(*c)] += 1;
        }

        let mut indices = Vec::new();
        // Create the counter for the sliding window on s:
        let mut window = [0u8; SIZE];

        // Convert to byte array for direct access and no more Option<char>:
        let s: &[u8] = s.as_bytes();
        for right in 0..s.len() {
            window[idx(s[right])] += 1;
            if right >= p.len() - 1 {
                let left = right - p.len() + 1;
                if anagram == window {
                    indices.push(left as i32);
                }
                window[idx(s[left])] -= 1;
            }
        }
        indices
    }
}

#[cfg(test)]
mod tests {
    use super::Solution;

    #[test]
    fn test() {
        let s = "cbaebabacd".to_string();
        let p = "abc".to_string();

        assert_eq!(vec![0, 6], Solution::find_anagrams(s, p));
    }
}
