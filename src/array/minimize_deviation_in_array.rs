use crate::Solution;

impl Solution {
    fn minimum_deviation(nums: Vec<i32>) -> i32 {
        let mut pq = std::collections::BinaryHeap::new();
        // let n = nums.len();
        let (mut min, mut ret) = (i32::MAX, i32::MAX);
        for num in nums {
            let mut tmp = num;
            if tmp % 2 == 1 {
                tmp *= 2;
            }
            pq.push(std::cmp::Reverse(-tmp));
            min = min.min(tmp);
        }
        loop {
            let num = -pq.pop().expect("not ok").0;
            ret = ret.min(num - min);
            if num % 2 == 1 {
                break;
            }
            min = min.min(num / 2);
            pq.push(std::cmp::Reverse(-num / 2));
        }
        ret
    }
}

#[cfg(test)]
mod tests {
    use super::Solution;

    #[test]
    fn test() {
        let nums = vec![1, 2, 3, 4];
        println!("{}", Solution::minimum_deviation(nums));
    }
}
