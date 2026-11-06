class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer>m1=new HashMap<>();
        for(int x:arr){
            m1.put(x,m1.getOrDefault(x,0)+1);
        }
        Set<Integer>s1=new HashSet<>(m1.values());
        return m1.size()==s1.size();
    }
}