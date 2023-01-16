use crate::Solution;

impl Solution {
    pub fn insert(intervals: Vec<Vec<i32>>, new_interval: Vec<i32>) -> Vec<Vec<i32>> {
        let mut x = new_interval[0];
        let mut y = new_interval[1];
        let mut ret: Vec<Vec<i32>> = vec![];
        let mut index: usize = 0;

        while index < intervals.len() && intervals[index][1] < x {
            ret.push(intervals[index].clone());
            index += 1;
        }

        while index < intervals.len() && intervals[index][0] <= y {
            x = x.min(intervals[index][0]);
            y = y.max(intervals[index][1]);
            index += 1;
        }

        ret.push(vec![x, y]);

        for i in index..intervals.len() {
            ret.push(intervals[i].clone());
        }
        ret
    }
}

#[cfg(test)]
mod tests {
    use super::Solution;
    use crate::convert_slice_vec;

    #[test]
    fn test() {
        let slc = [[1, 3], [6, 9]];
        let new_interval = vec![2, 5];
        println!(
            "{:?}",
            Solution::insert(convert_slice_vec(&slc), new_interval)
        );
    }

    #[test]
    fn test2() {
        let slc = [[1, 2], [3, 5], [6, 7], [8, 10], [12, 16]];
        let new_interval = vec![4, 8];
        println!(
            "{:?}",
            Solution::insert(convert_slice_vec(&slc), new_interval)
        );
    }
}
