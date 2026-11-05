class Solution {
    public void moveZeroes(int[] nums) {
          int ind=0;
        for(int i:nums){
            if(i!=0){
                nums[ind]=i;
                ind++;
            }
        }
        for(int i=ind;i<nums.length;i++)
        {
            nums[i]=0;
        }
       
    
}
}