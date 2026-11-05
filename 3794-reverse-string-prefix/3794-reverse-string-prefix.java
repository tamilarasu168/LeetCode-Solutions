class Solution {
    public String reversePrefix(String s, int k) {
        char []ch=s.toCharArray();
        int left=0;
        int right=k-1;
        while(left<=right){
            char temp=ch[left];
            ch[left]=ch[right];
            ch[right]=temp;
            left++;
            right--;
        }
        return new String(ch);
    }
}