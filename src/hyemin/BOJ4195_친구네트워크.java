package hyemin;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ4195_친구네트워크 {
    static HashMap<String, String> parents;
    static HashMap<String, Integer> friends;

    private static int union(String a, String b) {
        String ap = find(a);
        String bp = find(b);

        if (!ap.equals(bp)) {

            if (!friends.containsKey(ap)) friends.put(ap, 1);
            if (!friends.containsKey(bp)) friends.put(bp, 1);

            parents.put(bp, ap);
            friends.put(ap, friends.get(ap) + friends.get(bp));
        }
        return friends.get(ap);
    }

    private static String find(String a) {
        if (parents.get(a).equals(a)) return a;
        return parents.put(a, find(parents.get(a)));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < T; testCase++) {
            int N = Integer.parseInt(br.readLine());
            parents = new HashMap<>();
            friends = new HashMap<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                String a = st.nextToken();
                String b = st.nextToken();

                if (!parents.containsKey(a)) parents.put(a, a);
                if (!parents.containsKey(b)) parents.put(b, b);

                int result = union(a, b);
                sb.append(result).append("\n");
            }
        }

        System.out.println(sb);
    }
}

/*
1
8
a b
b c
d e
e f
g h
h i
a f
c i
* */