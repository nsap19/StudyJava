package hyemin;

import java.util.Arrays;

public class Programmers42746 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{6, 10, 2}));
        System.out.println(solution(new int[]{3, 30, 34, 5, 9}));

    }

    public static String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        String[] sNum = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            sNum[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(sNum, (o1, o2) -> ((o2 + o1).compareTo(o1 + o2)));

        if (sNum[0].equals("0")) return "0"; //sNum[0]이 "0"인 경우는 0으로만 이루어진 숫자 배열이라는 의미, "0000"이 아닌 "0"을 리턴해야함

        for(String s: sNum){
            sb.append(s);
        }
        return sb.toString();
    }
}
