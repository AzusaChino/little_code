use crate::Solution;

const DIR: [[i32; 2]; 4] = [[0, 1], [0, -1], [1, 0], [-1, 0]];

impl Solution {
    pub fn island_perimeter(grid: Vec<Vec<i32>>) -> i32 {
        let mut ret = 0;

        for i in 0..grid.len() as i32 {
            for j in 0..grid[0].len() as i32 {
                let ii = i as usize;
                let jj = j as usize;
                // at every land, check four directions to see if there are islands near by
                if grid[ii][jj] == 1 {
                    for d in DIR {
                        let (x, y) = (i + d[0], j + d[1]);
                        if x < 0
                            || y < 0
                            || x >= grid.len() as i32
                            || y >= grid[0].len() as i32
                            || grid[x as usize][y as usize] == 0
                        {
                            ret += 1;
                        }
                    }
                }
            }
        }
        ret
    }
}

#[cfg(test)]
mod tests {
    use super::Solution;

    #[test]
    fn test() {
        let grid = vec![
            vec![0, 1, 0, 0],
            vec![1, 1, 1, 0],
            vec![0, 1, 0, 0],
            vec![1, 1, 0, 0],
        ];
        println!("{}", Solution::island_perimeter(grid));
    }
}
