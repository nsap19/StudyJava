package jiyeop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class CoordinateCompression {
	/**
	 * 간단한 정렬문제로는 보기어렵다. 
	 * 시간초과가 떠서  다른 방법을 써야했다..
	 * 배열 두개를 쓸까 해쉬를 쓸까 고민하다 해쉬를 쓰기로했다.
	 * 키값 - 배열 값 , 인덱스 - 압축된 좌표 
	 * 정렬전 똑같은 배열이 필요하다. 안하고 키값에 대입하면 정렬순으로 압축 좌표가 나옴
	 * 답을 구하기 위해선 정렬전 배열이 필요하다.*/
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Integer, Integer> hm = new HashMap<>();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		int[] clone = arr.clone();
		Arrays.sort(arr);
		
		int cnt=0;
		
		for (int i = 0; i < N; i++) {
			if(!hm.containsKey(arr[i])) {
				//중복 체크를 안할 경우 같은 값이 나오면 하나 올라감
				//대충 > 기호를 쓰는게 아니라 >= 이 기호를 쓴다 이해하면될듯
				hm.put(arr[i], cnt);
				cnt++;
			}
		}
		
		for (int i = 0; i < N; i++) {
			sb.append(hm.get(clone[i])).append(" ");
		}
		System.out.println(sb);

	}
}
