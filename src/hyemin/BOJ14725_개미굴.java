package hyemin;

import java.io.*;
import java.util.*;

public class BOJ14725_개미굴 {
    static class TrieNode {
        TreeMap<String, TrieNode> childNodes = new TreeMap<>();
        //계속 틀리다가 hashmap에서 treemap으로 바꿧더니 통과햇음
        //treemap은 중복된 키로 저장할 수 없지만 같은 값을 다른 키로 저장하는것은 가능하다고 했는데 이것때문인가...
        //hashMap과 다른점은 SortedMap을 impl하였기때문에 key에 대해 정렬이 이루어짐 -> 따로 정렬처리를 하지 않아도 된다.
        //hashMap은 equals, treeMap은 compareTo로 비교
    }

    static class Trie {
        TrieNode rootNode;

        public Trie() {
            rootNode = new TrieNode();
        }

        public void insert(String[] words) {
            TrieNode thisNode = rootNode;
            for (int i = 0; i < words.length; i++) {
                thisNode = thisNode.childNodes.computeIfAbsent(words[i], s -> new TrieNode());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Trie trie = new Trie();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            String[] words = new String[k];
            for (int j = 0; j < k; j++) {
                words[j] = st.nextToken();
            }
            trie.insert(words);
        }

        printTrie(trie.rootNode, "");
    }

    private static void printTrie(TrieNode node, String depth) {

        Set<String> set = node.childNodes.keySet();

        for (String word : set) {
            System.out.println(depth + word);
            TrieNode next = node.childNodes.get(word);
            printTrie(next, depth + "--");
        }
    }
}
