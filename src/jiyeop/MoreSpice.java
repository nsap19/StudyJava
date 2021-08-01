package jiyeop;

import java.util.PriorityQueue;

public class MoreSpice {
	
	static class morespice{
	    public int solution(int[] scoville, int K) {
	        int answer = 0;
	        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
	        
	        for (int val : scoville) {
				heap.add(val);
			}
	        /**
	         *System.out.println(heap);
	         *System.out.println(heap.poll());
	         *System.out.println(heap.size());
	         *System.out.println(heap.poll());
	         *System.out.println(heap.peek());
	         *System.out.println(heap.size());
	         *우선순위 큐 테스트 poll,peek할시 가장 작은 값이 나온다
	         *peek 할시 데이터 보여줄뿐 팝은 안함*/
	       //peek할시 제한 값보다 크면 종료
	        while(heap.peek()<K) {
				if(heap.size()==1) {
					return -1;
				}
				int num1 = heap.poll();
				int num2 = heap.poll();
				
				int res = num1 +(num2*2);
				
				heap.add(res);
				answer++;	
			}
	        
	        return answer;
	    }
	}
	
	
	public static void main(String[] args) {
		int[] scoville = {5,2,3,9,10,12};
		int K = 7;
		
		morespice sol = new morespice();
		sol.solution(scoville, K);
		/**섞은 음식의 스코빌 지수 = 
		 * 가장 맵지 않은 음식의 스코빌 지수 + 
		 * (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)*/

	}

}
