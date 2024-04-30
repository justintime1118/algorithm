package leetcode;

import java.util.ArrayDeque;

//문제링크: https://leetcode.com/problems/implement-queue-using-stacks/

class MyQueue {

    ArrayDeque<Integer> stack = new ArrayDeque<>();
    int top = 0;

    public MyQueue() {

    }

    public void push(int x) {
        if (this.stack.size() == 0)
            this.top = x;
        this.stack.push(x);
    }

    public int pop() {
        ArrayDeque<Integer> tmp = new ArrayDeque<>();

        while (this.stack.size() > 0) {
            tmp.push(this.stack.pop());
        }

        int val = tmp.pop();

        // 스택에 남아있는 값이 있다면 top을 갱신해준다
        // 스택이 비어있으면 갱신이 불가능하므로 이런 경우에는 push에서 처리한다
        if (tmp.size() > 0)
            this.top = tmp.peek();

        while (tmp.size() > 0) {
            this.stack.push(tmp.pop());
        }

        return val;
    }

    public int peek() {
        return this.top;
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */