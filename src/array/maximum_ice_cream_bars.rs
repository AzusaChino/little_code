use crate::Solution;

impl Solution {
    pub fn max_ice_cream(costs: Vec<i32>, coins: i32) -> i32 {
        let mut costs = costs;
        costs.sort();
        let mut cnt: i32 = 0;
        let mut coins = coins;
        for c in costs {
            if coins > 0 {
                if coins >= c {
                    coins -= c;
                    cnt += 1;
                }
            } else {
                break;
            }
        }
        cnt
    }
}

#[cfg(test)]
mod tests {
    use super::Solution;
    #[test]
    fn test_max() {
        let costs = vec![10, 6, 8, 7, 7, 8];
        println!("{}", Solution::max_ice_cream(costs, 5));
    }
}
