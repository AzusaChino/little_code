package cn.az.code.easy;

/**
 * @author : Liz
 * @date : 2019/10/27
 **/
public class RemoveDuplicate026 {

    public static void main(String[] args) {
        System.out.println(remove(new int[]{1, 1, 2, 2, 3, 4, 5}));
    }

    public static int remove(int[] lst) {
        int i = 0;
        for (int j = 1; j < lst.length; j++) {
            if (lst[i] != lst[j]) {
                i++;
                lst[i] = lst[j];
            }
        }

        return i + 1;
    }
}
