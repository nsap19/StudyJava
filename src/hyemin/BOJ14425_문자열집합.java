package hyemin;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 1. trie와 trieNode를 클래스 밖에 선언하면 시간초과가 남
// 2. insert와 contains에 public을 안하면 시간초과가 남
// 3. java11로 해야 시간초과가 안남,,,(이게 제일 어이없음)
public class BOJ14425_문자열집합 {
    static class TrieNode {
        Map<Character, TrieNode> childNodes = new HashMap<>();
        boolean isLastChar;
    }

    static class Trie {
        private TrieNode rootNode;

        Trie() {
            this.rootNode = new TrieNode();
        }

        public void insert(String word) {
            TrieNode thisNode = this.rootNode;
            for (int i = 0; i < word.length(); i++) {
                thisNode = thisNode.childNodes.computeIfAbsent(word.charAt(i), c -> new TrieNode());
            }
            thisNode.isLastChar = true;
        }

        public boolean contains(String word) {
            TrieNode thisNode = this.rootNode;

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                TrieNode node = thisNode.childNodes.get(c);

                if (node == null) return false;

                thisNode = node;
            }
            return thisNode.isLastChar;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Trie trie = new Trie();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            trie.insert(word);
        }

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            String word = br.readLine();
            if (trie.contains(word)) cnt++;
        }

        System.out.println(cnt);
    }
}
