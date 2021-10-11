package jiyeop;

import java.util.*;
import java.io.*;

public class TwistedElectricWire {
	/**꼬인 전깃줄
	 * 전체 배열 사이즈 - 최장 증가 수열*/
	static int[] arr;
	static int[] check;
	static int N;
	static int cnt;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		arr = new int[N];
		check = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] =Integer.parseInt(st.nextToken());
		}
		check[cnt++] = arr[0];
		for (int i = 1; i < N; i++) {
			if(arr[i]>check[cnt-1]) {
				check[cnt++] = arr[i];
			}
			else {
				int num = b_search(arr[i]);
				check[num] = arr[i];
			}
		}
		System.out.println(N-cnt);
	}
	static int b_search(int x) {
		int min = 0;
		int max = cnt;
		int ans = 0;
		while(min<=max) {
			int mid = (min + max)/2;
			if(check[mid] >=x) {
				ans = mid;
				max = mid - 1;
			}
			else {
				min = mid + 1;
			}
		}
		return ans;
	}
}
