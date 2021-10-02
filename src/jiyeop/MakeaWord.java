package jiyeop;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MakeaWord {
	/**단어 만들기
	 * 여러 단어가 주어짐, 문자 표가 주어짐
	 * 문자표안에 있는 단어로만 단어를 만들수있다.
	 * 가운데 문자는 반드시 들어가야한다. 
	 * 문자표안에 없는 문자가 있으면 정답이 아니다. 갯수가 달라도 정답이 아니다.
	 * 
	 * 결론 - 어렵다 구현하기 싫다 휴일인데 잠만 잤는데 2일이나 지났다.
	 * 구현 너무어렵다..
	 * 문자 수도 비교, 문자 여부도 비교해야홤. 
	 * 조건은 맞게 구했는데 continue pos 부분은 참고를 했다.
	 * */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] arr = new int[200000][26];
		int index = 0;
		while(true) {
			String str = br.readLine();
			
			if(str.equals("-")){
				break;
			}
			for (int i = 0; i < str.length(); i++) {
				arr[index][str.charAt(i)-'A']++;
			}
			index++;
		}//여러 단어 저장
		
		while(true) {
			String str = br.readLine();
			if(str.equals("#")){
				break;
			}
			int[] table = new int[26];//문자표
			int[] solve = new int[26];//정답 테이블 
			for (int i = 0; i < 9; i++) {
				table[str.charAt(i)-'A']++;
			}//단어표 저장
pos:			for (int i = 0; i < index; i++) {
					for (int j = 0; j < 26; j++) {
						if(arr[i][j] > table[j]) {
							continue pos;
						}
					}
					for (int j = 0; j < 26; j++) {
						if(arr[i][j]>0) {
							solve[j]++;
						}
					}
				}//정답 저장?
			
				int min = Integer.MAX_VALUE;
				int max = Integer.MIN_VALUE;
			
				for (int i = 0; i < 26; i++) {
					if(solve[i]!=0) {//최소값은 조건이 복잡
						min = Math.min(solve[i], min);
					}
					if(solve[i] == 0 && table[i] > 0) {
						min = 0;
					}
					max = Math.max(solve[i], max);
					//최대값은 조건이없다.
				}
				StringBuilder sbmin = new StringBuilder();
				StringBuilder sbmax = new StringBuilder();
				
				for (int i = 0; i < 26; i++) {
					if(solve[i] == min && min!=0) {
						sbmin.append((char)(i+'A'));
					}
					else if(min == 0 && table[i]>0 && solve[i]==0) {
						sbmin.append((char)(i+'A'));
					}
					if(max == solve[i] && table[i]>0) {
						//table[i]>0 보다 크다는 조건은 필수 max값은 당연히 큰값이라 안넣어줬다
						//table에 없으면서도 solve에  max값이 되는 케이스가 존재하는듯.
						//초기화 시켜놓고하면 없을수도있을거같다.그럼 min값이 복잡해지겠지
						//그래서 넣어줬다. 이것도 참고함.
						sbmax.append((char)(i+'A'));
					}
				}
				System.out.println(sbmin+" "+ min + " " + sbmax+" "+ max);
		}
	}
}
