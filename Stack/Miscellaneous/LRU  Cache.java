class LRUCache {


    Node front;
    Node end;
    HashMap<Integer,Node> hm;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        hm = new HashMap<>();
        front = new Node(-1,-1);
        end = new Node(-1,-1);
        front.next=end;
        end.prev=front;
    }
    
    public int get(int key) {
        if(!hm.containsKey(key)){
            return -1;
        }

        Node temp = hm.get(key);

        remove(temp);
        insert(temp);
        return temp.value;
    }
    
    public void put(int key, int value) {
        
        if(hm.containsKey(key)){
            remove(hm.get(key));
        }
        Node temp = new Node(key,value);

        if(hm.size()>=capacity){
            remove(end.prev);
        }
        insert(temp);
    }

    public void remove(Node node){
        hm.remove(node.key);

        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    public void insert(Node node){
        hm.put(node.key,node);

        node.next = front.next;
        node.next.prev = node;

        node.prev=front;
        node.prev.next = node;

    }

    class Node{

        int value;
        int key;
        Node next;
        Node prev;

        Node(int key,int value){
            this.value=value;
            this.key=key;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
