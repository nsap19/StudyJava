package jiyeop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class StringSet {
	/**
	 * 문자열 집합
	 * 아무리 생각해도 map이 더 쉽다.*/
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int cnt = 0;
		HashMap<String, Integer> map = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			map.put(br.readLine(), 1);
		}
		for (int i = 0; i < M; i++) {
			if(map.get(br.readLine())!=null) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
