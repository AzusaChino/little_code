use crate::Solution;

impl Solution {
    pub fn convert(s: String, num_rows: i32) -> String {
        // 0 - n
        let mut zigzags: Vec<_> = (0..num_rows)
        // n - 0
            .chain((1..num_rows - 1).rev())
            // infinite loop
            .cycle()
            // combine with string
            .zip(s.chars())
            .collect();
        // [('a', 0), ('b', 1)] ...
        zigzags.sort_by_key(|&(row, _)| row);
        zigzags.into_iter().map(|(_, c)| c).collect()
    }
}

#[cfg(test)]
mod tests {
    use super::Solution;

    #[test]
    fn test() {
        let num_rows = 3;
        let s = String::from("abcds");
        println!("{:?}", Solution::convert(s, num_rows));
    }
}
