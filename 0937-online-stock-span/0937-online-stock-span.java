class StockSpanner {

    ArrayList<Integer> arr; 
    Stack<Integer> st;
    int c=0;
    public StockSpanner() {
        this.arr = new ArrayList<>();
        this.st = new Stack<>();
    }
    
    public int next(int price) {
        arr.add(price);
       
        while(!st.isEmpty() && arr.get(st.peek())<=price){
            st.pop();
        }
        
        if(st.isEmpty()){
            st.push(c);
            c++;
            return c;
        }
        else{
            int val = st.peek();
            st.push(c);
            c++;
            return (c-val)-1;
        }
        
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */