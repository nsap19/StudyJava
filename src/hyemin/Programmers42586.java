package hyemin;

//progresses	speeds	return
//[93, 30, 55]	[1, 30, 5]	[2, 1]
//[95, 90, 99, 99, 80, 99]	[1, 1, 1, 1, 1, 1]	[1, 3, 2]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Programmers42586 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(Solution.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5})));
        System.out.println(Arrays.toString(Solution.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1})));
        System.out.println(Arrays.toString(Solution2.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5})));
        System.out.println(Arrays.toString(Solution2.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1})));
    }

}

class Solution {
    static public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> resultList = new ArrayList<>();
        int[] result;

        for (int i = 0; i < progresses.length; i++) {
            int pDay = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]); //작업 기간
            //3.1일 => 4일로 처리해야하므로 Math.ceil을 이용해 올림

            queue.add(pDay);
        }
//        System.out.println(queue.toString());

        int day = queue.peek(); //첫 기능과 같은 날에 배포될 기능을 구할 것임
        int count = 0;
        while (!queue.isEmpty()) {
            while (!queue.isEmpty() && queue.peek() <= day) { // 첫번째 기능이 배포되는 날에 같이 배포할 수 있는 기능 갯수 count
                count++;
                queue.poll();
            }

            resultList.add(count);
            count = 0;

            //day를 다음 기능이 배포되는 날로 지정
            if (!queue.isEmpty()) day = queue.peek();

        }

        result = new int[resultList.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }
}

//while문 중첩이 너무 시간적으로 별로 인 것 같아 다른 풀이 참고
class Solution2 {
    static public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> resultList = new ArrayList<>();
        int[] result;

        for (int i = 0; i < progresses.length; i++) {
            int pDay = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]); //작업 기간

            if (!queue.isEmpty() && queue.peek() < pDay) {
                resultList.add(queue.size());
                queue.clear();
            }

            queue.add(pDay);
        }
        resultList.add(queue.size());

        result = new int[resultList.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }
}