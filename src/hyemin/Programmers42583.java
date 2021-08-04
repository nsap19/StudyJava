package hyemin;

import java.util.LinkedList;
import java.util.Queue;

public class Programmers42583 {
    public static void main(String[] args) {
        System.out.println(solution(2, 10, new int[]{7, 4, 5, 6})); //8
        System.out.println(solution(100, 100, new int[]{10})); //101
        System.out.println(solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10})); //110
        System.out.println(solution2(2, 10, new int[]{7, 4, 5, 6})); //8
        System.out.println(solution2(100, 100, new int[]{10})); //101
        System.out.println(solution2(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10})); //110
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int onBridgeWeight = 0; //다리를 건너고 있는 트럭의 무게
        int min = 0; //트럭이 다리를 건너는데에 걸리는 시간
        Queue<Integer> bridge = new LinkedList<>(); //다리를 건너고 있는 트럭

        // 1- 다리가 비어있는 경우
        // 2- 트럭이 다리를 다 건넌 경우
        // 3- 트럭이 다리위에 하나 이상 있고, 추가로 트럭이 더 올라갈 수 있는 경우
        // 4 - 트럭이 다리위에 하나 이상 있고, 추가로 트럭이 더 올라갈 수 없는 경우
        for (int truck : truck_weights) {
            while (true) {
                if (bridge.isEmpty()) { //case 1
                    bridge.add(truck);
                    min++;
                    onBridgeWeight += truck;
                    break;
                } else if (bridge.size() == bridge_length) { //case 2
                    onBridgeWeight -= bridge.peek();
                    bridge.poll();
                } else { //다리에 트럭이 한개 이상 올라가있을 때
                    if (onBridgeWeight + truck <= weight) { //case 3
                        bridge.add(truck);
                        min++;
                        onBridgeWeight += truck;
                        break;
                    } else { //case 4
                        bridge.add(0);
                        min++;
                    }
                }
            }
        }
        return min + bridge_length;
    }
    //테스트 1 〉	통과 (1.14ms, 52.8MB)
    //테스트 2 〉	통과 (13.43ms, 52.9MB)
    //테스트 3 〉	통과 (0.13ms, 52.2MB)
    //테스트 4 〉	통과 (11.41ms, 53.6MB)
    //테스트 5 〉	통과 (35.97ms, 60MB)
    //테스트 6 〉	통과 (19.92ms, 55.7MB)
    //테스트 7 〉	통과 (3.48ms, 53.1MB)
    //테스트 8 〉	통과 (0.59ms, 52.5MB)
    //테스트 9 〉	통과 (5.25ms, 52.3MB)
    //테스트 10 〉	통과 (0.72ms, 53.2MB)
    //테스트 11 〉	통과 (0.16ms, 53MB)
    //테스트 12 〉	통과 (1.21ms, 53MB)
    //테스트 13 〉	통과 (3.99ms, 52.4MB)
    //테스트 14 〉	통과 (0.12ms, 52.9MB)

    //다른 사람의 풀이 - 조금 더 간결하지만, 수행시간은 더 걸림
    public static int solution2(int bridge_length, int weight, int[] truck_weights){
        Queue<Integer> q = new LinkedList<Integer>();
        // 현재 다리는 비어있음
        for(int i=0;i<bridge_length;i++)
            q.add(0);
        int sum=0,count=0;
        // 트럭 수만큼 돌꺼임
        for(int t : truck_weights) {
            // 다리에 올라가면 최대 용량인 경우
            while((sum + t - q.peek()) > weight) {
                sum-=q.poll();
                q.add(0);
                count++;
            }
            // 트럭이 올라갈 수 있는 경우
            sum -= q.poll();
            sum += t;
            q.add(t);
            count++;
        }
        return count+bridge_length;
    }
}
//테스트 1 〉	통과 (1.74ms, 53MB)
//테스트 2 〉	통과 (11.52ms, 53.4MB)
//테스트 3 〉	통과 (0.16ms, 53MB)
//테스트 4 〉	통과 (11.80ms, 53.2MB)
//테스트 5 〉	통과 (43.02ms, 60.7MB)
//테스트 6 〉	통과 (16.81ms, 54.9MB)
//테스트 7 〉	통과 (1.74ms, 53.1MB)
//테스트 8 〉	통과 (0.51ms, 52.4MB)
//테스트 9 〉	통과 (3.76ms, 53.6MB)
//테스트 10 〉	통과 (0.61ms, 53.5MB)
//테스트 11 〉	통과 (0.15ms, 54MB)
//테스트 12 〉	통과 (0.84ms, 52.8MB)
//테스트 13 〉	통과 (5.81ms, 52.4MB)
//테스트 14 〉	통과 (0.20ms, 53MB)