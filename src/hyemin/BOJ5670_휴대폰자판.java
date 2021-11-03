package hyemin;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ5670_휴대폰자판 {
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

        public double check(String word) {
            TrieNode thisNode = this.rootNode;

            int cnt = 1;
            TrieNode node = thisNode.childNodes.get(word.charAt(0));
            for (int i = 1; i < word.length(); i++) {
                char c = word.charAt(i);
                if (node.childNodes.size() >= 2) cnt++;
                else if (node.childNodes.size() == 1 && node.isLastChar) cnt++;

//                System.out.println(c+" "+cnt);

                node = node.childNodes.get(c);
            }
            return cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String t = br.readLine();
        while ((t=br.readLine())!=null) { //이부분때문에 계속 널포인터 떳음....
            int testCase = Integer.parseInt(t);

            Trie trie = new Trie();
            String[] words = new String[testCase];
            for (int i = 0; i < testCase; i++) {
                String word = br.readLine();
                trie.insert(word);
                words[i] = word;
            }

            double cnt = 0;
            for (int i = 0; i < testCase; i++) {
                cnt += trie.check(words[i]);
            }

            cnt /= testCase;
            sb.append(String.format("%.2f", cnt)).append("\n");

            t = br.readLine();
        }
        System.out.println(sb);
    }
}
