package jiyeop;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OneTwoThreePlus {
	/**
	 * 순열 문제인가 했는데 DP문제이다.
	 * 사실  피보나치랑 비슷한거같다.
	 * */
	static int n;
	public static void main(String[] args) throws Exception {
		System.out.println("시작");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[11];
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int j = 4; j < 11; j++) {
			arr[j] = arr[j-1]+arr[j-2]+arr[j-3];
			//점화식
		}
		for (int i = 0; i < T; i++) {
			n = Integer.parseInt(br.readLine());
			sb.append(arr[n]).append("\n");
		}
		System.out.println(sb);;
	}
}
