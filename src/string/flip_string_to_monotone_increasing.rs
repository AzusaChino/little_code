use crate::Solution;

impl Solution {
    pub fn min_flips_mono_incr(s: String) -> i32 {
        let (mut one, mut flip): (i32, i32) = (0, 0);
        for ch in s.as_bytes() {
            // '0'
            if *ch == 48 {
                flip = one.min(flip + 1);
            } else {
                // count '1'
                one += 1;
            }
            // println!("{}, {}", flip, one);
        }
        flip
    }
}

#[cfg(test)]
mod tests {
    use super::Solution;

    #[test]
    fn test() {
        let s = String::from("00011000");
        println!("{}", Solution::min_flips_mono_incr(s));
    }
}
