use crate::Solution;

impl Solution {
    pub fn find_kth_positive(arr: Vec<i32>, k: i32) -> i32 {
        let mut k = k;
        for i in arr {
            if i <= k {
                k += 1;
            }
        }
        k
    }
}

#[cfg(test)]
mod tests {
    use super::Solution;

    #[test]
    fn test() {
        let arr = vec![2, 3, 4, 7, 11];
        println!("{}", Solution::find_kth_positive(arr, 5));
    }
}
