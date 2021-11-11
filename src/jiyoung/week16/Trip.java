package jiyoung.week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Trip {

	// G4 1976 여행가자
	
	// 행렬 절반만 보면서 연결시키고
	// 막줄 부모가 전부 같은지 확인하면 될듯
	
	public static int n;
	public static int[] parents;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		
	}
	
	public static void make() {
		parents = new int[n+1];
		for (int i = 1; i <= n; i++) {
			parents[i] = i;
		}
	}

}
