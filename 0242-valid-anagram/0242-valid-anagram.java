class Solution{
    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";

        if (isAnagram(str1, str2)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        int[] count = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }

        for (int x : count) {
            if (x != 0)
                return false;
        }

        return true;
    }
}