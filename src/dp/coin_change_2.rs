use crate::Solution;

impl Solution {
    pub fn change(amount: i32, coins: Vec<i32>) -> i32 {
        let mut coins = coins;
        coins.sort();
        let mut v = vec![0; (amount + 1) as usize];
        // The reason for this is that if we have 0 amount, the only way to make that amount is to not use any coin at all. So there is 1 way to make 0 using 0 coins,
        // which is the base case and represents the foundation of the recursive steps.
        v[0] = 1;
        for c in coins {
            for i in c..amount + 1 {
                v[i as usize] += v[(i - c) as usize];
            }
        }
        v[amount as usize]
    }
}
