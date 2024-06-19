
class Node {

    public String data;
    public Node next;

    public Node(String nodeData) {
        this.data = nodeData;
        this.next = null;
    }
}

class LinkList {

    public Node head; // First item of LinkList

    public LinkList() {
        this.head = null;
    }

    void printLinkList() {
        Node current = head;
        if (current == null) {
            System.out.println("The list is empty!");
            return;
        }
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("");
    }

    void insertToHead(String nodeData) {
        Node newNode = new Node(nodeData);

        newNode.next = head;
        head = newNode;
    }

    // Complete the insertToSpecificPosition function below.
    // Indexes are starting from 0.
    // A->B->C->null 
    // Want to add D to position 1   A -> D -> B -> C
    void insertToSpecificPosition(String nodeData, int position) {
        if (position == 0) {
            insertToHead(nodeData);
        } else {
            // if I didn't define a temporary variable to pass through the linklist
            // then the head of linklist will be changed and we will loose some of the items.
            Node cur = head;
            int flag = 1;

            for (int i = 0; i < position - 1; i++) {
                if (cur.next != null) {
                    cur = cur.next;
                } else {
                    System.out.println("Can't add " + nodeData + " to this position!");
                    flag = 0;
                    break;
                }
            }

            // Which means the item can be added to the position
            if (flag == 1) {
                Node newNode = new Node(nodeData);
                newNode.next = cur.next;
                cur.next = newNode;
            }
        }
    }

    public Node delete(String key) // delete link with given key
    {
        Node current = head;              // search for link
        Node previous = head;

        if (head == null) {
            return null;                    // didn't find it
        }
        while (!current.data.equals(key)) {
            if (current.next == null) {
                return null;                 // didn't find it
            } else {
                previous = current;          // go to next link
                current = current.next;
            }
        }                               // found it
        
        if (current == head) // if first link,
        {
            head = head.next;             //    change first
        } else // otherwise,
        {
            previous.next = current.next;   //    bypass it
        }
        return current;
    }

    // Complete the sortedInsert function below which inserts items alphabetically sorted.
    void sortedInsert(String nodeData) {
        Node newNode = new Node(nodeData);
        Node cur = head;

        if (head == null || cur.data.compareTo(nodeData) > 0) {
            insertToHead(nodeData);
        } else {
            while (cur.next != null) {
                if (cur.next.data.compareTo(nodeData) > 0) {
                    newNode.next = cur.next;
                    cur.next = newNode;
                    return;
                }
                cur = cur.next;
            }
            cur.next = newNode;
        }
    }
}

public class Test {

    public static void main(String[] args) {
        LinkList llist = new LinkList();
        
        System.out.println("-------------------------------");
        System.out.println("Sorted Insert Operations");
        System.out.println("-------------------------------");
        llist.printLinkList();
        llist.sortedInsert("D");
        llist.printLinkList();
        llist.sortedInsert("B");
        llist.printLinkList();
        llist.sortedInsert("C");
        llist.printLinkList();
        llist.sortedInsert("A");
        llist.printLinkList();
        llist.sortedInsert("F");
        llist.printLinkList();
        llist.sortedInsert("E");
        llist.printLinkList();
        
        System.out.println("-------------------------------");
        System.out.println("Insert to a Position Operations");
        System.out.println("-------------------------------");
        
        llist.insertToSpecificPosition("Z", 6);
        llist.printLinkList();
        llist.insertToSpecificPosition("T", 3);
        llist.printLinkList();
        llist.insertToSpecificPosition("X", 0);
        llist.printLinkList();
        
        llist.insertToSpecificPosition("G", 10);
        
        System.out.println("-------------------------------");
        System.out.println("Delete Operations");
        System.out.println("-------------------------------");
        
        if(llist.delete("Z") != null)
            llist.printLinkList();
        else{
            System.out.println("Z is not found");
        }
        if(llist.delete("T") != null)
            llist.printLinkList();
        else{
            System.out.println("T is not found");
        }
        if(llist.delete("X") != null)
            llist.printLinkList();
        else{
            System.out.println("X is not found");
        }
        if(llist.delete("L") != null)
            llist.printLinkList();
        else{
            System.out.println("L is not found");
        }
        System.out.println("-------------------------------");
    }
}
