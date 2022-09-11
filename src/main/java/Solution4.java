import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution4 {
    public List<String> letterCombinations(String digits) {
        Map<Character, char[]> mapping = new HashMap<>();
        List<String> result = new ArrayList<>();
        if (digits == null || digits.equals("")) {
            return result;
        }
        mapping.put('0', new char[]{});
        mapping.put('1', new char[]{});
        mapping.put('2', new char[]{'a', 'b', 'c'});
        mapping.put('3', new char[]{'d', 'e', 'f'});
        mapping.put('4', new char[]{'g', 'h', 'i'});
        mapping.put('5', new char[]{'j', 'k', 'l'});
        mapping.put('6', new char[]{'m', 'n', 'o'});
        mapping.put('7', new char[]{'p', 'q', 'r', 's'});
        mapping.put('8', new char[]{'t', 'u', 'v'});
        mapping.put('9', new char[]{'w', 'x', 'y', 'z'});
        StringBuilder sb = new StringBuilder();
        letterCombinationsHelper(digits, sb, mapping, result);
        return result;
    }

    public void letterCombinationsHelper(String digits, StringBuilder sb, Map<Character, char[]> map, List<String> result) {
        if (sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }
        for (char ch : map.get(digits.charAt(sb.length()))) {
            sb.append(ch);
            letterCombinationsHelper(digits, sb, map, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        String test1 = "23";
        String test2 = "";
        String test3 = "2";
        String test4 = "234";
        Solution4 solution4 = new Solution4();
        System.out.println(solution4.letterCombinations(test1));
        System.out.println(solution4.letterCombinations(test2));
        System.out.println(solution4.letterCombinations(test3));
        System.out.println(solution4.letterCombinations(test4));
    }
}
