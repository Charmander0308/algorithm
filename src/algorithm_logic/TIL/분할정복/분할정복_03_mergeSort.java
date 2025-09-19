package algorithm_logic.TIL.분할정복;

import java.util.Arrays;

public class 분할정복_03_mergeSort {
	static int[] arr = {17, 66, 4000, 22, 55, 44, 818};
	static int N = arr.length; 
	static int[] tmp = new int[N];	
	
	public static void main(String[] args) {
//		Arrays.sort(null);	//클래스 문서 확인해보기
	}
	static void mergeSort(int start, int end) {
		//1. 교차됐니? 그러면 안할래
		
		//2. 아니야? 그러면 해
		if(start < end) {
			int mid = (start+end)/2;
			mergeSort(start, mid);
			mergeSort(mid+1, end);
			
			//병합코드를 직접 작성하던지... 아니면 함수를 호출하겠다!
			merge(start, mid, end);
			
			
			
		}
	}
	static void merge(int start, int mid, int end) {
		//왼쪽 구간의 시작점, 오른쪽 구간의 시작점
		int L = start;
		int R = mid + 1;
		
		int idx = start;
		
		//둘 중 하나라도 구간을 벗어나면 그만해~
		while(L <= mid && R <= end) {
			//안정정렬
			if(arr[L] <= arr[R]) {
				tmp[idx] = arr[L];
				idx++;
				L++;
			} else {
				tmp[idx++] = arr[R++];
			}
		}//한쪽 구간은 완료
		
		if(L <= mid) {
			for(int i=L; i<=mid; i++) {
				tmp[idx++] = arr[i];
			}
		} else {
			for(int i=R; i<=end; i++) {
				tmp[idx++] = arr[i];
			}
		}//나머지 정리 완료
		
		//원본에 덮어버리기
		for(int i = start; i <= end; i++) {
			arr[i] = tmp[i];
		}
	}
}
