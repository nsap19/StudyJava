package jiyeop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MooGame {
	/**이분탐색이다.
	 * 배열 사이즈를 얼마로 할지 몰라서 arraylist를 사용했다.
	 * MOO게임의 길이
	 * S(0) = 3;
	 * S(1) = S(0) + M+ (1+2) + S(0)
	 * S(K) = S(K-1) + M + (K+2) + S(K-1) = S(K-1)*2 + K + 3
	 * */
	static int N;
	static ArrayList<Integer> Moolength = new ArrayList<Integer>();
	static char answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());//N은 1부터
		int length = 3;
		int k = 0;
		Moolength.add(length);
		while(N>length) {//길이를 리스트에 저장
			k++;
			length = (length * 2) + (k + 3);
			Moolength.add(length);
		}
		for (int i = 0; i < k+1; i++) {
			System.out.println(Moolength.get(i));
		}
		answer = B_search(N);
		System.out.println(answer);
	}
	static char B_search(int n) {
		if(n<=3) {
			if(n==1)
				return 'm';
			else
				return 'o';
		}//N이 3보다 이하일 때 처리
		int m = 0;
		while(n > Moolength.get(m)) {
			m++;
		}//N이 있는 M 값 찾기
		/**
		 * 아래부분은 n이 s(k)에서 s(k-1) 부분에 속할때
		 * 안 속할때를 나눈것이다.
		 * s(k)에서 n을 구할떄 n 이 s(k-1)보다 작을 수는 없음
		*/
		if(n<=Moolength.get(m)-Moolength.get(m-1)) {
			//가운데 m+(K+2) 중 하나.
			if(n-Moolength.get(m-1)==1)
				return 'm';
			else
				return 'o';
		}
		
		return B_search(n-Moolength.get(m-1)-(m+3));
		//s(k-1)에서의 n을 재 매핑?해주는 것이다.
	}
}
