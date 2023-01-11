use std::collections::HashMap;

use crate::Solution;

impl Solution {
    pub fn coin_change(coins: Vec<i32>, amount: i32) -> i32 {
        // 输入一个目标金额n，返回凑出n的最少硬币数
        fn dp(coins: &Vec<i32>, n: i32) -> i32 {
            if n < 0 {
                return -1;
            }
            if n == 0 {
                return 0;
            }
            let mut ret: i32 = std::i32::MAX;
            // 递归树
            for c in coins {
                let sub = dp(&coins, n - *c);
                if sub == -1 {
                    continue;
                }
                ret = ret.min(1 + sub);
            }
            if ret != std::i32::MAX {
                ret
            } else {
                -1
            }
        }

        dp(&coins, amount)
    }

    pub fn coin_change2(coins: Vec<i32>, amount: i32) -> i32 {
        let mut map = HashMap::<i32, i32>::new();

        // 输入一个目标金额n，返回凑出n的最少硬币数
        fn dp(map: &mut HashMap<i32, i32>, coins: &Vec<i32>, n: i32) -> i32 {
            if map.contains_key(&n) {
                return map[&n];
            }

            if n < 0 {
                return -1;
            }
            if n == 0 {
                return 0;
            }
            let mut ret: i32 = std::i32::MAX;
            for c in coins {
                let sub = dp(map, coins, n - *c);
                if sub == -1 {
                    continue;
                }
                ret = ret.min(1 + sub);
            }
            let r = if ret != std::i32::MAX { ret } else { -1 };
            map.insert(n, r);
            r
        }

        dp(&mut map, &coins, amount)
    }

    pub fn coin_change3(coins: Vec<i32>, amount: i32) -> i32 {
        let len = amount as usize;
        let mut dp = vec![amount + 1; len + 1];

        // base case
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

        if dp[len] == amount + 1 {
            -1
        } else {
            dp[len]
        }
    }
}

#[cfg(test)]
mod tests {

    #[test]
    fn test() {
        let coins = vec![1, 2, 5];
        let amount = 11;
        println!("{}", super::Solution::coin_change(coins.clone(), amount));
        println!("{}", super::Solution::coin_change2(coins.clone(), amount));
        println!("{}", super::Solution::coin_change3(coins.clone(), amount));
    }
}
