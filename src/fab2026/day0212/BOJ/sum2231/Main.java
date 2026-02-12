package fab2026.day0212.BOJ.sum2231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        for(int i=1; i<N; i++){
            int r = calculate(i, N);
            if(r == N){
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }

    private static int calculate(int i, int N) {
        int sum = i;
        while(i > 0){
            int quot = i / 10;
            int rem = i % 10;
            sum += rem;
            i = quot;
        }

        return sum;
    }
}
