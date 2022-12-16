// Push Operation: 
// Step 1: The idea is to, whenever we have a new object to add in a queue, we will create a new stack, and one-by-one push every items of the original stack in the new stack until the original stack is not empty.
// Step 2: After the original stack is empty, we will add the new object in the original stack.
// Step 3: Now, undo the step 1. Move every item from the new stack to the original stack.

// pop, peek and empty operations are same as the regular operations as in a Stack or as poll, peek and isEmpty in Queue.



class MyQueue {
    Stack<Integer> queue = new Stack<Integer>();
    
    public void push(int x) {
        Stack<Integer> temp = new Stack<Integer>();
        while(!queue.empty()) {
            temp.push(queue.pop());
        }
        queue.push(x);
        while(!temp.empty()) {
            queue.push(temp.pop());
        }
    }
    
    public int pop() {
        return queue.pop();
    }
    
    public int peek() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.empty();
    }
}
