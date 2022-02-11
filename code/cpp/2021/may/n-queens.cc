#include <string>
#include <vector>

using namespace std;

class Solution {
public:
    vector<vector<string>> solveNQueens(int n) {
        vector<vector<string>> res;
        vector<string>         nQueens(n, string(n, '.'));
        solveNQueens(res, nQueens, 0, n);
        return res;
    }

private:
    void solveNQueens(vector<vector<string>> &res, vector<string> &nQueens,
                      int row, int &n) {
        if (row == n) {
            res.push_back(nQueens);
            return;
        }
        for (int col = 0; col != n; ++col)
            if (isValid(nQueens, row, col, n)) {
                nQueens[row][col] = 'Q';
                solveNQueens(res, nQueens, row + 1, n);
                nQueens[row][col] = '.';
            }
    }
    bool isValid(vector<string> &nQueens, int row, int col, int &n) {
        // check if the column had a queen before.
        for (int i = 0; i != row; ++i)
            if (nQueens[i][col] == 'Q') return false;
        // check if the 45° diagonal had a queen before.
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; --i, --j)
            if (nQueens[i][j] == 'Q') return false;
        // check if the 135° diagonal had a queen before.
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; --i, ++j)
            if (nQueens[i][j] == 'Q') return false;
        return true;
    }
};

class _Solution {
public:
    std::vector<std::vector<std::string>> solveNQueens(int n) {
        std::vector<std::vector<std::string>> res;
        std::vector<std::string>              nQueens(n, std::string(n, '.'));
        /*
        flag[0] to flag[n - 1] to indicate if the column had a queen before.
        flag[n] to flag[3 * n - 2] to indicate if the 45° diagonal had a queen
        before. flag[3 * n - 1] to flag[5 * n - 3] to indicate if the 135°
        diagonal had a queen before.
        */
        std::vector<int> flag(5 * n - 2, 1);
        solveNQueens(res, nQueens, flag, 0, n);
        return res;
    }

private:
    void solveNQueens(std::vector<std::vector<std::string>> &res,
                      std::vector<std::string> &nQueens, std::vector<int> &flag,
                      int row, int &n) {
        if (row == n) {
            res.push_back(nQueens);
            return;
        }
        for (int col = 0; col != n; ++col)
            if (flag[col] && flag[n + row + col] &&
                flag[4 * n - 2 + col - row]) {
                flag[col] = flag[n + row + col] = flag[4 * n - 2 + col - row] =
                    0;
                nQueens[row][col] = 'Q';
                solveNQueens(res, nQueens, flag, row + 1, n);
                nQueens[row][col] = '.';
                flag[col] = flag[n + row + col] = flag[4 * n - 2 + col - row] =
                    1;
            }
    }
};