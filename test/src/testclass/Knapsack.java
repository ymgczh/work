package testclass;

public class Knapsack {
    public static void main(String[] args) throws Exception {
        int val[] = {10, 40, 30, 50};
        int wt[] = {5, 4, 6, 3};
        int W = 10;
 
        System.out.println(BeiBao.knapsack(val, wt, W));
    }
}