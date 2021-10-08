package jiyeop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NumberCard {
	
	static int[] Narr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		Narr = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
			Narr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(Narr);
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			sb.append(binarySearch(num, 0, N-1)).append(" ");
		}
		System.out.println(sb);
	}
	static int binarySearch(int key, int low, int high) {
		int mid = 0;
		while(low <= high) {
			//반복문을 안써서 못풀고있었다
			
			mid = (low + high) / 2;
			if(key == Narr[mid]) {
				return 1;
			}
			if(Narr[mid]<key) {
				low = mid + 1;
			}
			else {
				high = mid - 1;
			}
		}
		return 0;
	}
}
