use std::collections::HashMap;

use crate::Solution;

impl Solution {
    pub fn check_inclusion(s1: String, s2: String) -> bool {
        let mut d1: [usize; 26] = [0; 26];
        let mut d2: [usize; 26] = [0; 26];
        for c in s1.chars() {
            d1[(c as u8 - b'a') as usize] += 1;
        }
        let s: &[u8] = s2.as_bytes();
        for (i, c) in s.iter().enumerate() {
            d2[(c - b'a') as usize] += 1;
            if i >= s1.len() {
                // eiab ab -> clean ei
                d2[(s[i - s1.len()] - b'a') as usize] -= 1;
            }
            if d1 == d2 {
                return true;
            }
        }
        false
    }

    pub fn _check_inclusion(s1: String, s2: String) -> bool {
        let mut map = HashMap::<u8, i32>::new();
        for b in s1.as_bytes() {
            map.entry(*b)
                .and_modify(|v| {
                    *v += 1;
                })
                .or_insert(1);
        }
        for i in 0..s2.len() {
            let b = s2.as_bytes()[i];
            if map.contains_key(&b) {
                let mut _mp = map.clone();
                for j in 0..s1.len() {
                    // loop to check permutation
                    let id = i + j;
                    if id >= s2.len() {
                        break;
                    }
                }
            }
        }
        false
    }
}

#[cfg(test)]
mod tests {
    use super::Solution;

    #[test]
    fn test() {
        println!(
            "{}",
            Solution::check_inclusion("ab".to_string(), "eiabcads".to_string())
        );
    }
}
