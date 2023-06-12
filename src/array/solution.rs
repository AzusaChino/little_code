#![allow(unused)]

#[derive(Debug, Default)]
struct Solution {}

impl Solution {
    pub fn count_negatives(grid: Vec<Vec<i32>>) -> i32 {
        let m = grid.len();
        let n = grid[0].len();
        let mut ans: i32 = 0;
        let mut r: i32 = (m - 1) as i32;
        let mut c: usize = 0;

        while r >= 0 && c < n {
            if grid[r as usize][c] < 0 {
                ans += (n - c) as i32;
                r -= 1;
            } else {
                c += 1;
            }
        }

        ans
    }
}
