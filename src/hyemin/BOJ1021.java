package hyemin;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = 0;
        int size = Integer.valueOf(st.nextToken());
        int t = Integer.valueOf(st.nextToken());

        Deque<Integer> dq = new LinkedList<>();
        Queue<Integer> nums = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            dq.add(i + 1);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < t; i++) {
            nums.add(Integer.parseInt(st.nextToken()));
        }

        while (!nums.isEmpty()) {
            //num의 위치 찾기
            int num = nums.poll();
            int index = 0;
            for (int x : dq) {
                if (x == num) break;
                index++;
            }

//            System.out.println(num+" "+index);
//            System.out.println(dq.toString()+" "+dq.size());

            if (index == 0) {
                dq.pollFirst();
            } else if (index <= dq.size() / 2) { //찾으려는 수가 덱의 앞쪽에 있을 때 -> 2번 연산(왼쪽으로 이동)이 유리)
//                System.out.println("왼쪽으로 이동");
                for (int i = 0; i < index; i++) {
                    dq.addLast(dq.pollFirst());
                    result++;
                }
                dq.pollFirst();

            } else {//찾으려는 수가 덱의 뒤쪽에 있을 때 -> 3번 연산(오쪽으로 이동)이 유리
//                System.out.println("오른쪽으로 이동");
                for (int i = 0; i < dq.size() - index; i++) {
                    dq.addFirst(dq.pollLast());
                    result++;
                }
                dq.pollFirst();

            }
        }
        System.out.println(result);
    }
}
