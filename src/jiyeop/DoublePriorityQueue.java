package jiyeop;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class DoublePriorityQueue {
	/**
	 * l은 숫자 삽입, D는 삭제, -1은 최솟값 삭제, 1은 최댓값 삭제
	 * operation은 큐가 수행할 연산
	 * 스플릿으로 잘라서 명령어 인식*/
	public static class doublepriorityqueue{
		public int[] solution(String[] operations) {
	        //최소 힙 최대힙 선언, 힙 하나로 해볼려했는데 안되서 편하게 두개 선언했다.
			//String 타입으로 저장하면 큰오류가 생긴다.
			//Integer로 바꿔서 저장하면 마음이 편해진다.
	        PriorityQueue<Integer> Minheap = new PriorityQueue<Integer>();
	        PriorityQueue<Integer> Maxheap = new PriorityQueue<Integer>(Collections.reverseOrder());
	        String[] str = null;
	        //최대 최소 저장
	        int max = 0;
        	int min = 0;
	        for (int i = 0; i < operations.length; i++) {
	        	//스플릿 str 크기는 2
				str = operations[i].split(" ",2);
				//System.out.println(Arrays.toString(str));
				//스위치 케이스로 I과 D중 선택
				switch (str[0]) {
				case "I":
					//저장 l이 아니라 I 였다.
					Maxheap.add(Integer.parseInt(str[1]));
					Minheap.add(Integer.parseInt(str[1]));
					break;	
				case "D":
					//삭제
					if(!Maxheap.isEmpty()) {
						if(str[1].equals("1")) {
							//최대 힙 poll -> 최소 힙 remove
							Minheap.remove(Maxheap.poll());
						}
						else {
							//최소 힙 poll -> 최대 힙 remove
							Maxheap.remove(Minheap.poll());
						}
					}
					break;
				}
			}
	        //비어있으면 0 안하면 케이스 마지막 틀리는듯
	        if(Minheap.isEmpty()) {
	        	max = 0;
	        	min = 0;
	        }
	        else {
	        	max = Maxheap.peek();
		        min = Minheap.peek();
	        }
	        int[] answer = {max, min};
	        //System.out.println(Arrays.toString(answer));
	        return answer;
	    }
	}
	
	public static void main(String[] args) {
		String[] str = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
		//String 타입으로 저장할 시 힙에 남지말아야 할 값이 남는다 
		doublepriorityqueue sol = new doublepriorityqueue();
		sol.solution(str);
	}
}
