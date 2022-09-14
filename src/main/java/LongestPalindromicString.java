public class LongestPalindromicString {
    public int lps(char seq[], int i, int j) {
        if (seq.length==0) return 0;
        if (i == j) return 1;
        if (seq[i] == seq[j] && j == i + 1) return 2;
        if (seq[i]==seq[j]) return lps(seq,i+1,j-1)+2;
        return max(lps(seq,i,j-1),lps(seq,i+1, j));
    }

    private int max(int v, int w) {
        return (v > w) ? v : w;
    }

    public static void main(String[] args) {
        String test1 = "";
        String test2 = "a";
        String test3 = "aa";
        String test4 = "bab";
        String test5 = "abbaaab";
        String test6 = "BBABCBCAB";
        int n = 0;
        LongestPalindromicString longestPalindromicString = new LongestPalindromicString();
        System.out.println("Test 1 - Expect 0, result: " + longestPalindromicString.lps(test1.toCharArray(), 0, n));
        n = test2.length();
        System.out.println("Test 2 - Expect 1, result: " + longestPalindromicString.lps(test2.toCharArray(), 0, n-1));
        n = test3.length();
        System.out.println("Test 3 - Expect 2, result: " + longestPalindromicString.lps(test3.toCharArray(), 0, n-1));
        n = test4.length();
        System.out.println("Test 4 - Expect 3, result: " + longestPalindromicString.lps(test4.toCharArray(), 0, n-1));
        n = test5.length();
        System.out.println("Test 5 - Expect 5, result: " + longestPalindromicString.lps(test5.toCharArray(), 0, n-1));
        n = test6.length();
        System.out.println("Test 6 - Expect 7, result: " + longestPalindromicString.lps(test6.toCharArray(), 0, n-1));
    }
}
    /*
    int testCaseNum;
        String testString;
        CodeChef codeChef = new CodeChef();
        for (int i = 0; i < args.length; i++) {
            testCaseNum =  Character.getNumericValue(args[0].charAt(0));
            for (int j = 0; j < testCaseNum; j++) {
                testString = args[1+j];
                codeChef.longestPalindString(testString);
            }
        }

        */



