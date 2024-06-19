class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;

    }

}

class BinaryTree {
    Node root;

    public void insert(int data) {
        insertRec(root, data);

    }
// root.left=insertRec(root.left,data)
// root.right=insertRec(root.right,data)

    public Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
        } else if (data < root.data) {
            root.left = insertRec(root.left, data); /*
            buradaki recursion mantığını şu şekilde açıklayabiliriz.Mantıken
            bizim ağacımızda mesela sağda iki tane kol varsa solda 3 tane kol varsa ve
            biz yeni bir node eklemek istiyorsak.
            Eklemek istediğimiz node geldi root boş değil dedi küçük dedi ve buraya girdi ama
            direkt ekleme yapmaması gerekiyor sonraki ile de karşılaştırma yapıp devam etmesi gerekiyor
            Bu yüzden recursion yapıyoruz.*/
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    public void inOrder() {
        /*
        inorder yazıma göre küçükten büyüğe gideriz yani left hand side ile ilgilenicez
          */
        inOrderRec(root);

    }

    public void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.data + " ");
            inOrderRec(root.right);

        }
    }


}

public class Main {
    public static void main(String[] args) {
       BinaryTree bst= new BinaryTree();
       bst.insert(15);
        bst.insert(14);
        bst.insert(13);
        bst.insert(12);
        bst.insert(11);
        bst.insert(10);
        bst.insert(19);
        bst.inOrder();

    }
}