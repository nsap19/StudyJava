package jiyeop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class DecreasingNumber {
	/**
	 * 감소하는 수 
	 * ex) 321 950 
	 * 0 1 2 3 4 5 6 7 8 9  0
	 * 10 20 21 30 31 32 ~~ 1
	 * 210 310 320 321 ~~  2 
	 * 3210 4321 ~	3
	 * N 번째 감소하는 수가 없다면 -1을 출력한다.??
	 * 0<=N<=1,000,000 
	 * 가장큰 감소하는 수 98765 43210
	 *  */
	static ArrayList<Long> arr = new ArrayList<Long>();
	//long이 아니면 마지막값이 이상하게 나옴 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		if(N<=10) {
			System.out.println(N);
		}
		else if(N>1022) {
			System.out.println(-1);
			//1022는 9876543210의 index
			//1023부터 처리를 안해주면 IndexOutOfBounds 런타임 에러
		}
		else {
			for (int i = 0; i < 10; i++) {
				bt(i,1);
			}
			Collections.sort(arr); 
			// 정렬해야함 백트래킹으로 정렬도시키고싶었는데 못함
			System.out.println(arr.get(N));
		}
	}
	
	static void bt(long num, int depth) {
		if(depth > 10) {
			//98765 43210이 딱 10자리이다
			return;
		}
		arr.add(num);
		
		for (int i = 0; i < (num % 10); i++) {
			bt((num * 10) + i, depth + 1);
		}
	}
}
