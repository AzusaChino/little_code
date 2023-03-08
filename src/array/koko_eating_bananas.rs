use crate::Solution;

impl Solution {
    pub fn min_eating_speed(piles: Vec<i32>, h: i32) -> i32 {
        let (mut left, mut right) = (1i32, 1000000001);
        while left < right {
            let mid = left + (right - left) / 2;
            if f(&piles, mid) <= h {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        fn f(piles: &Vec<i32>, x: i32) -> i32 {
            let mut hours = 0;
            for i in piles {
                hours += i / x;
                if i % x > 0 {
                    hours += 1;
                }
            }
            hours
        }
        left
    }
}

#[cfg(test)]
mod tests {
    use super::Solution;

    #[test]
    fn test() {
        let piles = vec![30,11,23,4,20];
        println!("{}", Solution::min_eating_speed(piles, 5));
    }
}
