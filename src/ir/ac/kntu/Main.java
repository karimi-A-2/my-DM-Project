package ir.ac.kntu;

import ir.ac.kntu.logic.Director;

public class Main {
    public static void main( String[] args ) {
        Director director = new Director();
        director.start();
    }
}

/* test-1
2 1
1 2
result should be : (2^1 + 2^1) = 4
*/

/* test-2
4 6
1 2
1 3
1 4
2 3
2 4
3 4
result should be : 0
*/

/* test-3
15 15
1 2
2 3
2 4
4 6
3 5
6 8
5 7
8 9
7 9
9 10
4 9
3 6
11 12
12 13
14 15
result should be : (2^4 + 2^6)*(2^2 + 2^1)*(2^1 + 2^1) = 1920
*/
