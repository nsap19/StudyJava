package jiyeop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TheLongestString {
	//해쉬맵에 모든 부분문자열 저장해서 값 출력 -> 메모리초과 
	//라빈카프 알고리즘 적용 -> 시간초과 5%까지 감
	/**
	 * 시간을 줄이는 방법
	 * 1번 부분문자열의 길이는 최대 전체 문자열 길이의 반임
	 * 2번 ABC가 세번 반복될 경우 A,B,C도 각각 세번 반복됨 
	 * 애초에 모든 부분문자열을 비교하게되면 시간초과가 나는 것 같다.
	 * */
	
	/**
	 * 접미사 배열과 최대 공통 접두사? 알고리즘 
	 * 접미사 배열이란 abcde란 문자열이 있으면
	 * abcde bcde cde de e 이런식으로 문자열을 만들고 사전순으로 배열한것
	 * 쉽게 짤수도 있지만 시간을 ㄱ고려하면 Manber-Myers Algorithm을 사용해야한다. 
	 * O(N^2 × logN) -> O(N × log^2N) 
	 * 이건 사전 순 배열을 구하는 것이기 때문에  문자열 첫글자 - 'a'하고 랭크에 저장
	 * nextrank는  rank의 값을 가져오면됨 마지막 배열의 nrank = -1
	 * 랭크 개념과 기수정렬을 도입함
	 * 구현 방법 문자열 S의 접미사들을 첫글자 두번째 글자에 대해 사전순 정렬
	 * 정렬된 순서를 바탕으로 랭크 부여
	 * 접미사의 특성을 이용해 부여된 두개의 랭크를 기준으로 정렬 (비교 범위가 두배가 됨)
	 * 2로 돌아간다./*/
	
	/**
	 * lcp(최대 공통 접두사) 접두사 끼리 비교 배열의 i 값과 i+1값 비교
	 *  두 단어를 가지고 비교하는 경우에는 O(N^2)
	 *  시간을 고려하려면 Kasai알고리즘 사용 O(N × logN) 
	 *  현재 탐색하는 접미사의 최장공통접두사의 길이가 k이면 다음 탐색하는 접미사의 최장공통접두사 길이는 k-1이다.
	 *  가장 긴 접미사부터 길이가 짧아지는 순으로 접미사를 탐색
	 *  공통된 부분을 세어준다. 
	 *  LCP배열은 접미사 배열을 이용해서 만드는 배열이기 때문에 
	 *  LCP를 사용하려면 반드시 접미사 배열을 구해야함. 애초에 이런생각 못할것 같습니다.
	 *  0 8 abc				10	0
		1 1 abcabcfabc		1	3
		2 4 abcfabc			4	2
		3 9 bc				7	1
		4 2 bcabcfabc		2	0
		5 5 bcfabc			5	0
		6 10 c				8	0
		7 3 cabcfabc		9	0
		8 6 cfabc			0	3
		9 7 fabc			3	2
		10 0 sabcabcfabc	6	1*/
	static int L;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		L = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int max = 0;
		//suffixarray 접미사 배열
		int[] suffixArray = findSuffixArray(str);
//		for (int i = 0; i < suffixArray.length; i++) {
//			System.out.println(i+ " " + suffixArray[i] + " "+ str.substring(suffixArray[i],str.length()));
//			
//		}
		//lcp 최대 공통 접두사의 길이
		int[] lcp = findLCP(str,suffixArray);
		for (int i = 0; i < lcp.length-1; i++) {
			System.out.println(lcp[i]);
			max = Math.max(max, lcp[i]);
        }
		System.out.println(max);
	}

	static int[] findLCP(String str, int[] suffixArray) {
		int[] lcp = new int[L];
		int[] invSuff = new int[L];
		
		//invsuff에는 접미사 배열 순서 할당
		//ex> suffix[5] = 1; suffix[1] =5;
		for (int i = 0; i < L; i++) {
			invSuff[suffixArray[i]] = i;
		}
		
		int k=0;// LCP 길이 초기화
		for (int i = 0; i < L; i++) {
			if(invSuff[i] == L-1) {
				k=0;
				continue;
			}
			int j =suffixArray[invSuff[i] + 1];
			
			while(i+k<L && j + k <L) {
				if(str.charAt(i+k) != str.charAt(j+k)) {
					break;
				}
				k++;
			}
			lcp[invSuff[i]] = k;
			if(k>0) {
				k--;
			}
		}
		return lcp;
	}
	//Manber-Myers Algorithm 사용
	//접미사 배열을 O(log2n * N)으로 구할 수 있다.
	static int[] findSuffixArray(String str) {
		Suffix[] sa = new Suffix[L];
		//초기 인덱스, 각 접미사의 첫글자에 맞는 사전순 rank
		for (int i = 0; i < L; i++) {
			int rank = str.charAt(i)-'a';
			sa[i] = new Suffix(i, rank);
		}
		//접미사 두번째 글자로 nrank계산
		for (int i = 0; i < L-1; i++) {
			//현재 접미사의 두번째 글자와 다음 접미사의 두번째 글자와 동일
			sa[i].nextRank = sa[i+1].rank;
		}
		sa[L-1].nextRank = -1;
		
		//첫글자 두번째 글자에 따른 정렬
		Arrays.sort(sa);
		
		int[] temp = new int[L];
		//log N 만큼 작업
		for (int i = 4; i < 2*L; i <<= 1) {
			//rank 값 갱신
			int rank = 0;
			int prev = sa[0].rank;
			sa[0].rank = rank;
			temp[sa[0].index] = 0;
			//rank 값 갱신
			for (int j = 1; j < L; j++) {
				//rank 값 동일 여부 확인
				if(sa[j].rank == prev && sa[j].nextRank == sa[j-1].nextRank) {
					prev = sa[j].rank;
					sa[j].rank = rank;
				}
				else
				{
					prev = sa[j].rank;
					sa[j].rank = ++rank;
				}
				temp[sa[j].index] = j;
			}
			
			//nextrank 갱신
			for (int j = 0; j < L; j++) {
				int nextIdx = sa[j].index+(i/2);
				if(nextIdx >=L) {
					sa[j].nextRank = -1;
					continue;
				}
				sa[j].nextRank = sa[temp[nextIdx]].rank;
			}
			Arrays.sort(sa);
		}
		int[] suffixArray = new int[L];
		for (int i = 0; i < L; i++) {
			suffixArray[i] = sa[i].index;
		}
		return suffixArray;
	}
	
	
	static class Suffix implements Comparable<Suffix>{
		int index;
		int rank; 
		int nextRank;
		
		public Suffix(int index, int rank) {
			this.index = index;
			this.rank = rank;
		}
		public int compareTo(Suffix o) {
			if(this.rank!= o.rank)
				return Integer.compare(this.rank, o.rank);
			
			return Integer.compare(this.nextRank, o.nextRank);
		}
		
	}
}
