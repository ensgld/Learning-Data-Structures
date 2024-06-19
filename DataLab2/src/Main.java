import org.w3c.dom.ls.LSOutput;

class Node {
    public String data;
    public Node next;

    public Node(String nodeData) {
        this.data = nodeData;
        this.next = null;
    }

    class LinkList {
        public Node head; //First item of LinkList

        public LinkList() {
            this.head = null;
        }

      void printLinkList(){
            Node current = head;
            if (current == null) {
                System.out.println("The List is Empty!");
                return;
            }
            while (current != null) {
                System.out.println(current.data + "->");
                current = current.next;
            }
            System.out.println("");
        }


        void inserToHead(String nodeData) {
            Node newNode = new Node(nodeData);
            newNode.next = head;
            head = newNode;

        }


        void insertToSpecificPosition(String nodeData, int position) {
            if (head == null) {
                inserToHead(nodeData);
            } else {
                Node newNode = new Node(nodeData);
                Node temp = new Node(head.data);
                temp = head;
                for (int i = 0; i < position - 1; i++) {
                    temp = temp.next;
                }
                temp.next = newNode;
                newNode.next = head.next;

            }
        }

        public Node delete(String key) {
            if (head != null) {
                Node deletedNode = new Node(head.data);
                Node temp = new Node(head.data);
                Node previous = new Node(head.data);
                temp = head;
                previous = head;
                if (head.data == deletedNode.data) {
                    head = head.next;
                    return deletedNode;
                }

                while (!temp.data.equals(key)) {
                    temp = temp.next;
                    if (!temp.data.equals(key)) {
                        previous = previous.next;
                    }
                    if (head == temp) {
                        head = head.next;
                        return head;
                    } else {
                        previous.next = temp.next;
                        return temp;
                    }


                }
            }

            return null;
        }

        void sortedInsert(String nodeData) {
            Node newNode = new Node(nodeData);
            Node temp = new Node(head.data);
            temp = head;
            if (head == null) {
                head = newNode;
            } else if (head.data.compareTo(nodeData) > 0) {
                newNode.next = head;
                head = newNode;
            } else {
                while (temp.next != null && temp.next.data.compareTo(nodeData) < 0) {
                    temp = temp.next;
                }
                newNode.next = temp.next;
                temp.next = newNode;
                
            }


        }
    }
}


public class Main {
    public static void main(String[] args) {

    }
}