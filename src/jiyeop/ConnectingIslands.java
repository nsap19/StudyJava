package jiyeop;

import java.util.ArrayList;
import java.util.Collections;


public class ConnectingIslands {
	/**
	 * 그리디
	 * 최단거리 구하기, 크루스칼 프림
	 * 하나의 집합을 만드는 과정이라 생각 유니온 파인드
	 * 작은순으로 집합을 만들기 위해 
	 * 가중치로 오름 차순정렬
	 * 크루스칼이 편할지 유니온파인드가 편할지 문제마다 조금씩 다를듯
	 * */
	static int[] parents;
	static ArrayList<edge> graph = new ArrayList<>();
	static class edge implements Comparable<edge>{
		int from;
		int to;
		int cost;
		public edge(int from, int to, int cost) {
			super();
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		@Override
		public int compareTo(edge o) {
			
			return this.cost - o.cost;
		}	
	}
	static class connectingislands {
	    public int solution(int n, int[][] costs) {
	        int answer = 0;
	        parents = new int[n];
	        
	        for (int i = 0; i < n; i++) {
				parents[i]=i;
			}
	        for (int i = 0; i < costs.length; i++) {
				graph.add(new edge(costs[i][0], costs[i][1], costs[i][2]));	
			}
	       Collections.sort(graph);
	       //가중치 순위로 정렬을해준다.
	        
//	        for (int i = 0; i < costs.length; i++) {
//				System.out.print(graph.get(i).from+" "+graph.get(i).to+" "+
//						graph.get(i).cost);
//				System.out.println();
//			}
	       for (int i = 0; i < costs.length; i++) {
	    	   if(find(graph.get(i).from)==find(graph.get(i).to)) {
	    		   continue;
	    	   }
	    	   else {
	    		   if(union(graph.get(i).from, graph.get(i).to)) {
	    		   answer += graph.get(i).cost;
	    	   		}
	    	   }
	       }
	       System.out.println(answer);
	       return answer;
	    }
	}
	static int find(int a) {
		if(a==parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) {
		int[][] arr = {{0,1,1},
						{3, 1, 1},
						{0, 2, 2},
						{0, 3, 2},
						{0, 4, 100}
						};
		connectingislands sol = new connectingislands();
		sol.solution(5, arr);
	}
	

}
