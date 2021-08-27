package jiyeop;

import java.util.Arrays;
import java.util.HashSet;

public class FindPrimeNumber {
	/**에라토스테네스의 체*/
	static HashSet<Integer> HS = new HashSet<>();//중복저장을 허용치않아
	/**
	 * 테스트 1 〉	통과 (0.43ms, 61.9MB)
		테스트 2 〉	통과 (7.71ms, 60.8MB)
		테스트 3 〉	통과 (0.26ms, 61.4MB)
		테스트 4 〉	통과 (4.70ms, 74.3MB)
		테스트 5 〉	통과 (38.17ms, 77.8MB)
		테스트 6 〉	통과 (0.24ms, 67.2MB)
		테스트 7 〉	통과 (0.37ms, 73.6MB)
		테스트 8 〉	통과 (53.71ms, 78.2MB)
		테스트 9 〉	통과 (0.25ms, 60.9MB)
		테스트 10 〉	통과 (3.88ms, 69.7MB)
		테스트 11 〉	통과 (1.11ms, 58MB)
		테스트 12 〉	통과 (5.64ms, 76.4MB) 
		*/
	
	static class findprimenumber{
		public int solution(String numbers) {
	        int answer = 0;
	        int n = numbers.length();
	        String[] str = numbers.split("");        
	        for (int i = 1; i <= str.length; i++) {
				perm(str,0,n,i);//보내는 문자배열, 몇개쨰 뽑았는지  , 숫자갯수, 몇개 뽑을래?
				//arr 0 5 4 이면 5개 중 4개 뽑기 뎁스가 1증가하면 현재 1개를 뽑은 상태란 뜻
			}
	        
	        System.out.println(HS);
	        answer = HS.size();
	        System.out.println(answer);
	        return answer;
	    }
		//순열 코드
		static void perm(String[] arr, int depth,int n, int r) {	
			if(depth == r) {
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < r; i++) {
				   sb.append(arr[i]);
				}
				//포문으로 돌리지 않고 그냥 arr하면 배열이기 때문에 배열사이즈 만큼 출력한다.
				//반드시 r만큼 돌려주어야한다. 
				
				//System.out.println(Integer.parseInt(sb.toString()));
				//Integer.parseInt(sb.toString())을 쓰면
				// 011이어도 11로 반환한다.
				Prime(Integer.parseInt(sb.toString()));
				return;
			}
			for (int i = depth; i < n; i++) {
				swap(arr, depth, i);
				perm(arr, depth+1, n, r);
				swap(arr, depth, i);
			}
		}
		static void swap(String[] arr,int depth, int i) {
			String temp = arr[depth];
			arr[depth] = arr[i];
			arr[i] = temp;
		}
		
		// 소수 판정...에라토스테네스의 체 참고함 
		// 이건 정말 좋은 것 같다.
		/**
		 * 120이하는 2 3 5 7의 배수만 지워도 모두 소수
		 * 169이하의 소수를 모두 구하고 싶으면 13 보다 작은 소수의 배수를 모두 제외하면 된다.
		 * */
		static void Prime(int num) {
			int sqrt_num = (int)Math.sqrt(num);//num의 제곱근 만큼 돌린다
			boolean flag=true;
	        if(num==2)//2제외
	            flag = true;
	        else if(num%2==0||num==1)//2의 배수 1 제외
	            flag = false;
	        else{//가장 중요 포문 // 3부터 num의 제곱근까지 홀수로 나누기
	        	//보통 소수가 껴있다.
	          for(int i=3;i<=sqrt_num;i+=2){
	        	  if(num % i == 0)
	                flag = false;
	        }
	        }
	        if(flag){
	            HS.add(num);
	        }
			
		}
	}
	public static void main(String[] args) {
		String numbers = "169";
		findprimenumber sol = new findprimenumber();
		sol.solution(numbers);
		
//		int a = Integer.parseInt("011");
//		System.out.println(a);
	}
}
