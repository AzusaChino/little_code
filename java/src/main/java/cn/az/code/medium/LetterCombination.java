package cn.az.code.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Liz
 * @version 2019/11/27
 */
public class LetterCombination {

    public static void main(String[] args) {
        System.out.println(new LetterCombination().solution("23"));
    }
    public List<String> solution(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        if(digits.isEmpty()) {
            return ans;
        }
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for(int i =0; i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length()==i){
                String t = ans.remove();
                for(char s : mapping[x].toCharArray()) {
                    ans.add(t+s);
                }
            }
        }
        return ans;
    }
}
