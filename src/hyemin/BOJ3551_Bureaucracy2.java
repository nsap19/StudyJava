package hyemin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ3551_Bureaucracy2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[][] command = new String[n + 1][];
        int[] indegree = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            command[i] = br.readLine().split(" ");
        }

        for (int i = n; i > 0; i--) {
            if (command[i][0].equals("declare")) continue;
            if (indegree[i] == 0) {
                int num = Integer.parseInt(command[i][1]);
                indegree[num]--;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i < indegree.length; i++) {
            if (indegree[i] == 0) result.add(i);
        }

//        Collections.sort(result);
        System.out.println(result.size());
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }


    }
}
