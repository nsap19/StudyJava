package jiyeop;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Palindrome {
	/**펠린드롬
	 * 펠린드롬 0
	 * 유사 펠린드롬 1 한문자만 삭제하는 경우
	 * 그외 2 
	 * 반례 
	 * abca 출력 0 답 1
	 * */
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			String str = br.readLine();
			int num = palindrome(str);
			sb.append(num).append("\n");
		}
		System.out.println(sb);
	}
	static int palindrome(String str) {
		int left = 0;
		int right = str.length()-1;
		int res = 0;
		while(left<=right) {
			if(str.charAt(left) == str.charAt(right)) {
				left++;
				right--;
			}
			else {
				res++;
				int l_point = left;
				int r_point = right;
				l_point++;
				while(l_point<=r_point) {
					if(str.charAt(l_point) == str.charAt(r_point)) {
						l_point++;
						r_point--;
					}
					else {
						res++;
						break;
					}
				}
				l_point = left;
				r_point = right;
				r_point--;
				
				while(l_point<=r_point) {
					if(str.charAt(l_point) == str.charAt(r_point)) {
						l_point++;
						r_point--;
					}
					else {
						res++;
						break;
					}
				}
				if(res>1) {
					res -= 1;
					//오로지 abca를 위한 코드
				}
				return res;
			}
		}
		return res;
	}
}
