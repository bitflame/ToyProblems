import java.util.ArrayList;
import java.util.List;

public class MultiplesThreeAndFive {
    public List<Integer> calculateMultiples(int m, int n, int limit) {
        List<Integer> result = new ArrayList<>();
        if (m == 0 || n == 0 || limit == 0) return result;
        int index = 2;
        if (m > n) {
            while (m * index < limit) {
                if (m * index % n == 0) result.add(m * m);
                index++;
            }
        } else {
            index = 2;
            while (n * index < limit) {
                if (n * index % m == 0) result.add(n * index);
                index++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 5;
        int limit = 1000;
	// int limit = 100;
        MultiplesThreeAndFive multiplesThreeAndFive = new MultiplesThreeAndFive();
        for(int i: multiplesThreeAndFive.calculateMultiples(m, n, limit)) System.out.print(" "+i);
        System.out.println();
    }
}
