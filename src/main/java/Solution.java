import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
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
        if (digits.length() == 0) {
            return result;
        }
        int index = Character.getNumericValue(digits.charAt(0));
        for (Character c : map.get(index).toCharArray()) result.add("" + c);
        if (digits.length() == 1) {
            return result;
        }
        return func2(result, digits, 1);
    }

    public List<String> func2(List<String> latestList, String s, int currentIndex) {
        if (currentIndex >= s.length()) return latestList;
        int currentInteger = Character.getNumericValue(s.charAt(currentIndex));
        currentIndex++;
        String currentString = map.get(currentInteger);
        List<String> newList = new ArrayList<String>();
        for (String newString : latestList) {
            // latestList.add(currentString.concat(newString));
            for (Character c : currentString.toCharArray()) {
                newList.add(newString.concat("" + c));
            }
        }
        return func2(newList, s, currentIndex);
    }

    public int lenghtOfLongestSubString(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        Map<Integer, Character> uniqueString = new HashMap<Integer, Character>();
        int i = 0;//start of string
        int j = 1;// current cursor
        int longestLength = 0;
        uniqueString.put(i, s.charAt(i));
        longestLength++;
        while (j < s.length()) {
            if (!uniqueString.containsValue(s.charAt(j))) {
                uniqueString.put(j, s.charAt(j));
                j++;
            } else {
                i++;
                j = i + 1;
                uniqueString = new HashMap<Integer, Character>();
                uniqueString.put(i, s.charAt(i));
            }
            if (longestLength < uniqueString.size()) longestLength = uniqueString.size();
        }
        return longestLength;
    }

    public static void main(String[] args) {

        Solution s = new Solution();
        String subString1 = "abcabcbb";
        String subString2 = "bbbbb";
        String subString3 = "pwwkew";
        String subString4 = " ";
        String subString5 = "au";
        String subString6 = "dvdf";
        System.out.println("Running Length of Longest Substring");
        System.out.println("Expecting 3, Getting: " + s.lenghtOfLongestSubString(subString1));
        System.out.println("Expecting 1, Getting: " + s.lenghtOfLongestSubString(subString2));
        System.out.println("Expecting 3, Getting: " + s.lenghtOfLongestSubString(subString3));
        System.out.println("Expected 1, Getting: " + s.lenghtOfLongestSubString(subString4));
        System.out.println("Expecting 2, Getting: " + s.lenghtOfLongestSubString(subString5));
        System.out.println("Expecting 3, Getting: " + s.lenghtOfLongestSubString(subString6));
        String test1 = "23";
        String test2 = "";
        String test3 = "2";
        String test4 = "234";
        System.out.println("Running Letter Combinations of Phone# ");
        System.out.println(s.letterCombinations(test1));
        System.out.println(s.letterCombinations(test2));
        // expecting ["adg","adh","adi","aeg","aeh","aei","afg","afh","afi","bdg","bdh","bdi","beg","beh","bei","bfg","bfh","bfi","cdg","cdh","cdi","ceg","ceh","cei","cfg","cfh","cfi"]
        System.out.println(s.letterCombinations(test3));
        System.out.println("Expecting: expecting [\"adg\",\"adh\",\"adi\",\"aeg\",\"aeh\",\"aei\",\"afg\",\"afh\",\"afi\",\"bdg\",\"bdh\",\"bdi\",\"beg\",\"beh\",\"bei\",\"bfg\",\"bfh\",\"bfi\",\"cdg\",\"cdh\",\"cdi\",\"ceg\",\"ceh\",\"cei\",\"cfg\",\"cfh\",\"cfi\"] " +
                "\n getting: " + s.letterCombinations(test4));
    }
}
