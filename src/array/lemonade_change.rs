use crate::Solution;

impl Solution {
    pub fn lemonade_change(bills: Vec<i32>) -> bool {
        let mut five_cnt = 0;
        let mut ten_cnt = 0;
        for i in bills {
            if i == 5 {
                five_cnt += 1;
            } else if i == 10 {
                if five_cnt > 0 {
                    ten_cnt += 1;
                    five_cnt -= 1;
                } else {
                    return false;
                }
            } else {
                if ten_cnt >= 1 && five_cnt >= 1 {
                    ten_cnt -= 1;
                    five_cnt -= 1;
                } else if five_cnt >= 3 {
                    five_cnt -= 3;
                } else {
                    return false;
                }
            }
        }
        true
    }
}

#[cfg(test)]
mod tests {
    use crate::Solution;

    #[test]
    fn test() {
        // let bills = vec![5, 5, 5, 10, 20];
        let bills = vec![5, 5, 10, 10, 20];
        println!("{}", Solution::lemonade_change(bills));
    }
}
