package jiyeop;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bureaucracy {
	/**
	 * 유효한  법률 찾기
	 * 새로운 법률 제시 or 이전 법률을 취소
	 * 법의 종류 
	 * 즉시 발의하는 법, 법률을 취소하는 법
	 * 법률을 취소하는 법이 없는 경우 활성화
	 * 
	 * declare 법률 선언
	 * cancel num x번째 줄은 num의 법을 삭제
	 * 예제 ex 
	 * 2번째 줄 법은 1번째 법 삭제
	 * 4번쨰 법은 2번째 법 삭제
	 * 5번째 법은 3번째 법 삭제 
	 * 
	 * 
	 * 
	 * 출력법률 수
	 * 남아있는 유효 법률*/
	static boolean[] cancelled;
	static int[] laws;
	static int n;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		laws = new int[n];
		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");
			
			if("declare".equals(str[0])) {
				laws[i] = -1;
				//1~n까지이므로 법의 유효함 선정 
				//삭제하는 법률없음 -1 
			}
			else {
				laws[i] = Integer.parseInt(str[1]);
				//삭제하는 법률 저장
			}
		}

		cancelled = new boolean[n];
		for (int i = n-1; i>=0; i--) {
			if(!cancelled[i] && laws[i] != -1) {
				cancelled[laws[i] - 1] = true;
			}//가장 최근에 선정된 법이 이전의 법에 모두 영향을 줄수있으므로
			//맨뒤부터 시작해야한다.
		}
		int cnt =0;
		for (int i = 0; i < n; i++) {
			if(!cancelled[i]) {
				cnt++;
			}
		}
		System.out.println(cnt);
		for (int i = 0; i < n; i++) {
			if(!cancelled[i]) {
				System.out.print((i+1)+" ");
			}
		}
	}
}
