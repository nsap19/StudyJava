package jiyeop;

import java.util.HashMap;
/**완주하지 못한자!*/
public class UnsuccessfulRunner {

	public static void main(String[] args) {
		/**케이스 제작*/
		String[] participant = {"leo", "kiki", "eden"};
		String[] completion = {"leo", "kiki"};
		
		/**솔루션 클래스*/
		Solution sol = new Solution();
		sol.solution(participant, completion);
	}
}

/**솔루션 클래스*/
class Solution{
	public String solution(String[] participant, String[] completion) {
		String answer =""; //정답저장
		
		/**해쉬
		 key = 이름, value : 숫자
		 정의*/
		HashMap<String,Integer> HM = new HashMap<>(); 
		/**각 이름 마다 value 부여 
		 * 
		 * default 0
		 * key값이 동일하면 1
		 * 데이터 검색이 아니라 단순히 중복 검사이기 때문에 0,1로 구분 */
		for(int i=0;i<participant.length;i++) {
			HM.put(participant[i], HM.getOrDefault(participant[i], 0)+1);
		}
		
		//System.out.println(HM); /**출력 돌렸을 때 예  {name 1 name2 1 name2 1}*/
		/**해쉬업뎃 
		 * key값이 있으면 value -1하기ㅣ
		 * 
		 * */
		
		for(int i=0;i<completion.length;i++) {
			HM.put(completion[i], HM.get(completion[i]) - 1);
		}
		/**돌렸을 때 예  {name 0 name2 1 name2 0}*/
		
		
		for(int i = 0; i<participant.length;i++) {
			/**value 값이 1인 경우에만 중복되지 않음 */
			if(HM.get(participant[i])!=0) {
				answer = participant[i];
			}
		}
		
		//System.out.println(HM);
		return answer;
	}
}