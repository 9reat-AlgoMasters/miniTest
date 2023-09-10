import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1091 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] P = new int[N];
        int[] S = new int[N];
        int[] cards = new int[N];  // 012...

        String line = br.readLine();
        String[] splitLine = line.split(" ");

        for(int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(splitLine[i]);
            cards[i] = i%3;
        }
        line = br.readLine();
        splitLine = line.split(" ");

        for(int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(splitLine[i]);
        }

        int[] temp = new int[N];
        int ans = 0;
        while (true) {
            for(int i = 0; i < N; i++) {
                temp[i] = cards[i];
            }
            if(Arrays.equals(cards, P)) {
                break;
            }

            for(int i = 0;i < N;i++) {
                cards[i] = temp[S[i]];
            }

            if(ans > 10000000) {
                ans = -1;
                break;
            }

            ans++;
        }

        System.out.println(ans);

    }
}
