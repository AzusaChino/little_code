use crate::Solution;

impl Solution {
    pub fn solve(board: &mut Vec<Vec<char>>) {
        let (m, n) = (board.len(), board[0].len());
        // deal with edge
        for r in 0..m {
            if board[r][0] == 'O' {
                Self::sink_for_solve(board, r as i32, 0);
            }
            if board[r][n - 1] == 'O' {
                Self::sink_for_solve(board, r as i32, (n - 1) as i32);
            }
        }

        for c in 0..n {
            if board[0][c] == 'O' {
                Self::sink_for_solve(board, 0, c as i32);
            }
            if board[m - 1][c] == 'O' {
                Self::sink_for_solve(board, (m - 1) as i32, c as i32);
            }
        }

        for i in 0..m {
            for j in 0..n {
                if board[i][j] == 'O' {
                    board[i][j] = 'X';
                } else if board[i][j] == 'E' {
                    board[i][j] = 'O';
                }
            }
        }
    }

    fn sink_for_solve(board: &mut Vec<Vec<char>>, i: i32, j: i32) {
        let ii = i as usize;
        let jj = j as usize;
        // mark as edge
        board[ii][jj] = 'E';
        if i > 0 && board[(i - 1) as usize][jj] == 'O' {
            Self::sink_for_solve(board, i - 1, j);
        }
        if ii < board.len() - 1 && board[(i + 1) as usize][jj] == 'O' {
            Self::sink_for_solve(board, i + 1, j);
        }
        if j > 0 && board[ii][(j - 1) as usize] == 'O' {
            Self::sink_for_solve(board, i, j - 1);
        }
        if jj < board[0].len() - 1 && board[ii][(j + 1) as usize] == 'O' {
            Self::sink_for_solve(board, i, j + 1);
        }
    }
}

#[cfg(test)]
mod tests {
    use super::Solution;

    #[test]
    fn test() {
        let mut board = vec![
            vec!['X', 'X', 'X', 'X'],
            vec!['X', 'O', 'X', 'X'],
            vec!['X', 'O', 'X', 'X'],
            vec!['X', 'O', 'X', 'X'],
        ];

        Solution::solve(&mut board);

        println!("{:?}", board);
    }
}
