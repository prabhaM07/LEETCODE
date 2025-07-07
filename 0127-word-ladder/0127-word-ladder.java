class Solution {
    class Pair{
        String s;
        int in;
        Pair(String s,int in){
            this.s = s;
            this.in = in;
        }
        
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        int n = wordList.size();

        if(!wordList.contains(endWord)) return 0;

        HashMap<String,Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            hm.put(wordList.get(i),i);
        }

        boolean[] v = new boolean[n];

        Queue<String> q = new LinkedList<>();

        q.add(beginWord);
   
        int level = 0;
        while(q.size()>0){
            int cn = q.size();
            level++;

            for(int k=0;k<cn;k++){
                //remove
                String s = q.poll();
                int in = -1;

                if(hm.containsKey(s)){
                 in = hm.get(s);
                 if(v[in]) continue;
                 v[in] = true;
                 }


                if (s.equals(endWord)) return level;


                //add
                for(int i=0;i<s.length();i++){
                    for(int j =0;j<26;j++){
                        char ch = (char)(97+j);
                        StringBuilder sb = new StringBuilder(s);
                        sb.setCharAt(i,ch);
                        String ss = sb.toString();
                        if(hm.containsKey(ss) && v[hm.get(ss)] != true){
                            q.add(ss);
                        }
                    }
                }
                
            }
            
            
        }
        return 0;
    }
}