use crate::Solution;

impl Solution {
    pub fn max_area_of_island(grid: Vec<Vec<i32>>) -> i32 {
        let mut ret = 0;
        let mut grid = grid;
        for i in 0..grid.len() as i32 {
            for j in 0..grid[0].len() as i32 {
                let ii = i as usize;
                let jj = j as usize;
                if grid[ii][jj] == 1 {
                    ret = ret.max(Self::_sink_for_max_area(&mut grid, i, j))
                }
            }
        }
        ret
    }

    fn _sink_for_max_area(grid: &mut Vec<Vec<i32>>, x: i32, y: i32) -> i32 {
        if x < 0 || x >= grid.len() as i32 || y < 0 || y >= grid[0].len() as i32 {
            return 0;
        }
        let xx = x as usize;
        let yy = y as usize;
        if grid[xx][yy] == 0 {
            return 0;
        }

        grid[xx][yy] = 0;

        1 + Self::_sink_for_max_area(grid, x - 1, y)
            + Self::_sink_for_max_area(grid, x + 1, y)
            + Self::_sink_for_max_area(grid, x, y - 1)
            + Self::_sink_for_max_area(grid, x, y + 1)
    }
}

#[cfg(test)]
mod tests {
    use super::Solution;

    #[test]
    fn test() {
        let grid = vec![
            vec![0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0],
            vec![0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0],
            vec![0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0],
            vec![0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0],
            vec![0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0],
            vec![0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0],
            vec![0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0],
            vec![0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0],
        ];

        println!("{}", Solution::max_area_of_island(grid));

        let 图 = vec![vec![0, 0, 0, 0, 0, 0, 0]];

        println!("{}", Solution::max_area_of_island(图));
    }
}
