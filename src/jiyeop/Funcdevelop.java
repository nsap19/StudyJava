package jiyeop;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Stack;

public class Funcdevelop {

	public static void main(String[] args) {
		
		int[] progresses = {93, 30, 55};
		int[] speeds = {1, 30, 5};
		Funcd sol = new Funcd();
		sol.Funcd(progresses, speeds);

	}

}

class Funcd {
	public int[] Funcd(int[] progresses, int[] speeds) {
    	int N = progresses.length;
    	int[] answer;	
    	int start = 0;
    	Stack<Integer> stack = new Stack<>();
    	int num = N;
    	
    	while(num>0) {  		
    		for(int i=0;i<N;i++) {
    			progresses[i] += speeds[i];
    		}
    		int count = 0;
    		for(int i = start; i<N;i++) {
    			if(progresses[i] < 100) {
    				break;
    			}
    			start++;
    			count++;
    		}
    		if(count !=0) {
    		stack.push(count);
    		num = num - count;
    		}
    	}
    	answer = new int[stack.size()];
    	for (int i = 0; i < answer.length; i++) {
			answer[i]=stack.get(i);
		}    	
    	System.out.println(Arrays.toString(answer));
    	return answer;
    }
}