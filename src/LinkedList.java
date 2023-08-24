public class LinkedList {
    Node head;

    static class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }

}
    void insert(int data) {
        Node node = new Node(data);
        if (head == null){
            head = node;
        }
        else {
            Node temp = head;
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = node;
        }

    }
    void display(){
        if (head == null) System.out.println(head.data);
        else {
            Node node = head;
            while (node.next!=null){
                System.out.println(node.data);
                node = node.next;

            }
            System.out.println(node.data);
        }
    }


    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(4);
        list.display();

    }

}