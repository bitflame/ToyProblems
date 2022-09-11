import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution3 {
    HashMap<Integer, String> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        map.put(0, "0");
        map.put(1, "1");
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        if (digits.length() == 0 || digits == null) {
            return result;
        }
        letterCombinationsRecursiveCall(result, digits, "", 0);
        return result;
    }

    public void letterCombinationsRecursiveCall(List<String> result, String digits, String current, int index) {
        if (index == digits.length()) {
            result.add(current);
            return;
        }
        for (Character character : map.get(Character.getNumericValue(digits.charAt(index))).toCharArray()) {
            // current = current + "" + character; when this line was in place, the outcome was wrong because the
            // content of current did not change when the recursive call returned. Important !
            letterCombinationsRecursiveCall(result, digits, current.concat("" + character), index + 1);
        }
    }

    public static void main(String[] args) {
        String test1 = "23";
        String test2 = "";
        String test3 = "2";
        String test4 = "234";
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.letterCombinations(test1));
        System.out.println(solution3.letterCombinations(test2));
        System.out.println(solution3.letterCombinations(test3));
        System.out.println(solution3.letterCombinations(test4));
    }
}
