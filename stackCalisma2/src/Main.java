class Node {
    Node next;
    int data;

    Node(int data) {
        this.data = data;

    }


    class stackWithLinkedList {
        public Node head;

        public stackWithLinkedList() {
            this.head = null;
        }

        int pop(int a) {
            Node deleteNode= new Node(a);
            Node current= head;
            while(current.next==null){

            }

        }

        void push(int a) {
            Node newNode = new Node(a);
            newNode.next = head;
            head = newNode;


        }
    }
}

public class Main {
    public static void main(String[] args) {
        Node n = new Node();

    }
}