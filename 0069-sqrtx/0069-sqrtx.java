 class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        
        long left = 1, right = x, ans = 0;
        
        while (left <= right) {
            long mid = left + (right - left) / 2;
            
            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid < x) {
                ans = mid;          // Store candidate
                left = mid + 1;     // Try larger values
            } else {
                right = mid - 1;    // Try smaller values
            }
        }
        
        return (int) ans;
    }
}