use crate::Solution;

impl Solution {
    pub fn convert_time(current: String, correct: String) -> i32 {
        let coins = vec![1, 5, 15, 60];
        let amount = Solution::calc(current, correct);

        Solution::coin_change3(coins.clone(), amount);
        return Solution::local_coin_change(coins, amount);
    }

    fn local_coin_change(coins: Vec<i32>, amount: i32) -> i32 {
        let mut dp = vec![amount + 1; (amount + 1) as usize];
        dp[0] = 0;

        for i in 0..dp.len() {
            for c in &coins {
                let ii = i as i32;
                if ii - c < 0 {
                    continue;
                }
                dp[i] = dp[i].min(1 + dp[(ii - c) as usize]);
            }
        }
        if dp[amount as usize] == amount + 1 {
            -1
        } else {
            dp[amount as usize]
        }
    }

    fn calc(current: String, correct: String) -> i32 {
        Solution::convert(correct) - Solution::convert(current)
    }

    fn convert(time: String) -> i32 {
        let spts: Vec<&str> = time.split(":").collect();
        let mut ret: i32 = 0;
        ret += spts[0].parse::<i32>().unwrap() * 60;
        ret += spts[1].parse::<i32>().unwrap();
        ret
    }
}

#[cfg(test)]
mod tests {
    use crate::Solution;

    #[test]
    fn test() {
        let c = String::from("12:30");
        let t = String::from("14:35");
        println!("{}", Solution::convert_time(c, t));
    }

    #[test]
    fn test_convert() {
        let c = String::from("12:30");
        println!("{}", Solution::convert(c));
    }
}
