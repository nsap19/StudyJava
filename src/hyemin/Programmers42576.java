package hyemin;

import java.io.*;
import java.util.HashMap;

//participant	completion	return
//["leo", "kiki", "eden"]	["eden", "kiki"]	"leo"
//["marina", "josipa", "nikola", "vinko", "filipa"]	["josipa", "filipa", "marina", "nikola"]	"vinko"
//["mislav", "stanko", "mislav", "ana"]	["stanko", "ana", "mislav"]	"mislav"
public class Programmers42576 {
    public static void main(String[] args) throws IOException {
        System.out.println(solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
        System.out.println(solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"}));
        System.out.println(solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"}));

    }

    public static String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String arg : participant) map.put(arg, map.getOrDefault(arg, 0) + 1);

        for (String arg : completion) map.put(arg, map.get(arg) - 1);

        for (String key : map.keySet()) {
            if (map.get(key) != 0) return key;
        }

        return null;
    }
}
