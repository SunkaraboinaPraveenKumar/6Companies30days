package Atlassian_week5;
import java.util.*;
class LRUCache {
    class Node{
        int key,value;
        Node next, prev;
        public Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    private HashMap<Integer,Node> map;
    private int capacity;
    private Node head,tail;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        map=new HashMap<>();
        head=new Node(0,0);
        tail=new Node(0,0);
        head.next=tail;
        tail.prev=head;
    }
    public void insert(Node node){
        node.next=head.next;
        node.prev=head;
        head.next.prev=node;
        head.next=node;
    }
    public void remove(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    public int get(int key) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            node.value=value;
            remove(node);
            insert(node);
        }
        else{
           if(map.size()==capacity) {
                Node lru=tail.prev;
                map.remove(lru.key);
                remove(lru);
           }
            Node newNode=new Node(key,value);
            map.put(key,newNode);
            insert(newNode);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
