package sep2025.day14_0901.BOJ.cogwheel14891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    // 톱니바퀴 4개를 Deque 배열로 관리
    static Deque<Integer>[] cogs = new ArrayDeque[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 톱니바퀴 4개 초기 상태 입력
        for (int i = 0; i < 4; i++) {
            cogs[i] = new ArrayDeque<>();
            String line = br.readLine();
            for (int j = 0; j < 8; j++) {
                cogs[i].addLast(line.charAt(j) - '0');
            }
        }

        // 총 회전 수
        int k = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 톱니 번호 (0-based index로 변환)
            int cogNo = Integer.parseInt(st.nextToken()) - 1;
            // 회전 방향 (1: 시계, -1: 반시계)
            int dir = Integer.parseInt(st.nextToken());

            // 각 톱니바퀴가 어떤 방향으로 회전할지 결정
            int[] directions = determineDirections(cogNo, dir);
            
            // 결정된 방향에 따라 모든 톱니바퀴를 회전
            rotateAll(directions);
        }

        // 최종 점수 계산
        System.out.println(calculateScore());
    }

    // [핵심 로직] 어떤 톱니가 어떤 방향으로 회전할지 결정하는 함수
    private static int[] determineDirections(int startCog, int startDir) {
        int[] directions = new int[4];
        directions[startCog] = startDir;

        // 기준 톱니의 오른쪽으로 전파
        for (int i = startCog; i < 3; i++) {
            // 현재 톱니(i)의 3시 방향과 다음 톱니(i+1)의 9시 방향의 극이 다를 경우
            // cogs[i].toArray()[2] -> 3시 방향, cogs[i+1].toArray()[6] -> 9시 방향
            if ((int)cogs[i].toArray()[2] != (int)cogs[i+1].toArray()[6]) {
                // 다음 톱니는 현재 톱니와 반대 방향으로 회전
                directions[i + 1] = -directions[i];
            } else {
                // 극이 같으면 더 이상 전파되지 않음
                break;
            }
        }

        // 기준 톱니의 왼쪽으로 전파
        for (int i = startCog; i > 0; i--) {
            // 현재 톱니(i)의 9시 방향과 이전 톱니(i-1)의 3시 방향의 극이 다를 경우
            if ((int)cogs[i].toArray()[6] != (int)cogs[i-1].toArray()[2]) {
                // 이전 톱니는 현재 톱니와 반대 방향으로 회전
                directions[i - 1] = -directions[i];
            } else {
                // 극이 같으면 더 이상 전파되지 않음
                break;
            }
        }
        return directions;
    }

    // 결정된 방향에 따라 모든 톱니바퀴를 실제로 회전시키는 함수
    private static void rotateAll(int[] directions) {
        for (int i = 0; i < 4; i++) {
            if (directions[i] == 1) { // 시계 방향 회전
                cogs[i].addFirst(cogs[i].removeLast());
            } else if (directions[i] == -1) { // 반시계 방향 회전
                cogs[i].addLast(cogs[i].removeFirst());
            }
        }
    }

    // 점수를 계산하는 함수
    private static int calculateScore() {
        int score = 0;
        if (cogs[0].peekFirst() == 1) score += 1;
        if (cogs[1].peekFirst() == 1) score += 2;
        if (cogs[2].peekFirst() == 1) score += 4;
        if (cogs[3].peekFirst() == 1) score += 8;
        return score;
    }
}