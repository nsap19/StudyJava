package hyemin;

import java.io.*;
import java.util.*;

class Road implements Comparable<Road> {
    int start;
    int end;
    int dist;

    public Road(int start, int end, int dist) {
        this.start = start;
        this.end = end;
        this.dist = dist;
    }

    @Override
    public int compareTo(Road o) {
        return this.start - o.start;
    }
}

public class BOJ1446_지름길 {
    static Road[] list;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

//        첫째 줄에 지름길의 개수 N과 고속도로의 길이 D가 주어진다.
//        N은 12 이하이고, D는 10,000보다 작거나 같은 자연수이다.
//        둘째 줄부터 N개의 줄에 지름길의 시작 위치, 도착 위치, 지름길의 길이가 주어진다.
//        모든 위치와 길이는 10,000보다 작거나 같은 음이 아닌 정수이다. 지름길의 시작 위치는 도착 위치보다 작다.

        //0부터 시작할 거란 보장, 지름길의 마지막이 D일거란 보장이 없기때문에 모든 거리마다 지름길이 있는지 확인해줘야할듯!
        //시작점을 기준으로 정렬해줘서 순차적으로 조회해야할듯

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); //지름길의 개수
        int D = Integer.parseInt(st.nextToken()); //고속도로의 길이
        list = new Road[N]; //지름길을 넣은 배열
        dist = new int[D + 1];
        Arrays.fill(dist, 100000);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            list[i] = new Road(start, end, dist);
        }

        Arrays.sort(list); //시작점기준으로 오름차순 정렬

        //백트래킹 시작
        int index = 0; //list배열을 순회할 때 필요한 index
        int distance = 0; //1씩 증가하는 현재 거리의 위치
        dist[0] = 0;
        while (distance < D) {
            while (index < N) {
                if (distance != list[index].start) break; //현재 위치에서 지름길이 없다면 break;

                // 지름길 이동
                if (list[index].end <= D) { //지름길의 끝이 고속도로의 끝에 도달하는지 확인
                    int shortRoad = dist[distance] + list[index].dist;
                    if (dist[list[index].end] > shortRoad) { //지름길의 끝이 가리키는 거리의 기존 길이 vs 현재 위치+지름길의 길이
                        dist[list[index].end] = shortRoad;
                    }
                }
                index++;
            }

            //distance 지점에 지름길이 없다면 이전 지점 + 1 과 현재 지점의 값을 비교하여 최솟값으로 갱신
            if (dist[distance + 1] > dist[distance] + 1) {
                dist[distance + 1] = dist[distance] + 1;
            }
            distance++;
        }
//        System.out.println(Arrays.toString(dist));
        System.out.println(dist[D]);
    }


}
