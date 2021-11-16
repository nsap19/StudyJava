package jiyeop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class FriendNetwork {
	static int[] parents;//대표나타내기
	static int[] count;//친구세기
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
		int T = Integer.parseInt(br.readLine());
		HashMap<String, Integer> hm = new HashMap<>();
		for (int testCase = 0; testCase < T; testCase++) {
			int F = Integer.parseInt(br.readLine());
			parents = new int[F*2];
			count = new int[F*2];
			
			for (int i = 0; i < F*2; i++) {
				parents[i] = i;
				count[i] = 1;
			}
			int num = 0;
			for (int i = 0; i < F; i++) {
				String[] str = br.readLine().split(" ");
				
				if(!hm.containsKey(str[0])) {
					hm.put(str[0], num++);
				}
				if(!hm.containsKey(str[1])) {
					hm.put(str[1], num++);
				}
				
				int num1 = hm.get(str[0]);
				int num2 = hm.get(str[1]);
				union(num1,num2);
				System.out.println(count[find(num1)]);
			}
//			for (int i = 0; i < F*2; i++) {
//				System.out.print(parents[i]+" ");
//			}
//			System.out.println();
//			for (int i = 0; i < F*2; i++) {
//				System.out.print(count[i]+" ");
//			}
//			System.out.println();
		}
		
	}
	static int find(int a) {
		if(a==parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot !=bRoot ) {//없으면 오류남
			if(aRoot>bRoot) {
				parents[aRoot] = bRoot;
				count[bRoot] += count[aRoot];
				count[aRoot]=0;
			}
			else {
				parents[bRoot] = aRoot;
				count[aRoot] += count[bRoot];
				count[bRoot]=0;
			}
		}
	}
}
