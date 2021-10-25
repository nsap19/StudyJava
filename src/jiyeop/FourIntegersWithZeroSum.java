package jiyeop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FourIntegersWithZeroSum {
	/**
	 * 합이 0인 네 정수
	 * 경우의수를 모두 따지면 되지만 오래걸린다.
	 * 경우의 수를 따지지 않고 0이되는 경우를 구해야함
	 * ab배열의 합 cd배열의 합 
	 * ab + cd 배열의 합으로 구하기*/
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[] A = new int[n];
		int[] B = new int[n];
		int[] C = new int[n];
		int[] D = new int[n];
		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");	
			A[i] = Integer.parseInt(str[0]);
			B[i] = Integer.parseInt(str[1]);
			C[i] = Integer.parseInt(str[2]);
			D[i] = Integer.parseInt(str[3]);
		}
		int[] AB = new int[n*n];
		int[] CD = new int[n*n]; 
		int index = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				AB[index] = A[i] + B[j];
				index++;
			}
		}
		index = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				CD[index] = C[i] + D[j];
				index++;
			}
		}
		Arrays.sort(AB);
		Arrays.sort(CD);
//		for (int i = 0; i < CD.length; i++) {
//			System.out.print(AB[i]+" ");
//		}
//		System.out.println();
//		for (int i = 0; i < CD.length; i++) {
//			System.out.print(CD[i]+" ");
//		}
		long cnt = 0;
		int abindex = 0 ;
		int cdindex = n*n-1;
		
		while(abindex<n*n-1 && cdindex>=0) {
			long absum = AB[abindex];
			long cdsum = CD[cdindex];
			long sum = absum+cdsum;
			if(sum == 0) {
				long abcnt = 0;
				long cdcnt = 0;// long이 아니면 틀림
				while(abindex<AB.length && AB[abindex]==absum) {
					abcnt++;
					abindex++;
				}
				while(cdindex>=0 && CD[cdindex]==cdsum) {
					cdcnt++;
					cdindex--;
				}
				cnt += abcnt*cdcnt;
				//숫자 중복이 있을수 있다.
				//ex -1 -1 
				//   1   1 경우의 수 4
			}
			if (sum<0) {
				abindex++;
			}
			if(sum>0) {
				cdindex--;
			}
		}
		System.out.println(cnt);
		
	}
}
