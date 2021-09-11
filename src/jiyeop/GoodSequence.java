package jiyeop;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GoodSequence {
	/**
	 * 임의의 길이의 인접한 두 개의 부분 수열이 동일한 것이 있으면 나쁜수열
	 * 인접한이 중요단어이다. 123123213은 나쁜 수열이지만 123213123은 나쁜수열이 아니라는 것
	 * 문자열을 반으로 자르고 반반 비교를 하면 될 것 같다.
	 * */
	static int N;
	static boolean end = false;
//	메모리 초과가 나서 재귀문을 끝낼 다른게 필요함.
//	static ArrayList<String> arr = new ArrayList<String>();
//	메모리 초과
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String st ="";
		bt(st);
	}
	static void bt(String str) {
		if(end) {
			return;
		}
		if(N == str.length()) {
			System.out.println(str);
			//System.out(0);로  종료할수 있다.찾아봄
			end = true;
			return;
		}
		for (int i = 1; i <= 3; i++) {
			if(check(str + i)) {
				bt(str+i);
			}
		}
	}
	static boolean check(String str) {
		int length = str.length();
		
		for (int i = 1; i <= length / 2; i++) {
			String str2 = str.substring(str.length() - (2*i) ,str.length() - i);
			String str3 = str.substring(str.length() - i,str.length());
			//swea 패턴마디의 길이 문제 풀이가 이것과 비슷하다.
			if(str2.equals(str3)) {
				return false;
			}
		}
		return true;
	}
}
