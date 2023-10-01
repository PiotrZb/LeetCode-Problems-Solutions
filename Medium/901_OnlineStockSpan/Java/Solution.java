import java.util.Stack;

class StockSpanner {
    private Stack<int[]> stack;

    public StockSpanner() {
        this.stack = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;

        while(!this.stack.isEmpty() && this.stack.peek()[0] <= price) span += this.stack.pop()[1];

        this.stack.add(new int[]{price, span});
        return span;
    }
}