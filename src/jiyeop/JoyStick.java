package jiyeop;

public class JoyStick {
	/**그리디
	 * 위 -> 이전 알파벳
	 * 아래 -> 다음 알파벳
	 * 좌 -> 이전 문자열
	 * 우 -> 다음 문자열
	 * 좌우이동 최솟값 + 상하이동최솟값 RLMin,OUmin
	 * ZABCDEFGHIJKLM
	 * NOPQRSTUVWXYZA
	 * 문제를 잘 이해해야한다. 
	 * 맨 처음에서 왼쪽으로가면 맨 마지막으로 가지만
	 * 맨 마지막에서 오른쪽으로는 갈수없다.*/
	static class joystick {
	    public int solution(String name) {
	        int answer = 0;
	        int LRMin = name.length() - 1;
	        //A가 없을때 가장 최솟값
	        for (int i = 0; i < name.length(); i++) {
	        	//상하이동 이건 쉽다
				char ch = name.charAt(i);
				
				int OUmin = Math.min(ch - 'A', 'Z' - ch +1);
				
				answer += OUmin;
				 //좌우이동
				int next = i+1;
				while(next<name.length()&&name.charAt(next)=='A') {
					next++;
				}
				//i는 오른쪽으로 이동한 것
				//name.length() - next 는 마지막 B까지의 거리
				//i를 한번 더 더해주는 이유는 갔다 돌아오는경우
				//구조는 i만큼 갔다가 i만큼 되돌아오고 가야할 지점까지 가는 거리 계산
				// 거리계산은 i만큼 갔을 때 i+1위치에 a가 있으면 next를 늘려줌
				LRMin = Math.min(LRMin, (i*2)+name.length()-next);
				System.out.println(i+" "+name.length()+" "+next+" "+LRMin);
			}
	       
	        answer += LRMin;
	        
	        System.out.println(answer);
	        return answer;
	        
	    }
	}
	public static void main(String[] args) {
		String str = "BBBAAAAABA";
		joystick sol = new joystick();
		sol.solution(str);
	}
}
