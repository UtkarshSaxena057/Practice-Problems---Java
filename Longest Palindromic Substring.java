class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean [][] dp = new boolean[n][n];
        String ans = "";
        
        for(int i = 0; i < n; i++) {
            dp[i][i] = true;
            ans = s.substring(i, i + 1);
        }
        
        for(int i = 0; i < n -1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i+1] = true;
                ans = s.substring(i, i + 2);
            }
        }
        
        for(int size = 3; size <= n; size++) {
            for(int i = 0; i < n - size + 1; i++) {
                int start = i;
                int end = i + size - 1;
                dp[start][end] = s.charAt(start) == s.charAt(end)
                    && dp[start + 1][end - 1] == true;
                if (dp[start][end] == true) {
                    ans = s.substring(i, end + 1);
                }
            }
        }
        
        return ans;
    }
}
