package jiyeop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TheTowerofBabylon {
	/**
	 * TheTowerofBabylon
	 * 위상정렬?
	 * 답을 못구해서 참고한 코드 들고옵니다.
	 * dp같은데 정확히 모르겠어요*/
	static int[] x;
	static int[] y;
	static int[] z;
	static int[][] d;
	static int min = 1000000000;//이거여야한다고
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = 1;
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n==0) {
				break;
			}
			x = new int[1000];
			y = new int[1000];
			z = new int[1000];
			d = new int[1000][1000];
			
			int index = 0;
			for (int i = 0; i < n; i++) {
				String[] str = br.readLine().split(" ");
				int a = Integer.parseInt(str[0]);
				int b = Integer.parseInt(str[1]);
				int c = Integer.parseInt(str[2]);
				
				if(a<b) {
					x[index] = a;
					y[index] = b;
					z[index++] = c;
				}
				else {
					x[index] = b;
					y[index] = a;
					z[index++] = c;
				}
				
				if(a<c) {
					x[index] = a;
					y[index] = c;
					z[index++] = b;
				}
				else {
					x[index] = c;
					y[index] = a;
					z[index++] = b;
				}
				
				if(b<c) {
					x[index] = b;
					y[index] = c;
					z[index++] = a;
				}
				else {
					x[index] = c;
					y[index] = b;
					z[index++] = a;
				}
			}
//			for (int i = 0; i < index; i++) {
//				System.out.println(x[i]+" "+ y[i]+" "+z[i]);
//			}
			
			for (int i = 0; i < index; i++) {
				for (int j = 0; j < index; j++) {
					if(x[i]<x[j] && y[i]<y[j]) {
						d[i][j] = z[i];
					}
					else {
						d[i][j] = -min;
					}
				}
			}
//			for (int i = 0; i < index; i++) {
//				for (int j = 0; j < index; j++) {
//					System.out.print(d[i][j]+" ");
//				}
//				System.out.println();
//			}
			int top = index;
			int bottom = index + 1;
			for (int i = 0; i < index; i++) {
				d[i][top] = -min;
				d[top][i] = 0;
				d[i][bottom] = z[i];
				d[bottom][i] = -min;
			}
			d[top][bottom] = -min;
			d[bottom][top] = -min;
			index+=2;
			for (int k = 0; k < index; k++) {
				for (int i = 0; i < index; i++) {
					for (int j = 0; j < index; j++) {
						d[i][j] = Math.max(d[i][j], d[i][k] + d[k][j]);
						
					}
				}
			}
//			for (int i = 0; i < index; i++) {
//				for (int j = 0; j < index; j++) {
//					System.out.print(d[i][j]+" ");
//				}
//				System.out.println();
//			}
			
			sb.append("Case ").append(T).append(": ").append("maximum height = ")
			.append(d[top][bottom]).append("\n");
			T++;
		}
		System.out.println(sb);
	}
}
