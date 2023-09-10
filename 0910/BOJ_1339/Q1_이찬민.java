import java.io.*;
import java.util.*;

public class Main_1339 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] lines = new String[N];
        int[] alphabetCount = new int[28];

        for (int i = 0; i < N; i++) {
            lines[i] = br.readLine();
        }

        for (int i = 0; i < N; i++) {
            int temp = (int) Math.pow(10, lines[i].length() - 1);
            for (int j = 0; j < lines[i].length(); j++) {
                alphabetCount[lines[i].charAt(j) - 65] += temp;
                temp /= 10;
            }
        }

        Arrays.sort(alphabetCount);

        int num = 9;
        int sum = 0;
        for(int i = alphabetCount.length - 1; i >=0 ;i--) {
            sum += alphabetCount[i] * num--;

        }
        System.out.println(sum);
    }
}
