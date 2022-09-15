import edu.princeton.cs.algs4.StdOut;

public class Problem_1221 {
    public int balancedStringSplit(String s) {
        if (s.length() == 0 || s == null) return 0;
        int balanceCounter = 0;
        int answerCounter = 0;
        for (char c : s.toCharArray()) {
            if (c == 'L') balanceCounter++;
            if (c == 'R') balanceCounter --;
            if (balanceCounter == 0) answerCounter++;
        }
        return answerCounter;
    }

    public static void main(String[] args) {
        Problem_1221 problem_1221 = new Problem_1221();
        String s = "RLRRLLRLRL";
        System.out.println("Test 1 - Expecting: 4, Getting: " + problem_1221.balancedStringSplit(s));
        s = "RLRRRLLRLL";
        System.out.println("Test 2 - Expecting: 2, Getting: " + problem_1221.balancedStringSplit(s));
        s = "LLLLRRRR";
        System.out.println("Test 3 - Expecting: 1, Getting: " + problem_1221.balancedStringSplit(s));
    }
}
