class Solution {
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        int n = wordList.size();
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put(beginWord,0);
        for(int i=0;i<n;i++){
            hm.put(wordList.get(i),i+1);
        }
        
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        boolean[] v= new boolean[n+1];
        int level = 0;

        while(q.size()>0){
            level++;
            int kk = q.size();
            
            for(int k=0;k<kk;k++){

                String s = q.poll();

                if(v[hm.get(s)]) continue;
                v[hm.get(s)] = true;

                if(s.equals(endWord)){
                    return level;
                } 

                for(int i=0;i<s.length();i++){
                    for(int j=0;j<26;j++){
                        char ch = (char)('a'+j);
                        StringBuilder sb = new StringBuilder(s);
                        sb.setCharAt(i,ch);
                        String ss = sb.toString();
                        if(hm.containsKey(ss) && !v[hm.get(ss)]){
                            q.add(ss);
                        }
                    }
                }
            }
        }
       
        return 0;
    }
}