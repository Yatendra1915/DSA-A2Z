class StockSpanner {

    class Pair{

        int price;
        int count;

        Pair(int price,int count){
            this.price = price;
            this.count=count;
        }
    }

    Stack<Pair> st;

    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        
        int count = 1;
        while(!st.isEmpty() && st.peek().price<=price){
            count+=st.peek().count;
            st.pop();
        }

        st.push(new Pair(price,count));
        return count;
    }
}
