class Solution {
    public int tribonacci(int n) {
        switch (n) {
            case 0:
                return 0;
            case 1:
                return 1;
            default:
                int t0 = 0, t1 = 1, t2 = 1, t = 1;
                for (int i = 3; i <= n; i++) {
                    t = t0 + t1 + t2;
                    t0 = t1;
                    t1 = t2;
                    t2 = t;
                }
                return t;
        }
    }
}