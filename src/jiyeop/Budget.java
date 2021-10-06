package jiyeop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Budget {
	/**예산
	 * 처음엔 함수사용해서 풀다가 안됨
	 * 함수 제거 후 else부분에 재작성
	 * M은 n 보다 크다에서 Min을 n으로설정했는데 그게 오류 
	 * 원랜 max를 정렬후 배열의 마지막 값으로 가져왔는데 
	 * 그렇게 하니까 9퍼에서 틀림*/
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] area = new int[N];
		int sum = 0;
		int max = 0;
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
			area[i] = Integer.parseInt(st.nextToken());
			sum += area[i];
			max = Math.max(area[i], max);
		}
		int M = Integer.parseInt(br.readLine());
		if(sum <= M) {
			System.out.println(max);
		}
		else {
			int min = 0;
			int mid = 0;
			int answer = 0;
			while(min<=max) {
				/**System.out.println(low+" "+high);
				 * 4 150
				 * 77 150
				 * 113 150
				 * 113 131
				 * 122 131
				 * 126 131
				 * 126 128
				 * 127 128
				 * 127 128
				 * 127 128
				 * 127 128 반복이되서 멈추는 지점을 하나 더 정해줌
				 * */
				sum = 0;
				mid = (min + max) / 2;
				if(mid == min) {
					break;
				}
				for (int i = 0; i < N; i++) {
					if(area[i]<=mid) {
						sum+=area[i];
					}
					else {
						sum+=mid;
					}
				}
				if(M>=sum) {
					min = mid;
					answer = Math.max(answer, mid);
				}
				else {
					max = mid;
				}
				
			}
			System.out.println(answer);
		}
	}	
}
