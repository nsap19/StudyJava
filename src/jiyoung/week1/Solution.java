package jiyoung.week1;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		단 한명만 빼고 마라톤을 완주
//		마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 
//		완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 
//		완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
		
//		마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
//		completion의 길이는 participant의 길이보다 1 작습니다.
//		참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
//		참가자 중에는 동명이인이 있을 수 있습니다.
		
		Scanner sc = new Scanner(System.in);
		
		//문자열자르기
		String input = sc.nextLine();
		String[] names = input.split("\", \"");
		names[0] = names[0].substring(2);
		String last = names[names.length-1];
		names[names.length-1] = last.substring(0,last.indexOf("\""));
		
//		for(String s : names) {
//			System.out.println("'"+s+"'");
//		}
		
		//해쉬로 풀라니까..
		///String[] hashMap = new String 
	}

}
