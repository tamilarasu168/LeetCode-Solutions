class Solution {
    public String countAndSay(int n) {
        if (n == 1)
            return "1";

        String prev = "1";

        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            char c = prev.charAt(0);

            for (int j = 1; j < prev.length(); j++) {
                if (prev.charAt(j) == c) {
                    count++;
                } else {
                    sb.append(count).append(c);
                    c = prev.charAt(j);
                    count = 1;
                }
            }

            sb.append(count).append(c); // append last group
            prev = sb.toString();
        }

        return prev;
    }
}