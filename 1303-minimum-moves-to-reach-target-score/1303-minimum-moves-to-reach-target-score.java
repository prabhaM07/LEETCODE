class Solution {
    public int minMoves(int target, int maxDoubles) {
        int ans = 0;
        while (target > 1) {
            if (target % 2 == 0 && maxDoubles > 0) {
                target /= 2;
                maxDoubles--;
                ans++;
            } else if (maxDoubles == 0) {
                ans += target - 1;
                break;
            } else {
                target--;
                ans++;
            }
        }
        return ans;
    }
}

