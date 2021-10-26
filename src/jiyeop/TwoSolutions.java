package jiyeop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TwoSolutions {
	/**
	 * 두 용액
	 * 두 수의 합이 0에 가장 가까울 때
	 * 숫자를 기록
	 * 같은 경우 아무거나 출력*/
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st= new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int num1 = 0;
		int num2 = 0;
		Arrays.sort(arr);
		//제일 작은 숫자가 맨앞 제일 큰숫자가 맨 뒤
		//두개의 합이 가장 0에 가까울것
		int left = 0;
		int right = N-1;
		int min = Integer.MAX_VALUE;
		while(left<right) {
			int sum = arr[left] + arr[right];
			if(Math.abs(sum)<min) {
				min = Math.abs(sum);
				num1 = arr[left];
				num2 = arr[right];
			}
			if(sum>0) {
				right--;
			}else if(sum<0){
				left++;
			}
			else {
				break;
			}
		}
		System.out.println(num1+" "+ num2);
	
	}

}
