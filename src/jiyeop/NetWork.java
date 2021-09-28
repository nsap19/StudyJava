package jiyeop;
public class NetWork {
	/**네트워크
	 * 행렬의 뜻 0번째 노드에 연결된 노드는 1
	 * 예시면 0번은 1번과 연결
	 * 1번은 0번과 2번
	 * 3번은 2번과 연결되있다.
	 * 기존 2차원배열 nx ny가 아닌 다른 방식으로 찾아줬다.
	 * */
	static boolean[] visited;
	static class network {
	    public int solution(int n, int[][] computers) {
	        int answer = 0;
	       visited = new boolean[n];
	        for (int i = 0; i < n; i++) {
					if(!visited[i]) {
						dfs(i,n, computers);
						answer++;
					}
			}
	        return answer;
	    }
	}
	static void dfs(int i, int n, int[][] computers) {
		visited[i] = true;
    	for (int j = 0; j < n; j++) {
			if(!visited[j] && computers[i][j] == 1) {
				dfs(j,n,computers);
			}
		}
    }
	public static void main(String[] args) {
		network sol = new network();
		int n = 3;
		int[][] computers = {{1, 1, 0}, 
							{1, 1, 1},
							{0, 1, 1}};
		
		sol.solution(n, computers);
	}
}

