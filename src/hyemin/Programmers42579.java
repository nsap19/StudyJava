package hyemin;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Programmers42579 {
    public static void main(String[] args) throws IOException {
        System.out.println(Arrays.toString(solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500})));
        // 4,1,3,0
        System.out.println(Arrays.toString(solution(new String[]{"A", "A", "B", "A", "B", "B", "A", "A", "A", "A"}, new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1})));
        //0,1,2,4
    }

    public static int[] solution(String[] genres, int[] plays) {
        int[] answer;
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<String, Integer> genre_count = new HashMap<>(); //장르이름, 장르별 재생횟수


        //장르별 재생횟수 count
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            genre_count.put(genre, genre_count.getOrDefault(genre, 0)+play);
        }

        //재생횟수에 따른 장르 정렬
        ArrayList<String> list = new ArrayList<>(genre_count.keySet());
        Collections.sort(list,(o1, o2) -> (genre_count.get(o2).compareTo(genre_count.get(o1)))); //내림차순

        //가장 많이 재생된 장르 순으로 반복문
        for(String genre : list){
            HashMap<Integer,Integer> song_count = new HashMap<>(); //고유번호, 재생횟수
            for (int i = 0; i < genres.length; i++) {
                if(genres[i].equals(genre)){
                    song_count.put(i, plays[i]); //genre에 해당하는 곡을 고유번호와 재생횟수를 song_count에 넣어줌
                }
            }

            //재생횟수에 따른 고유변호 정렬
            ArrayList<Integer> list2 = new ArrayList<>(song_count.keySet());
            Collections.sort(list2,(o1, o2) -> (song_count.get(o2).compareTo(song_count.get(o1))));

            //가장 많이 재생된 2곡만 result에 넣어줌. 장르에 속한 곡이 하나라면, 하나의 곡만 선택하기 위해 list2의 길이만큼 반복
            int temp = 0;
            for(int i : list2){
                if(temp >=2) break;
                result.add(i);
                temp++;
            }
        }

        //ArrayList -> array
        answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
