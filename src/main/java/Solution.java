import edu.princeton.cs.algs4.SET;

import java.util.*;

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
        HashSet<Character> uniqueString = new HashSet<Character>();
        int i = 0;//start of string
        int j = 0;// current cursor
        int longestLength = 0;
        while (j < s.length()) {
            if (!uniqueString.contains(s.charAt(j))) {
                uniqueString.add(s.charAt(j));
                j++;
            } else {
                i++;
                j = i;
                uniqueString = new HashSet<>();
                uniqueString.add(s.charAt(j));
                j++;
            }
            if (longestLength < uniqueString.size()) longestLength = uniqueString.size();
        }
        return longestLength;
    }

    private class Cell {
        int row;
        int col;

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public Cell(int r, int c) {
            this.row = r;
            this.col = c;
        }
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        if (obstacleGrid[n - 1][m - 1] == 1 || obstacleGrid[0][0] == 1) return 0;
        return findPath(obstacleGrid, 0, 0, 0);
    }

    private int findPath(int[][] obstacleGrid, int row, int column, int path) {
        if (obstacleGrid[obstacleGrid.length - 1][obstacleGrid[row].length - 1]==1) {
            path = path + 1;
            obstacleGrid[obstacleGrid.length - 1][obstacleGrid[row  ].length - 1] = 0;
            return path;
        }
        if (row < obstacleGrid.length - 1 && obstacleGrid[row + 1][column] == 0) {
            obstacleGrid[row + 1][column] = 1;
            path = findPath(obstacleGrid, row + 1, column, path);
        }

            if (column < obstacleGrid[row].length - 1 && obstacleGrid[row][column + 1] == 0) {
                obstacleGrid[row][column + 1] = 1;
                path = findPath(obstacleGrid, row, column + 1, path);
            }

        return path;
    }

    public static void main(String[] args) {

        Solution s = new Solution();
        int[][] obsGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println("Test 1 - Expected: 2, Getting: " + s.uniquePathsWithObstacles(obsGrid));
        obsGrid = new int[][]{{0, 0}, {0, 1}};
        System.out.println("Test 2 - Expected: 0, Getting: " + s.uniquePathsWithObstacles(obsGrid));
        obsGrid = new int[][]{{0, 1}};
        System.out.println("Test 3 - Expected: 0, Getting: " + s.uniquePathsWithObstacles(obsGrid));
        obsGrid = new int[][]{{0}};
        System.out.println("Test 4 - Expected: 1, Getting: " + s.uniquePathsWithObstacles(obsGrid));
        obsGrid = new int[][]{{1, 0}};
        System.out.println("Test 5 - Expected: 0, Getting: " + s.uniquePathsWithObstacles(obsGrid));
        obsGrid = new int[][]{{0}, {0}};
        System.out.println("Test 6 - Expected: 1, Getting:    " + s.uniquePathsWithObstacles(obsGrid));
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
