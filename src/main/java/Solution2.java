import java.util.ArrayList;
import java.util.List;
// Code from https://www.youtube.com/watch?v=21OuwqIC56E by Kevin Naughton
public class Solution2 {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;
        String[] mapping = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        letterCombinationsRecursive(result, digits, "", 0, mapping);
        return result;
    }

    public void letterCombinationsRecursive(List<String> result, String digits, String current, int index, String[] mapping) {
        if (digits.length() == index) {
            result.add(current);
            return;
        }
        String letters = mapping[digits.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            letterCombinationsRecursive(result,digits,current+letters.charAt(i),index+1,mapping);
        }
    }

    public static void main(String[] args) {
        String test1 = "23";
        String test2 = "";
        String test3 = "2";
        String test4 = "234";
        Solution2 solution2=new Solution2();
        System.out.println(solution2.letterCombinations(test1));
        System.out.println(solution2.letterCombinations(test2));
        System.out.println(solution2.letterCombinations(test3));
        System.out.println(solution2.letterCombinations(test4));
    }
}
