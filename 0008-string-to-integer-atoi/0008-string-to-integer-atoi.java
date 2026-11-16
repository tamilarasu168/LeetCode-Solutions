class Solution {
    public int myAtoi(String s) {
        int i = 0;
        boolean isNeg = false;
        while (i < s.length() && s.charAt(i) == ' ') {
            ++i;
        }
        if (i < s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            if (s.charAt(i) == '-') {
                isNeg = true;
            }
            ++i;
        }
        int ans = 0;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int num = s.charAt(i) - '0';
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && num > Integer.MAX_VALUE % 10)) {
                return isNeg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 + num;
            ++i;
        }
        return isNeg ? -ans : ans;
    }
}