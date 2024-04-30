package leetcode;

//문제링크: https://leetcode.com/problems/implement-stack-using-queues/

class MyStack {

    ArrayList<Integer> que = new ArrayList<Integer>();
    int top = 0;

    public MyStack() {
        
    }
    
    public void push(int x) {
        que.add(x);
        this.top = x;
    }
    
    public int pop() {
        
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        for (int i = 0; i < this.que.size() - 1; i++) {
            this.top = this.que.get(i);
            tmp.add(this.que.get(i));
        }
        
        int last = this.que.get(this.que.size() - 1);
        this.que = tmp;
        
        return last;
    }
    
    public int top() {
        return this.top;
    }
    
    public boolean empty() {
        return que.isEmpty();
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