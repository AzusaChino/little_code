use crate::Solution;

impl Solution {
    pub fn compress(chars: &mut Vec<char>) -> i32 {
        let mut cnt_consecutive: u32 = 0;
        let n = chars.len();
        let mut index: usize = 0;
        for i in 0..n {
            cnt_consecutive += 1;
            if i + 1 == n || chars[i] != chars[i + 1] {
                chars[index] = chars[i];
                index += 1;
                if cnt_consecutive > 1 {
                    for ch in cnt_consecutive.to_string().as_str().chars() {
                        chars[index] = ch;
                        index += 1;
                    }
                }
                cnt_consecutive = 0;
            }
        }
        index as i32
    }
}

#[cfg(test)]
mod tests {
    use super::Solution;

    #[test]
    fn test() {
        let mut chars = vec!['a', 'a', 'b', 'b', 'c', 'c', 'c'];
        println!("{}", Solution::compress(&mut chars));
        println!("{:?}", chars)
    }
}
