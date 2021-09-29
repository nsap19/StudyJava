package jiyeop;

public class IntegerTriangle {
	/**정수 삼각형
	 * 위에서 내려갈까
	 * 아래에서 올라올까
	 * 위에서 내려가고 중간만 비교
	 * 아래에서 올라가면 비교를 많이해야함
	 * 정확성/ 효율성 통과*/
	static class integertriangle {
		static int[][] dp;
		public int solution(int[][] triangle) {
	        int answer = 0;
	        dp = new int[triangle.length][triangle.length];
	        dp[0][0] = triangle[0][0];
	        for (int i = 1; i < triangle.length; i++) {
	        	dp[i][0] = triangle[i][0] + dp[i-1][0];
	        	dp[i][triangle[i].length-1] = triangle[i][triangle[i].length-1] + dp[i-1][triangle[i].length-2];
				for (int j = 1; j < triangle[i].length-1; j++) {
					dp[i][j] = triangle[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]);
				}
			}
	        int max = 0;
	        for (int i = 0; i < triangle.length; i++) {
				max = Math.max(dp[triangle.length - 1][i], max);
			}
	        answer = max;
	        System.out.println(answer);
	        return answer;
	    }
	}
	public static void main(String[] args) {
		integertriangle sol = new integertriangle();
		int[][] triangle= {{7}, 
				{3, 8}, 
				{8, 1, 0}, 
				{2, 7, 4, 4}, 
				{4, 5, 2, 6, 5}};
		sol.solution(triangle);
	}

}
