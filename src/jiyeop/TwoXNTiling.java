package jiyeop;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TwoXNTiling {
	/**2xn타일링
	 * 왜하필 10007이지
	 * 백트래킹인가... 처음엔 백트래킹으로 생각했는데
	 * 10007로 나눠야하고 2*9가 55여서 직접해봄
	 * n=1 1
	 * n=2 2
	 * n=3 3
	 * n=4 5
	 * n=5 8
	 * n=6 13
	 * n=7 21
	 * n=8 34
	 * n=9 55
	 * */
	static int n;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		int[] dp = new int[1001];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		
		for (int i = 3; i <= n; i++) {
			dp[i] = (dp[i-1] + dp[i-2])%10007;
		}
		System.out.println(dp[n]);
	}
}
