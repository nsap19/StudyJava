package jiyeop;

import java.util.LinkedList;
import java.util.Scanner;

public class RotatingQueue {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList<Integer> Deque = new LinkedList<Integer>();
		
		int count = 0;
		
		int N = sc.nextInt();//큐의 크기
		int M = sc.nextInt(); //뽑을 수의 개수
		int[] arr = new int[M];//뽑을 숫자를 담자
		for (int i = 1; i <= N; i++) {
			Deque.offer(i);
		}
		for (int i = 0; i < M; i++) {
			arr[i]= sc.nextInt(); //이 숫자들을 뽑을거야
		}
		for(int i=0;i<M;i++) {
			int target_idx = Deque.indexOf(arr[i]);
			int half_idx;
			
			if(Deque.size()%2==0) {
				half_idx = Deque.size()/2 - 1;
				//크기 짝수
			}
			else {
				half_idx = Deque.size()/2;
				//크기 홀수
			}
			if(target_idx<=half_idx) {
				//중간값이 추출값보다 큰가?
				for (int j = 0; j < target_idx; j++) {
					int temp =Deque.pollFirst();
					Deque.offerLast(temp);
					count++;
					//타겟 앞의 값을 다 빼고 뒤에 넣는다
				}
			}
			else
			{
				for (int j = 0; j < Deque.size()-target_idx; j++) {
					int temp =Deque.pollLast();
					Deque.offerFirst(temp);
					count++;
					//타겟 뒤에 값을 다빼고 앞에 넣는다
				}
			}
			Deque.pollFirst();
		}
		System.out.println(count);

	}

}
