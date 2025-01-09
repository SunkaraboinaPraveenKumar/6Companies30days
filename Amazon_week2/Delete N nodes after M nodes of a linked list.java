class Node {
    int val;
    Node next;
    Node() {}
    Node(int val) { this.val = val; }
}
class Solution {
    static void linkdelete(Node head, int n, int m) {
        // your code here
        Node temp=head;
        while(temp!=null){
            int tempM=m;
            int tempN=n;
            Node prev=null;
            while(tempM>0&&temp!=null){
                prev=temp;
                temp=temp.next;
                tempM--;
            }
            while(tempN>0&&temp!=null){
                temp=temp.next;
                tempN--;
            }
            prev.next=temp;
        }
        if(m==0){
            while(n>0){
                head=head.next;
                n--;
            }
        }
    }
}
