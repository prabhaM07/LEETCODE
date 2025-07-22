class Solution {
    int findParent(int[] par,int n){
        if(par[n] == n) return n;
        return findParent(par,par[n]);
    }

    public int removeStones(int[][] stones) {
        int maxr = Integer.MIN_VALUE;
        int maxc = Integer.MIN_VALUE;

        for(int i=0;i<stones.length;i++){
                maxr = Math.max(maxr,stones[i][0]);
                maxc = Math.max(maxc,stones[i][1]);
        }

        int k = (maxr+1)+(maxc+1);
        int[] par = new int[k];
        Boolean[] check = new Boolean[k];
        Arrays.fill(check,false);

        for(int i=0;i<k;i++){
            par[i] = i;
        }
        
        for(int i=0;i<stones.length;i++){
            int r = stones[i][0];
            int c = stones[i][1] + (maxr+1);
            check[r]= true;
            check[c]= true;
            int rp = findParent(par,r);
            int cp = findParent(par,c);
            
            par[cp] = rp;
            
        }
        
       for(int i=0;i<k;i++){
            par[i] = findParent(par,i);
        }
        Set<Integer> s = new HashSet<>();

        for(int i=0;i<k;i++){
            if(check[i]==true)
            {
                s.add(par[i]);
            }
        }
        return stones.length - s.size();
    }
}
