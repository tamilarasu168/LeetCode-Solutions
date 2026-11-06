class Solution {
    public int numberOfSteps(int a) {
        int count=0;
        while(a!=0){
            if(a%2==0){
                a=a/2;
            }
            else{
               a-=1; 
            }
            
            count++;
        }
        return count;
        
    }
}