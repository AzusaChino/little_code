use crate::Solution;

impl Solution {
    pub fn minimum_time(time: Vec<i32>, total_trips: i32) -> i64 {
        let mut ng = 0;
        let mut ok = 10i64.pow(14) + 10;
        let total_trips = total_trips as i64;
        while ng + 1 < ok {
            let mid = (ng + ok) / 2;
            let mut temp = 0;
            for it in time.iter() {
                temp += mid / *it as i64;
            }
            if total_trips <= temp {
                ok = mid;
            } else {
                ng = mid;
            }
        }

        ok
    }
}

#[cfg(test)]
mod tests {
    use super::Solution;

    #[test]
    fn test() {
        let time = vec![1, 2, 3];
        println!("{}", Solution::minimum_time(time, 5));
    }
}
