package jiyeop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class AntCave {
	/**
	 * 개미굴*/
	static class TrieNode{
		TreeMap<String, TrieNode> node = new TreeMap<>();
		//선언하면 레드블랙트리로 선언되고 자동으로 정렬시켜준다고 한다.
		//균형을 유지해준다 생각하면 되고 자동 사전순?오름차순?정렬이 좋은듯
	}
	static class Trie{
		TrieNode root;
		public Trie() {
			root = new TrieNode();
		}
		public void insert(String str) {
			TrieNode trieNode = root;
			int index = 0;
			
			for (int i = 0; i < arr.length; i++) {
				String word = str.substring(index,index+arr[i]);
				index = index + arr[i];
				//key, 다음 노드 연결
				trieNode.node.putIfAbsent(word, new TrieNode());
				trieNode = trieNode.node.get(word);
			}
		}
	}
	static void print(TrieNode node , int depth) {
		//문자열로 안만들고 저장시 구조적으로 저장되는게 아니라 abcd따로 따로 저장되는듯
		for (String key : node.node.keySet()) {
			for (int i = 1; i < depth; i++) {
				System.out.print("--");
			}
			System.out.println(key);
			print(node.node.get(key), depth+1);
		}	
	}
	
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		Trie trie = new Trie();
		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			int num = Integer.parseInt(str[0]);
			String buf = "";
			//문자열로만들기 
			arr = new int[num];
			//글자수를 저장할것
			for (int j = 1; j <= num; j++) {
				arr[j-1] = str[j].length();
				buf+=str[j];
			}
			trie.insert(buf);	
		}
		TrieNode cNode = trie.root;
		for (String key : cNode.node.keySet()) {
			System.out.println(key);
			print(cNode.node.get(key),2);
		}	
	}
}
