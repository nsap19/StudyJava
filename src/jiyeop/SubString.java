package jiyeop;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SubString {
	/**부분 문자열
	 * kmp 알고리즘*/
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		String P = br.readLine();
		int n = check(S, P);
		
		System.out.println(n);
		
	}
	static int check(String S, String P) {
		
		int pi[]  = new int[P.length()];
		int j = 0;
		for (int i = 1; i < P.length(); i++) {
			while(j>0 && P.charAt(i) != P.charAt(j)) {
				j = pi[j-1];
			}
			if(P.charAt(i) == P.charAt(j))
				pi[i]=++j;//반드시 이거여야함 반대로 안됨
		}
		int cnt = 0;
		j=0;
		for (int i = 0; i < S.length(); i++) {
			while(j>0 && S.charAt(i) != P.charAt(j)) {
				j = pi[j-1];
			}
			if(S.charAt(i) == P.charAt(j)) {
				if(j==P.length()-1) {
					return 1;
				}
				else {
					j++;
				}
			}
		}
		return 0;
	}
}
