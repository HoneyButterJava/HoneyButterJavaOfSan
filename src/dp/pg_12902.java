package dp;


public class pg_12902 {

	public int solution(int n) {

		int MOD = 1000000007;

		if (n % 2 != 0) {
			return 0; //n이 홀수인 경우는 만들 수 없음
		}

		long[] dp = new long[5001];
		dp[0] = 1; // dp[0]=1로 초기화해줘야 안쪽 for문을 돌면서 마지막에 dp[0] * 2로 매번 추가되는 케이스가 더해진다.
		// dp[0] 은  dp[4]에서 중간에 생기는 케이스를 의미한다고 생각하면 됨
		dp[2] = 3;

		for (int i = 4; i <= n; i += 2) {
			dp[i] = dp[i - 2] * 3;
			for (int j = i - 4; j >= 0; j -= 2) {
				dp[i] += dp[j] * 2;
			}
			dp[i] %= MOD; // 문제에서 요구함.
		}
		return (int) dp[n];
	}
}
