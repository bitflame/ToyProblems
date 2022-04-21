public class Chess {
    private void knightMoves(int i, int j) {
        // write a method that takes values for i and j and calculates all possible immediate moves
        while ( i < 8 && i > 0 ){
            i = i + 2;
            j = j + 1;
        }
        // or
        i = i + 1;
        j = j + 2;

        // add 2 to i one to j
        //(i<6 && j <7): i=i+2;j=j+1;

        // use a switch statement
    }
}
