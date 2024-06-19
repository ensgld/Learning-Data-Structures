class Link {

    public char dData;
    public Link next;

    public Link(char dd) {
        dData = dd;
    }

    public void displayLink() // display ourself
    {
        System.out.print(dData + " ");
    }
}

////////////////////////////////////////////////////////////////
class MyStack {

    private Link head;

    public MyStack() {
        head = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void push(char dd) {
        Link newLink = new Link(dd);
        newLink.next = head;
        head = newLink;
    }

    public char peek() {
        return head.dData;
    }

    public char pop() {
        Link temp = head;
        head = head.next;
        return temp.dData;
    }

}
////////////////////////////////////////////////////////////////

public class Main {

    public static void checkValidity(String command) {
        MyStack myStack = new MyStack();

        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == '(' || command.charAt(i) == '[' || command.charAt(i) == '{') {
                myStack.push(command.charAt(i));
            }
            else if (command.charAt(i) == ')') {
                if (myStack.isEmpty()) {
                    System.out.println("( is missing!");
                    return;
                } else if (myStack.peek() == '(') {
                    myStack.pop();
                }
                else{
                    System.out.println("Paranthesis are not matching");
                    return;
                }
            }
            else if (command.charAt(i) == ']') {
                if (myStack.isEmpty()) {
                    System.out.println("[ is missing!");
                    return;
                } else if (myStack.peek() == '[') {
                    myStack.pop();
                }
                else{
                    System.out.println("Paranthesis are not matching");
                    return;
                }
            }
            else if (command.charAt(i) == '}') {
                if (myStack.isEmpty()) {
                    System.out.println("{ is missing!");
                    return;
                } else if (myStack.peek() == '{') {
                    myStack.pop();
                }
                else{
                    System.out.println("Paranthesis are not matching");
                    return;
                }
            }
        }

        if (myStack.isEmpty()) {
            System.out.println("ACCEPTED");
        } else {
            if (myStack.peek() == '(') {
                System.out.println(") is missing!");
            }
            else if (myStack.peek() == '[') {
                System.out.println("] is missing!");
            }
            else if (myStack.peek() == '{') {
                System.out.println("} is missing!");
            }
        }

    }

    public static void main(String[] args) {

        String com1 = "System.out.println((3+5) + 2);";
        String com2 = "int x = (3+5) * 2);";
        String com3 = "calculateSum(((a+2) * 2), (3*b);";

        String com4 = "int res = (arr[0]+arr[1]) * arr[2];";
        String com5 = "int res = (arr[0]+arr[1)] * arr[2];";
        String com6 = "int res = (arr[0]+arr[1]) * arr[2]];";

        String com7 = "public static void main(String[] args) {"
                + "int res = (arr[0]+arr[1]) * arr[2];"
                + "}}";
        String com8 = "public static void main(String[] args) {"
                + "int[] arr = {1,2,3,4};";
        String com9 = "public static void main(String[] args) {"
                + "int[] arr = {1,2,3,4};"
                + "}";
        String com10 = "{{}[(){()()[]}],([],[{}])}";


        System.out.println("----------------------------------------------");
        System.out.println("Only () CHECK -> 1 POINT");
        System.out.println("----------------------------------------------");
        System.out.println(com1);
        checkValidity(com1);
        System.out.println("----------------------------------------------");
        System.out.println(com2);
        checkValidity(com2);
        System.out.println("----------------------------------------------");
        System.out.println(com3);
        checkValidity(com3);
        System.out.println("----------------------------------------------");
        System.out.println("(),[] CHECK -> 1 POINT");
        System.out.println("----------------------------------------------");
        System.out.println(com4);
        checkValidity(com4);
        System.out.println("----------------------------------------------");
        System.out.println(com5);
        checkValidity(com5);
        System.out.println("----------------------------------------------");
        System.out.println(com6);
        checkValidity(com6);
        System.out.println("----------------------------------------------");
        System.out.println("(),[],{} CHECK -> 1 POINT");
        System.out.println("----------------------------------------------");
        System.out.println(com7);
        checkValidity(com7);
        System.out.println("----------------------------------------------");
        System.out.println(com8);
        checkValidity(com8);
        System.out.println("----------------------------------------------");
        System.out.println(com9);
        checkValidity(com9);
        System.out.println("----------------------------------------------");
        System.out.println(com10);
        checkValidity(com10);
        System.out.println("----------------------------------------------");



    }  // end main()
}  // end class LinkStackApp
////////////////////////////////////////////////////////////////
