package jiyoung.week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class DoublePriorityQueue {
//	I 숫자	큐에 주어진 숫자를 삽입합니다.
//	D 1	큐에서 최댓값을 삭제합니다.
//	D -1	큐에서 최솟값을 삭제합니다.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		
		String[] op = {"I 16","D 1"};
		String[] op2 = {"I 7","I 5","I -5","D -1"};
		String[] op3 = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
		//-45 -642 45 
//		s.solution(op);
//		s.solution(op2);
		s.solution(op3);
	}
	static class Solution {
		
//		테스트 1 〉	통과 (5.80ms, 57.6MB)
//		테스트 2 〉	통과 (15.84ms, 57.8MB)
//		테스트 3 〉	통과 (6.10ms, 59.2MB)
//		테스트 4 〉	통과 (0.36ms, 67.1MB)
//		테스트 5 〉	통과 (25.71ms, 72.7MB)
//		테스트 6 〉	통과 (16.98ms, 54.5MB)
//		시간이 오래걸리는거같아요,,
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		List<Integer> maxList = new ArrayList<>();
		
	    public int[] solution(String[] operations) {
	        int[] answer = {};
	        StringTokenizer st;
	        
	        for (String o : operations) {
	        	st = new StringTokenizer(o, " ");
	        	String op = st.nextToken();
	        	int num = Integer.parseInt(st.nextToken());
	        	switch(op) {
	        	case "I":
	        		insert(num);
	        		break;
	        	case "D":
	        		if(num == -1) 
	        			deleteMin();
	        		else 
	        			deleteMax();
	        		break;
	        	}
			}
	        
	        if(maxHeap.size()==0)
	        	answer = new int[]{0, 0};
	        else {
	        	int max = maxHeap.peek();
	        	int min = minHeap.peek();
	        	answer = new int[] {max, min};
	        }
	        System.out.println(Arrays.toString(answer));

	        return answer;
	    }
	    public void insert(int n) {
	    	maxHeap.add(n);
	    	minHeap.add(n);
	    	System.out.println("insert" + n);
	    }
	    public void deleteMax() {
	    	if(!maxHeap.isEmpty()) {
	    		int n = maxHeap.poll();
	    		maxList.add(n);
	    		minHeap.remove(n);
	    		System.out.println("del max" + n);
	    	}
	    }
	    public void deleteMin() {
	    	if(!minHeap.isEmpty()) {
	    		int n = minHeap.poll();
	    		maxHeap.remove(n);
	    		System.out.println("del min" + n);
	    	}
	    }
	}
}
