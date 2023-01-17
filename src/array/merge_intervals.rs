use crate::Solution;

impl Solution {
    pub fn merge(intervals: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        let mut v: Vec<Vec<i32>> = vec![];
        if intervals.is_empty() {
            return v;
        }

        let mut intervals = intervals;
        intervals.sort_by_key(|k| k[0]);

        for it in intervals {
            if v.is_empty() || v.last().unwrap()[1] < it[0] {
                v.push(it.clone());
            } else {
                v.last_mut().unwrap()[1] = v.last().unwrap()[1].max(it[1]);
            }
        }
        v
    }
}

#[cfg(test)]
mod tests {
    use super::Solution;
    use crate::convert_slice_vec;

    #[test]
    fn test() {
        let slc = [[1, 3], [2, 6], [8, 10], [15, 18]];
        println!("{:?}", Solution::merge(convert_slice_vec(&slc)));
    }
}
