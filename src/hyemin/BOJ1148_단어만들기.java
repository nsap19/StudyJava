package hyemin;

import java.io.*;
import java.util.*;

public class BOJ1148_단어만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String word = "";
        int[][] words = new int[200000][26]; //배열을 안만들고 arraylist로 단어추가했더니 메모리초과가 났음 ㅜ
        int index = 0;
        while (true) {
            word = br.readLine();
            if (word.equals("-")) break;

            for (int i = 0; i < word.length(); i++) {
                words[index][word.charAt(i) - 'A']++;
            }
            index++;
        }

        while (true) {
            word = br.readLine();
            if (word.equals("#")) break;

            int[] alpha = new int[26]; //퍼즐판 알파벳 파악
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < word.length(); i++) { //퍼즐판 생성
                char c = word.charAt(i);
                alpha[c - 'A']++;
                map.put(c, 0);
            }

            loop:
            for (int i = 0; i < words.length; i++) { //퍼즐판으로 해당 단어를 만들 수 있는지 확인
                for (int j = 0; j < 26; j++) {
                    if (words[i][j] > alpha[j]) continue loop;
                }

                //해당 퍼즐판으로 단어를 만들수 있는 경우
                for (int j = 0; j < 26; j++) {
                    if (words[i][j] > 0) {
                        char c = (char) (j + 'A');
                        map.put(c, map.get(c) + 1);
                    }
                }
            }


            int max = -1;
            int min = 10000;
            for (Character c : map.keySet()) { //max, min 구하기
                if (map.get(c) > max) max = map.get(c);
                if (map.get(c) < min) min = map.get(c);
            }

            ArrayList<Character> list = new ArrayList<>(map.keySet());
            Collections.sort(list); //알파벳 정렬
            for (Character c : list) {
                if (map.get(c) == min) sb.append(c);
            }
            sb.append(" ").append(min).append(" ");
            for (Character c : list) {
                if (map.get(c) == max) sb.append(c);
            }
            sb.append(" ").append(max).append("\n");
        }

        System.out.println(sb);
    }
}
