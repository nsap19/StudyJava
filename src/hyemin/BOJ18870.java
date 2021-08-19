package hyemin;

import java.io.*;
import java.util.*;

public class BOJ18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] list = new int[N];
        Set<Integer> sortedList = new TreeSet<>(); //트리셋을 이용하여 중복제거와 정렬
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            list[i] = (num);
            sortedList.add(num);
        }

        //정렬한 수대로 순회하며 좌표압축결과를 value로 한 map을 저장
        Iterator it = sortedList.iterator();
        HashMap<Integer, Integer> map = new HashMap<>();

        int count = 0;
        while (it.hasNext()) {
            map.put((Integer) it.next(), count++);
        }

        for (int i = 0; i < N; i++) {
            sb.append(map.get(list[i])).append(" "); //sysout으로 하면 시간초과가 나와서 sb를 사용
        }

        System.out.println(sb);

    }
}
