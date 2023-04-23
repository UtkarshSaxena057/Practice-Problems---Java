class Solution {
    public Map<Long, Long> dp;
    public int integerReplacement(int n) {
        dp = new HashMap<>();
        return (int) f((long) n);

    }

    public long f(long i) {
        if (i <= 1) {
            return 0;
        }
        else if (!dp.containsKey(i)) {
            long ans = 0;
            if (i%2 == 0) {
                ans = 1 + f(i/2);
            }
            else {
                ans = Math.min(1 + f(i - 1), 1 + f(i + 1));
            }
            dp.put(i, ans);
        }
        return dp.get(i);
    }


}
