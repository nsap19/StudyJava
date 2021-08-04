package hyemin;

import java.util.PriorityQueue;

public class Programmers42626 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 9, 10, 12}, 7)); //2

    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }

        while (pq.peek() < K) {
            if (pq.size() == 1) {
                answer = -1;
                break;
            }

            pq.add(pq.poll() + pq.poll() * 2);
            answer++;
        }

        return answer;
    }

}
