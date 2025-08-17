package aug2025.weekend04_0817.baekjoon.rectangle2527;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i =0; i < 4; i++) {
			//rectangle1
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int p1 = sc.nextInt();
			int q1 = sc.nextInt();
			//rectangel2
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int p2 = sc.nextInt();
			int q2 = sc.nextInt();
			
			//만나지 않는 경우 
			if(p1 < x2 || p2 < x1 || q1 < y2 || q2 < y1) {
				System.out.println("d");
			} 
			//점으로 만나는 경우 
			else if((x1==p2 && y1==q2)||(p1==x2 && q1==y2)||
					(x1==p2 && q1==y2)||(p1==x2 && y1==q2)) {
				System.out.println("c");
			} 
			//선분으로 만나는 경우 
			else if(p1 == x2||q1 == y2||x1==p2|| y1==q2) {
				System.out.println("b");
			} 
			//직사각형으로 만나는 경우 
			else {
				System.out.println("a");
			}
		}
	}
}
