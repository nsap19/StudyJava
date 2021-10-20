package jiyeop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumOfNumbers {
	/**
	 * 수들의 합 2 
	 * 투포인터 이요ㅛㅇ
	 * @throws Exception */
	static int N;
	static int M;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int left = 0;
		int right = 0;
		int sum = 0;
		int cnt = 0;
		while(true) {
			if(sum>= M) {
				sum -= arr[left];
				left++;
			}
			else if(right == N) {
				break;
			}
			else {
				sum+=arr[right];
				right++;
			}
			if(sum == M) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
