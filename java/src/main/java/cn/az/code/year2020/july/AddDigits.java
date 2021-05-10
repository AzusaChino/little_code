package cn.az.code.year2020.july;

/**
 * @author az
 * @since 07/26/20
 */
public class AddDigits {

    public static void main(String[] args) {
        AddDigits ad = new AddDigits();
        System.out.println(ad.addDigits(1267));
    }

    public int addDigits(int num) {
        String numStr = String.valueOf(num);
        if (numStr.length() == 1) {
            return Integer.parseInt(numStr);
        }
        int temp = 0;
        for (char c : numStr.toCharArray()) {
            temp += (c - 48);
        }
        return addDigits(temp);
    }

}
