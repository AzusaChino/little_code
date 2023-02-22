use std::rc::Rc;

use crate::Solution;

impl Solution {
    pub fn ship_within_days(weights: Vec<i32>, days: i32) -> i32 {
        let (mut min, mut max) = weights.iter().fold((i32::MIN, 0), |mut acc, &v| {
            acc.1 += v;
            acc.0 = i32::max(acc.0, v);
            acc
        });

        fn f(weights: Rc<Vec<i32>>, cap: i32, mut limit: i32) -> bool {
            let (mut l, mut r) = (0, cap);
            while l < weights.len() {
                if r >= weights[l] {
                    r -= weights[l];
                    l += 1;
                } else {
                    r = cap;
                    limit -= 1;
                }
                if limit == 0 {
                    return false;
                }
            }
            true
        }
        let weights = Rc::new(weights);
        while min < max {
            let mid = min + (max - min) / 2;
            if f(weights.clone(), mid, days) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        min
    }
}

#[cfg(test)]
mod tests {
    use super::Solution;

    #[test]
    fn test() {
        let weights = vec![1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
        println!("{}", Solution::ship_within_days(weights, 5));
    }
}
