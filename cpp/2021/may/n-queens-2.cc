class Solution
{
public:
    int totalNQueens(int n)
    {
        int ans = 0;
        int row = 0, leftDiagonal = 0, rightDiagonal = 0;
        int bit = (1 << n) - 1; //to clear high bits of the 32-bit int
        Queens(bit, row, leftDiagonal, rightDiagonal, ans);
        return ans;
    }
    void Queens(int bit, int row, int leftDiagonal, int rightDiagonal, int &ans)
    {
        int cur = (~(row | leftDiagonal | rightDiagonal)) & bit; //possible place for this queen
        if (!cur)
            return; //no pos for this queen
        while (cur)
        {
            int curPos = (cur & (~cur + 1)) & bit; //choose possible place in the right
            //update row,ld and rd
            row += curPos;
            if (row == bit)
                ans++; //last row
            else
                Queens(bit, row, ((leftDiagonal | curPos) << 1) & bit, ((rightDiagonal | curPos) >> 1) & bit, ans);
            cur -= curPos; //for next possible place
            row -= curPos; //reset row
        }
    }
};