package jiyeop;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MakingaPalindrome {
	/**팰린드롬
	 * 앞에서 읽으나 뒤에서 읽으나 같게 읽히는 문자열
	 * 문자열 S에 0개 이상의 문자를 뒤에 추가해서 펠린드롬을 만들 것
	 * 가능한 가장 짧게 
	 * 문자열이 짝수일때 홀수 일때
	 * 중간 지점 정하기 
	 * 펠린드롬 확인법 - 문자의 첫자리 끝자리부터 잘라서 비교 or 문자의 중간부터 하나씩 비교 
	 * 최소문자 갯수 구하기 ex) abab일경우 bab 펠린드롭 성립  4+1 = 5;
	 * abcab일경우 성립불가  abcabacba 5 + 4 9 
	 * 
	 *  */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		int len = minlen(S);
		System.out.println(len);
	}
	static int minlen(String S) {
		int len =S.length();
		for (int i = 0; i < len; i++) {
			if(isPalindrome(S.substring(i))) {
				return len + i;
			}
		}
		return len*2;//짜고 나니 의미가 없었다.
		//문자가 하나 남는 순간 팰린드롬이 성립되기 때문에 무조건 포문안에서 끝난다.
	}
	static boolean isPalindrome(String S) {
		int len = S.length();
		for (int i = 0; i < len/2; i++) {
			if(!S.substring(i, i+1).equals(S.substring(len-i-1,len - i))) {
				return false;
			}
		}
		return true;
	}
}
