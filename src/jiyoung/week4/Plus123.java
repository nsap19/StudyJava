package jiyoung.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Plus123 {

//	*******
//	Sol.ver1
//	dp로 풀어볼까 싶었는데 순열이라 안될듯싶어서
//	1로 시작할때, 2로 시작할때, 3으로 시작할때로 나눠서 구해보기
//	시간 오래걸릴거같은데,,
//	재귀 - 시작한 수를 빼고 넘김
	
//	Sol.ver2
//	dp로 된다고한다..
//	dp[n] = dp[n-1] + dp[n-2] + dp[n-3]
//	*******
	
	public static int cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			cnt = 0;
			findCnt(Integer.parseInt(br.readLine()));
			sb.append(cnt).append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static void findCnt(int n) {
		if(n==3) {
			cnt++;	//현재수를 3으로한거
			findCnt(n-1);
			findCnt(n-2);
			return;
		}
		if(n==2) {
			cnt++;
			findCnt(n-1);
			return;
		}
		if(n==1) {
			cnt++;
			return;
		}
		findCnt(n-1);
		findCnt(n-2);
		findCnt(n-3);
	}
}
