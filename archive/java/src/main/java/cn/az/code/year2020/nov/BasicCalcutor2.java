package cn.az.code.year2020.nov;

/**
 * @author az
 * @since 11/24/20
 */
public class BasicCalcutor2 {

    public int calculate(String s) {
        s = s.replace(" ", "");
        String[] nums = s.split("[+\\-*/]");
        s = '+' + s;
        String[] ops = s.split("\\d+");
        int last = 1;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int n = Integer.parseInt(nums[i]);
            char op = ops[i].charAt(0);
            if ((op == '+') || (op == '-')) {
                n = (op == '+') ? n : -n;
                ans += n;
            } else {
                n = (op == '*') ? last * n : last / n;
                ans += -last + n;
            }
            last = n;
        }
        return ans;
    }
}
