package cn.az.code.year2021.apr;

/**
  * @author az
  * @since 2021-04-06
  */
public class MinimumOperationsMakeArrayEqual {
    public int minOperations(int n) {
        int op = 0;
        int odd = 1;
        while(odd < n) {
            op += n - odd;
            odd += 2;
        }
        return op;
    }
}