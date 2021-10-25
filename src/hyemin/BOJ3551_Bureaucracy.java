package hyemin;

import java.io.*;
import java.util.*;

public class BOJ3551_Bureaucracy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] list = new ArrayList[n + 1];
        int[] indegree = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            if (str.equals("declare")) continue;
            st = new StringTokenizer(str, " ");
            st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            list[i].add(num);
            indegree[num]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = n; i > 0; i--) {
            if (indegree[i] == 0) queue.add(i);
        }


        ArrayList<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            result.add(cur);

            for (int next : list[cur]) {
                if (list[next].size() > 0) {
                    indegree[list[next].get(0)]--;
                    if (indegree[list[next].get(0)] == 0) queue.offer(list[next].get(0));
                    list[next].clear();
                }
            }
        }

//        System.out.println(Arrays.toString(indegree));


        Collections.sort(result);
        System.out.println(result.size());
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }


    }
}


/*
9
declare
cancel 1
declare
cancel 1
cancel 1
cancel 2
cancel 2
cancel 2
declare
 */

