import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        // Test case 1
        int[][] flights1 = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        System.out.println("Actual: " + findCheapestPrice(4, flights1, 0, 3, 1) + ", Expected: 700");

        // Test case 2
        int[][] flights2 = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        System.out.println("Actual: " + findCheapestPrice(4, flights2, 0, 3, 0) + ", Expected: -1");

        // Test case 3
        int[][] flights3 = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        System.out.println("Actual: " + findCheapestPrice(3, flights3, 0, 2, 0) + ", Expected: 500");
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // add your solution here
        int priceMin = Integer.MIN_VALUE;
        for (int i=0; i<flights.length; i++) {
            for (int j=i; j<flights.length; j++) {
                int layOvers = -1;
                while (flights[j][1] != dst && flights[i][0] == src && layOvers<=k){
                    priceMin = flights[i][2] < priceMin? flights[i][2]: priceMin;
                    layOvers++;
                }
            }
        }
        return priceMin;

    }
}