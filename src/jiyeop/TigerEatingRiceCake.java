package jiyeop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class TigerEatingRiceCake {

	static int[] pivot;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int D = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		pivot = new int[D+1];
		
		pivot[1] = 0;
		pivot[2] = 1;
		int A = 1;
		int B = 1;
		for (int i = 3; i < D+1; i++) {
			pivot[i] = pivot[i-1]+pivot[i-2];
		}
		while(true) {
			int sum = A * pivot[pivot.length-2] + B * pivot[pivot.length-1];
			if(K == sum) {
				break;
			}
			else if(K>sum) {
				B++;
			}
			else {
				A++;
				B--;
			}
		}
		System.out.println(A);
		System.out.println(B);
	}

}
