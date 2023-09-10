import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1339 {
    static int N;
    static List<String> list = new ArrayList<>();
    static Map<Character, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int maxLen = 0;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            list.add(s);
            maxLen = Math.max(maxLen, s.length());
        }
        for (int i = 0; i < N; i++) {
            String s = list.get(i);
            int stringLength = s.length();
            int mul = 1;
            for (int j = stringLength-1; j >= 0; j--) {
                char c = s.charAt(j);
                if(!map.containsKey(c)){
                    map.put(c, mul);
                }else{
                    map.put(c, map.get(c) + mul);
                }
                mul *= 10;
            }
        }

        List<Map.Entry<Character, Integer>> temp = new ArrayList<>(map.entrySet());
        Collections.sort(temp, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return Integer.compare(o2.getValue(), o1.getValue());
            }
        });
        int len = temp.size();
        int value = 9;
        for(int i = 0; i < len; i++){
            map.put(temp.get(i).getKey(), value--);
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            String s = list.get(i);
            int stringLength = s.length();
            int mul = 1;
            for(int j = stringLength-1; j >= 0; j--){
                int val = map.get(s.charAt(j));
                ans += val * mul;
                mul *= 10;
            }
        }
        System.out.println(ans);

    }
}
