use crate::Solution;

impl Solution {
    pub fn max_profit(prices: Vec<i32>) -> i32 {
        let n = prices.len();
        let mut dp: Vec<[i32; 2]> = Vec::with_capacity(n);
        for i in 0..n {
            dp.push([0, 0]);
            if i == 0 {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = dp[i - 1][0].max(dp[i - 1][1] + prices[i]);
            dp[i][1] = dp[i - 1][1].max(-prices[i]);
        }
        dp[n - 1][0]
    }
}

#[cfg(test)]
mod tests {
    use super::Solution;

    #[test]
    fn test() {
        let prices = vec![7, 1, 5, 3, 6, 4];
        println!("{}", Solution::max_profit(prices));
    }
}
