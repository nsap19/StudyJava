package jiyeop;

import java.util.Arrays;
import java.util.Comparator;

public class TheLargestNumber {
	static class thelargestnumber {
		public String solution(int[] numbers) {
	        String answer ="";
	        String[] num = new String[numbers.length];
	        for (int i = 0; i < numbers.length; i++) {
				num[i] = String.valueOf(numbers[i]);
			}
	        //System.out.println(Arrays.toString(num));
	        Arrays.sort(num,new Comparator<String>() {
	        	public int compare(String o1,String o2) {	
	        		return (o2+o1).compareTo(o1+o2);
	        		/**o1+o2, o2+o1 위치에 따라 결과가 바뀜
	        		 * [9, 5, 34, 3, 30]
	        		 * [9, 5, 34, 30, 3]o2 , o1 결과
	        		 * 추정 맨앞자리 비교 후 큰 거 부터 나열
	        		 * 앞자리가 같으면 큰수부터 나열
	        		 * */
	        	}
			});
	        if(num[0].equals("0")) {
	        	answer = "0";
	        	return answer;
	        }
	        //System.out.println(Arrays.toString(num));
	        for (String str : num) {
				answer+=str;
	        }
	        System.out.println(answer);
			return answer;
		}
	}
	
	public static void main(String[] args) {
		int [] arr = {3,35,34,5,9};
		thelargestnumber sol = new thelargestnumber();
		sol.solution(arr);
	}
}


