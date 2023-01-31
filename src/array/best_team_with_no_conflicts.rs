use crate::Solution;

impl Solution {
    pub fn best_team_score(scores: Vec<i32>, ages: Vec<i32>) -> i32 {
        let l = ages.len();
        let mut players: Vec<(i32, i32)> = Vec::new();
        for i in 0..l {
            players.push((ages[i], scores[i]));
        }
        players.sort_by(|a, b| b.0.cmp(&a.0));

        let mut ret = 0;
        let mut dp = vec![-1; l];
        for i in 0..l {
            let score = players[i].1;
            dp[i] = score;
            for j in 0..i {
                if players[j].1 >= players[i].1 {
                    dp[i] = dp[i].max(dp[j] + score);
                }
            }
            ret = ret.max(dp[i]);
        }
        ret
    }
}

#[cfg(test)]
mod tests {
    use super::Solution;

    #[test]
    fn test() {
        let scores = vec![1,3,5,10,15];
        let ages = vec![1,2,3,4,5];
        println!("{}", Solution::best_team_score(scores, ages));
    }
}
