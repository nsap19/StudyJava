package jiyeop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeMap;

public class MobilePhoneKeyboard {
	/**
	 * 휴대폰 자판
	 * 저번주 트라이 알고리즘을 응용?
	 * 잘변형해서 풀었다. */
	static class TrieNode{
		TreeMap<Character, TrieNode> node = new TreeMap<>();
		boolean lastChar;
	}
	
	static class Trie{
		TrieNode root;
		
		public Trie() {
			root = new TrieNode();
		}
		
		public void insert(String str) {
			TrieNode trieNode = root;
			int len = str.length();
			
			for (int i = 0; i < len; i++) {
				char c = str.charAt(i);
				
				trieNode.node.putIfAbsent(c, new TrieNode());
				trieNode = trieNode.node.get(c);
				
				if(i == len - 1) {
					trieNode.lastChar = true;
					return;
				}
			}
		}
		public int contains(String str) {
			TrieNode trieNode = root;
			int len = str.length();
			int cnt = 1;
			//첫문자 입력후라 1
			trieNode = trieNode.node.get(str.charAt(0));
			//첫글자
			for (int i = 1; i < len; i++) {
				if(trieNode.node.size()>1) {
					cnt++;
					//하위 노드의 개수가 2개이상
				}
				if(trieNode.node.size() == 1 && trieNode.lastChar) {
					cnt++;
					//한문자가 다른문자의 부분문자열일때
					//hell hello
				}
				char c = str.charAt(i);
				trieNode = trieNode.node.get(c);
			}
			return cnt;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String T;
		while((T = br.readLine()) != null) {
			//이조건에서 안멈춘다. 그냥 공백이 들어옴
			Trie trie = new Trie();
			if(T.equals("")) {
				break;
				//조건문이 없을시 nullpointexception
			}
			int tc = Integer.parseInt(T);
			ArrayList<String> arr = new ArrayList<>();
			double sum = 0;
			for (int i = 0; i < tc; i++) {
				String str = br.readLine();
				arr.add(str);
				trie.insert(str);
			}
			
			for (int i = 0; i < arr.size(); i++) {
				sum += trie.contains(arr.get(i));
			}
			double avg = sum/tc;
			System.out.println(String.format("%.2f", avg));
		}
	}
}
