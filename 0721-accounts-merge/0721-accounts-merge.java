class Solution {
    public int findParent(int[] par, int n){
    if(par[n] != n){
        par[n] = findParent(par, par[n]);  // Path compression
    }
    return par[n];
}
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int[] par = new int[accounts.size()];

        for(int i=0;i<accounts.size();i++){
            par[i] = i;
        }

        TreeMap<String,Integer> tm = new TreeMap<>();

        for(int i=0;i<accounts.size();i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String s = accounts.get(i).get(j);
                if(!tm.containsKey(s)){
                    tm.put(s,i);
                }
                else{
                    int val = tm.get(s);
                    int upi = findParent(par,par[i]);
                    int upval = findParent(par,par[val]);
                    par[upi] = upval;
                }
            }
        }

       for(int i=0;i<par.length;i++){
          par[i] = findParent(par,i);
       }
        HashMap<Integer,ArrayList<String>> hm = new HashMap<>();

        for(Map.Entry<String,Integer> entry: tm.entrySet()){
            int index = entry.getValue();
            int up =par[index];
            String mail = entry.getKey();

            if(!hm.containsKey(up)){
                ArrayList<String> temp = new ArrayList<>();
                temp.add(mail);
                hm.put(up,temp);
            }
            else{
                ArrayList<String> temp = hm.get(up);
                temp.add(mail);
            }
        }
        List<List<String>> ans = new ArrayList<>();

        for(Map.Entry<Integer,ArrayList<String>> entry: hm.entrySet()){
            int up = entry.getKey();
            String name = accounts.get(up).get(0);
            List<String> list = entry.getValue();
            list.add(0,name);
            ans.add(list);
        }
        return ans;
    }
}