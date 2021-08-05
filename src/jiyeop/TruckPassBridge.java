package jiyeop;

import java.util.LinkedList;
import java.util.Queue;

public class TruckPassBridge {

	static class truckpassbridge{
		public int solution(int bridge_length, 
							int weight, int[] truck_weights) {
	        int answer = 0;
	        Queue<Integer> truckonb = new LinkedList<Integer>();
	        int sum=0;
	        for (int t : truck_weights) {
	        	while(true) {
	        		if(truckonb.isEmpty()) {
	        			truckonb.add(t);
	        			answer++;
	        			sum+=t;
	        			break;
	        		}
	        		else if(truckonb.size()==bridge_length) {
        				sum= sum-truckonb.poll();
        				
        			} 
	        		else {
	        			if(sum+t>weight) {
	        				truckonb.add(0);
	        				answer++;
	        			}
	        		else {
	        				truckonb.add(t);
	        				sum+=t;
	        				answer++;
	        				break;
	        			}
	        		}
	        	}
				
			}
	       System.out.println(answer);
	        return answer+bridge_length;
	        /**6이 들어가면 반복문 종료 answer는 증가시키지 않는다.
	         * 그러므로 answer연산 횟수가 부족해진다.
	         * 문제는 poll과 add가 동시에 이루어지므로 둘다 증가시키면 
	         * case를 만족하지못함
	         * poll할때 증가시키지말고 다리길이만큼 더해줘서 해결
	         * */
		}
	}
	
	
	
	public static void main(String[] args) {
		/**
		 *트럭은 1초당 1칸 지나감
		 *다리길이만큼 트럭이 올라감 일정 무게만큼 견딤
		 * */
		int bridge_length =2;
		int weight = 10;
		int[] truck_weights = {7,4,5,6};
		truckpassbridge sol =new truckpassbridge();
		sol.solution(bridge_length, weight, truck_weights);
	}
}
