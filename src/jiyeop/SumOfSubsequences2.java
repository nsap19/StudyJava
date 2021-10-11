package jiyeop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class SumOfSubsequences2 {
	/**
	 * 부분 수열의 합2*/
	static int N;
	static int S;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr= new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		List<Integer> left = new ArrayList<Integer>();
		List<Integer> right = new ArrayList<Integer>();
		
		calcsum(0, N/2, 0, left);
		calcsum(N/2, N, 0, right);//범위가 넓어서 분할로 계산
		
		left.sort(Comparator.reverseOrder());
		right.sort(Comparator.naturalOrder());
		
//		for (int i = 0; i < left.size(); i++) {
//			System.out.print(left.get(i)+" ");
//		}
//		System.out.println();
//		for (int i = 0; i < right.size(); i++) {
//			System.out.print(right.get(i)+" ");
//		}
		
		
		long cnt = b_search(left, right);
		if(S==0) cnt--;
		System.out.println(cnt);
		
	}
	static long b_search(List<Integer> left,List<Integer> right) {
		long cnt = 0; 
		int l = 0;
		int r = 0;
		while (l<left.size() && r<right.size()) {
			int leftsum = left.get(l);
			int rightsum = right.get(r);
			int sum = leftsum + rightsum;
			if(sum>S) {
				l++;
			}
			else if(sum<S) {
				r++;
			}
			else {
				long leftcnt = 0l;
				long rightcnt = 0l;
				while(r<right.size() && leftsum + right.get(r) == S) {
					r++;
					rightcnt++;
				}
				while(l<left.size() && rightsum + left.get(l) == S) {
					l++;
					leftcnt++;
				}
				
				cnt += leftcnt * rightcnt;
			}
		}
		return cnt;
	}
	//부분 수열의 합을 모두 더함
	static void calcsum(int start, int end, int sum, List<Integer> sumList) {
		if(start == end) {
			sumList.add(sum);
			return;
		}
		calcsum(start+1, end, sum, sumList);
		calcsum(start+1, end, sum+arr[start], sumList);
	}
}
