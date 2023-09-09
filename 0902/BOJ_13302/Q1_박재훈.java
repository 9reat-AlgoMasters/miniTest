import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1 {
    static int N, M;
    static int[][] cost;
    static boolean[] dontGoResort;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        dontGoResort = new boolean[N+1];
        if(M > 0){
            input = br.readLine().split(" ");
            for (int i = 0; i < M; i++) {
                int val = Integer.parseInt(input[i]);
                dontGoResort[val] = true;
            }
        }

        cost = new int[N+1][N+1];

        int ans = calc(1, 0);

        System.out.println(ans);
    }
    static int calc(int day, int coupon){
        if (day > N) return 0;
        if (cost[day][coupon] != 0) return cost[day][coupon];

        if(dontGoResort[day]){
            cost[day][coupon] = calc(day+1, coupon);
        }else {
            int val1 = calc(day + 1, coupon) + 10000;
            int val2 = calc(day + 3, coupon + 1) + 25000;
            int val3 = calc(day + 5, coupon + 2) + 37000;

            cost[day][coupon] = Integer.MAX_VALUE;
            if (coupon >= 3) {
                cost[day][coupon] = calc(day + 1, coupon - 3);
            }
            cost[day][coupon] = Math.min(cost[day][coupon], Math.min(val1, Math.min(val2, val3)));

        }
        return cost[day][coupon];
    }
}
