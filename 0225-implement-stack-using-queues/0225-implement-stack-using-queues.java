class MyStack {

    Queue<Integer> q1 = new ArrayDeque<>();  
    Queue<Integer> q2 = new ArrayDeque<>();
    Queue<Integer> q;
    public MyStack() {
        
    }
    
    public void push(int x) {
        q2.add(x);
        while(q1.size()>0){
            q2.add(q1.poll());
        }
        q=q1;
        q1=q2;
        q2=q;
    }
    
    public int pop() {
        return q1.poll();
    }
    
    public int top() {
        int val = q1.peek();
        return val;
    }
    
    public boolean empty() {
        return q1.size()==0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */