package algorithm_logic;

public class TowerOfHanoi {

    // n: 옮길 원반의 개수
    // from_rod: 시작 기둥
    // to_rod: 목표 기둥
    // aux_rod: 보조 기둥
    public void solve(int n, char from_rod, char to_rod, char aux_rod) {
        // 재귀의 종료 조건: 옮길 원반이 1개일 때
        if (n == 1) {
            System.out.println("원반 1을 " + from_rod + "에서 " + to_rod + "(으)로 이동");
            return;
        }

        // 1. n-1개의 원반을 시작 기둥에서 보조 기둥으로 이동
        // 목표 기둥과 보조 기둥의 역할을 바꿉니다.
        solve(n - 1, from_rod, aux_rod, to_rod);

        // 2. 가장 큰 원반을 시작 기둥에서 목표 기둥으로 이동
        System.out.println("원반 " + n + "을 " + from_rod + "에서 " + to_rod + "(으)로 이동");

        // 3. n-1개의 원반을 보조 기둥에서 목표 기둥으로 이동
        // 시작 기둥과 보조 기둥의 역할을 바꿉니다.
        solve(n - 1, aux_rod, to_rod, from_rod);
    }

    public static void main(String[] args) {
        TowerOfHanoi hanoi = new TowerOfHanoi();
        int numberOfDisks = 2; // 옮길 원반의 개수
        char fromRod = 'A';    // 시작 기둥
        char toRod = 'C';      // 목표 기둥
        char auxRod = 'B';     // 보조 기둥

        System.out.println(numberOfDisks + "개의 원반을 " + fromRod + "에서 " + toRod + "(으)로 이동하는 과정:");
        hanoi.solve(numberOfDisks, fromRod, toRod, auxRod);
    }
}