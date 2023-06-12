use crate::Solution;

impl Solution {
    pub fn can_complete_circuit(gas: Vec<i32>, cost: Vec<i32>) -> i32 {
        let mut start = 0;
        let mut total = 0;
        let mut tank = 0;
        let len = gas.len();

        for i in 0..len {
            tank += gas[i] - cost[i];
            if tank < 0 {
                start = i + 1;
                total += tank;
                tank = 0;
            }
        }

        // calculate final total tanks (if enough to complete)
        if total + tank < 0 {
            return -1;
        }
        start as i32
    }
}

#[cfg(test)]
mod tests {
    use super::Solution;
    #[test]
    fn test() {
        let gas = vec![2, 3, 4];
        let cost = vec![3, 4, 3];
        let r = Solution::can_complete_circuit(gas, cost);
        println!("{}", r);
    }
}
