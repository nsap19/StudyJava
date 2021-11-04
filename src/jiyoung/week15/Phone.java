package jiyoung.week15;

import java.util.HashMap;
import java.util.Map;

public class Phone {

	// P4 5670 휴대폰자판
	
	// 자식개수가 하나면 자동입력
	// 자식에 터미널이 여러개면 안됨
	
	// ㅠㅠㅠ시간이 없다
	
	static class Trie {
		class Node {
			Map<Character, Node> child = new HashMap<>();
			boolean isTerminal = false;
		}

		Node root;

		public Trie() {
			root = new Node();
		}

		public void insert(String str) {
			int len = str.length();
			Node cur = root;

			for (int i = 0; i < len; i++) {
				char c = str.charAt(i);
				cur.child.putIfAbsent(c, new Node());
				cur = cur.child.get(c);
			}
			cur.isTerminal = true;
		}

		public boolean find(String str) {
			int len = str.length();
			Node cur = root;

			for (int i = 0; i < len; i++) {
				char c = str.charAt(i);
				if (cur.child.getOrDefault(c, null) == null)
					return false;
				cur = cur.child.get(c);
			}
			return true;
		}
	}

	public static void main(String[] args) {
		
	}

}
