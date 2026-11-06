class Solution {
    public static boolean isPalindrome(int x) {
        int r,s=0,c=x;
        while(x>0){
            r=x%10;
            s=(s*10)+r;
            x = x/10;
        }
        if(c==s) return true; 
        else return false;
    }
    public static boolean isPrime(int num){
        boolean isPrime = true;
        if (num < 2) isPrime = false;
        else for (int i = 2; i <= Math.sqrt(num); i++) 
               if (num % i == 0) {
                    isPrime = false;
                    break;
                }
        if (isPrime) return true;
        else return false;
    }
    public int primePalindrome(int n) {
        if(isPrime(n) && isPalindrome(n)) return n;
        else{
            while(true){
                if(isPrime(n) && isPalindrome(n)) return n;
                n++;
                if (10_000_000 < n && n < 100_000_000) n = 100_000_000;
            }
        }
    }
}