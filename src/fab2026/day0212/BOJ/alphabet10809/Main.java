package fab2026.day0212.BOJ.alphabet10809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[26];
        Arrays.fill(arr, -1);

        String s = br.readLine();
        for(int i=0; i<s.length(); i++){
            int num = s.charAt(i)-'a';
            if(arr[num] == -1)
                arr[num] = i;
        }
        StringBuilder sb = new StringBuilder();
        for(int i : arr){
            sb.append(i).append(" ");
        }
        System.out.print(sb.toString().trim());
    }
}
