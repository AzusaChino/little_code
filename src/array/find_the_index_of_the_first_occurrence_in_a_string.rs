use crate::Solution;

impl Solution {
    pub fn str_str(haystack: String, needle: String) -> i32 {
        for i in 0usize.. {
            for j in 0usize.. {
                if j == needle.len() {
                    return i as i32;
                }
                if i + j == haystack.len() {
                    return -1;
                }
                if haystack.as_bytes()[i + j] != needle.as_bytes()[j] {
                    break;
                }
            }
        }
        -1
    }
}

#[cfg(test)]
mod tests {
    use super::Solution;

    #[test]
    fn test() {
        let haystack = "sadbutsad".to_owned();
        let needle = "sad".to_owned();
        println!("{}", Solution::str_str(haystack, needle));
    }
}
