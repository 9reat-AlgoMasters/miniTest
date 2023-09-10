import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1091 {
    static int N, ans;
    static int[] cards, target, swap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cards = new int[N];
        target = new int[N];
        swap = new int[N];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            target[i] = Integer.parseInt(input[i]);
            cards[i] = i;
        }
        input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            swap[i] = Integer.parseInt(input[i]);
        }

        boolean first = true;
        while(!check()){
            if(first){
                first = false;
            }else if(goBackFirstShape()){
                ans = -1;
                break;
            }


            for (int i = 0; i < N; i++) {
                cards[i] = swap[cards[i]];
            }
            ans++;
        }

        System.out.println(ans);
    }

    static boolean check(){
        for (int i = 0; i < N; i++) {
            if(target[i] != cards[i]%3){
                return false;
            }
        }
        return true;
    }
    static boolean goBackFirstShape(){
        for (int i = 0; i < N; i++) {
            if(cards[i] != i){
                return false;
            }
        }
        return true;
    }
}
