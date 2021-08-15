package jiyoung.week3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BiggestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num1 = { 6, 10, 2 };
		int[] num2 = { 3, 30, 34, 5, 9 };
		int[] num3 = { 300, 330, 90, 999, 31, 3400, 34 };
		int[] num4 = { 1, 2, 3, 4, 55555, 5, 6, 74, 77, 73, 7, 78, 8, 80, 88, 91, 99, 93, 92, 90, 1234543424 };
		int[] num5 = { 0, 0 };
		Solution s = new Solution();
		// s.solution(num1);
		s.solution(num2);
		s.solution(num4);
		s.solution(num5);
	}

}

class Solution {

	public String maxNum = "";
	public String tempNum = "";
	public ArrayList<Integer> list;
	public boolean[] visit;

	public String solution(int[] numbers) {
		String answer = "";

//		#3 세번째로 푼방법 - 풀이 참고 ** 내림차순정렬이면 됨 + 오래걸려서 첫번째 자리수별로 구분하게해봤는데 빠른경우도 느린경우도있음
//		테스트 1 〉	통과 (113.04ms, 89.5MB)
//		테스트 2 〉	통과 (68.52ms, 78.9MB)
//		테스트 3 〉	통과 (162.27ms, 92.9MB)
//		테스트 4 〉	통과 (15.43ms, 60.7MB)
//		테스트 5 〉	통과 (171.79ms, 83.3MB)
//		테스트 6 〉	통과 (163.19ms, 80.8MB)
//		테스트 7 〉	통과 (13.59ms, 56.3MB)
//		테스트 8 〉	통과 (16.23ms, 69.4MB)
//		테스트 9 〉	통과 (46.52ms, 72.7MB)
//		테스트 10 〉	통과 (5.88ms, 57.1MB)
//		테스트 11 〉	통과 (9.15ms, 68.3MB)
		
		List<ArrayList<String>> sortedArr = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			sortedArr.add(new ArrayList<String>());
		}

		for (int i = 0; i < numbers.length; i++) {	//첫번째 자리수별로 집어넣음
			sortedArr.get((numbers[i] + "").charAt(0) - '0').add(numbers[i] + "");
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 9; i >= 0; i--) {
			List<String> list = sortedArr.get(i);	//해당 인덱스로 시작하는 숫자가 없으면 넘어가고 있으면 내림차순정렬 후 스트링화
			
			if (list.size() == 0)
				continue;
			
			Collections.sort(list, new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					return (o2 + o1).compareTo(o1 + o2);
				}
			});

			for (String string : list) {
				sb.append(string);
			}
		}

		if (sb.charAt(0) == '0')
			return "0"; // 0으로 시작하는경우 0
		
		answer = sb.toString();
//		System.out.println(answer);
		return answer;
	}

//	#2 두번째로 풀었던 방법 - 첫번째 자릿수별로 나누고 순열 전부구해버려서 최대값찾기 - 시간초과 ㅎㅎ..
//	public void findMaxNum(String temp, int d) {
//		if (d == list.size()) {
////			System.out.println("MAX TEMP " + maxNum + " " + temp);
//			maxNum = compareString(maxNum, temp) > 0 ? maxNum : temp;
//			return;
//		}
//		for (int i = 0; i < list.size(); i++) {
//			if (visit[i])
//				continue;
//			visit[i] = true;
//			findMaxNum(temp + (list.get(i)+""), d+1);
//			visit[i] = false;
//		}
//	}
//
//	public int compareString(String str1, String str2) {
//		// str1이 크면 1, 2가크면 -1
//		if(str1.length()==0 || str2.length()==0) return 0;
//		char[] s1 = str1.toCharArray();
//		char[] s2 = str2.toCharArray();
//		for (int i = 0; i < str1.length(); i++) {
//			if (s1[i] > s2[i])
//				return 1;
//			else if (s1[i] == s2[i])
//				continue;
//			else
//				return -1;
//		}
//		return 0;
//	}
}



//	#1 첫번째로 풀었던방법 - 각 자릿수별로 비교하여 정렬 - 단, 자릿수가 더 길경우 맨 앞자리의 수와 비교하여 정렬
//	898   89, 878 87 처럼 반복되는수를 구분하지 못하여 버림

//class KeyValue implements Comparable<KeyValue> {
//	int num;
//
//	public KeyValue(int n, int i) {
//		this.num = n;
//	}
//
//	@Override
//	public int compareTo(KeyValue o) { // 음수 : 다른원소가 큼. num1이 나, num2가 다른원소
//		// num1이 크면 양수,num2가 크면 음수
//		String num1 = o.num + "";
//		String num2 = this.num + "";
//		int first = num1.charAt(0) - '0';
//		int i = 1;
//		if (num1.length() == 1 && num2.length() == 1)
//			return 0;
//		if (num1.length() >= num2.length()) { // num1이 더 길거나 같음
//			for (int j = 1; j < num1.length(); j++) {
//				if (num2.length() <= j) { // num2는 이미끝남
//					if (num1.charAt(j) - '0' <= first)
//						return -1; // num2가 더큼
//					else if (num1.charAt(j) - '0' == first)
//						continue; // 뒷자리도 봐야함
//					else
//						return 1; // num1이 큼
//				} else {
//					if (num1.charAt(j) - '0' < num2.charAt(j) - '0')
//						return -1; // num2가 더큼
//					else if (num1.charAt(j) - '0' == num2.charAt(j) - '0')
//						continue; // 뒷자리봐야됨
//					else
//						return 1; // num1이 큼
//				}
//			}
//		} else { // num1이 짧음
//			for (int j = 1; j < num2.length(); j++) {
//				num2.charAt(j);
//				if (num1.length() <= j) {
//					if (num2.charAt(j) - '0' <= first)
//						return 1; // num1이 더큼
//					else if (num2.charAt(j) - '0' == first)
//						continue;
//					else
//						return -1; // num2가 큼
//				} else {
//					if (num2.charAt(j) - '0' < num1.charAt(j) - '0')
//						return 1; // num1이 큼
//					else if (num2.charAt(j) - '0' == num1.charAt(j) - '0')
//						continue;
//					else
//						return -1; // num2가 큼
//				}
//			}
//		}
//		return 0;
//	}
//}