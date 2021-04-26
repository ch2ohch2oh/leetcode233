/**
 * id: 716 max stack
 * tags: stack
 * date: 2021-04-26
 */
class MaxStack {
    Stack<Integer> values = new Stack<>();
    Stack<Integer> maxIdx = new Stack<>();
    
    /** initialize your data structure here. */
    public MaxStack() {
            
    }
    
    public void push(int x) {
        values.push(x);
        if(maxIdx.size() == 0) {
            maxIdx.push(0);
        } else if(x >= values.get(maxIdx.peek())) {
            maxIdx.push(maxIdx.size());
        } else {
            maxIdx.push(maxIdx.peek());
        }
    }
    
    public int pop() {
        maxIdx.pop();
        return values.pop();
        
    }
    
    public int top() {
        return values.peek();
    }
    
    public int peekMax() {
        return values.get(maxIdx.peek());
    }
    
    public int popMax() {
        int idx = maxIdx.peek();
        Stack<Integer> st = new Stack<>();
        while(values.size() > idx) {
            st.push(pop());
        }
        int ret = st.pop();
        while(st.size() > 0) {
            push(st.pop());
        }
        return ret;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */