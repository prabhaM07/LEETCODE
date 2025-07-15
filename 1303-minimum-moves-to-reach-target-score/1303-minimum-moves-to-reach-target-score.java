class Solution {
    public int minMoves(int target, int maxDoubles) {
        if(maxDoubles == 0 || target == 1) return target-1;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);

        int ans = 0;
        if(target%2 ==0 && maxDoubles>0){
            pq.add((int)(target/2));
            maxDoubles--;
        }
        else
            pq.add(target-1);
        
        while(pq.size()>0){
            System.out.println(pq);
            //remove
            int k = pq.poll();

            //work
            ans+=1;
            if(k<=1) break;
            if(maxDoubles == 0){
                ans+=(k-1);
                break;
            }
           
            //add
            if(k % 2 ==0 && maxDoubles>0){
                pq.add((int)(k/2));
                maxDoubles--;
            }
            else
                pq.add(k-1);
        }
        return ans;
    }
}