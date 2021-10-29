package jiyeop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class FindingPrefix {
	/**
	 * 접두사 찾기
	 * 부분집합으로 비교해서 풀면 쉬웠을 것 같다.
	 * 한번 구현해보고자 트라이 사용
	 * */
	static class TrieNode{
		Map<Character, TrieNode> node = new HashMap<>();
		boolean lastChar;
		
		public TrieNode() {
		}
		public void insert(String str) {
			TrieNode trieNode = this;
			int len = str.length();
			for (int i = 0; i < len; i++) {
				char c = str.charAt(i);
				
				trieNode.node.putIfAbsent(c, new TrieNode());
				//key, 다음 노드 연결
				trieNode = trieNode.node.get(c);
				
				if(i == len - 1) {
					trieNode.lastChar = true;
					return;
				}
			}
		}
		public boolean contains(String str) {
			TrieNode trieNode = this;
			int len = str.length();
			for (int i = 0; i < len; i++) {
				char c = str.charAt(i);
				TrieNode word = trieNode.node.get(c);
				
				if(word == null) {
					return false;
					//다음 문자가 없으면 false
				}
				trieNode = word;
			}
			return true;
			//접두사를 찾는 문제이기 때문에 특별한 이유가 없으면 true 처리
		}
	}
	static int N;
	static int M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		TrieNode trieNode = new TrieNode();
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			trieNode.insert(str);
		}
		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			if(trieNode.contains(str)) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
