package hyemin;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//I 숫자  큐에 주어진 숫자를 삽입합니다.
//D 1   큐에서 최댓값을 삭제합니다.
//D -1   큐에서 최솟값을 삭제합니다.

public class Programmers42628 {
    public static void main(String[] args) throws IOException {
//        System.out.println(Arrays.toString(solution(new String[]{"I 16", "D 1"})));
//        System.out.println(Arrays.toString(solution(new String[]{"I 7", "I 5", "I -5", "D -1"})));
        System.out.println(Arrays.toString(solution(new String[]{"I 4", "I 3", "I 2", "I 1", "D 1", "D 1", "D -1", "D -1", "I 5", "I 6"}))); //[6,5]
    }

    private static int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int size = 0;
        StringTokenizer st;

        for (int i = 0; i < operations.length; i++) {
            st = new StringTokenizer(operations[i], " ");
            String command = st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            switch (command) {
                case "I":
                    size++;
                    minHeap.offer(num);
                    maxHeap.offer(-num);
                    break;
                case "D":
                    if(size==0) break;

                    if (num == 1) {
                        maxHeap.poll();
                    } else {
                        minHeap.poll();
                    }
                    size--;
                    if(size==0){
                        maxHeap.clear();
                        minHeap.clear();
                    }
                    break;
            }
        }

        if (size == 0) {
            answer[0] = 0;
            answer[1] = 0;
        } else {
            answer[0] = -maxHeap.poll();
            answer[1] = minHeap.poll();
        }
        return answer;
    }
}
