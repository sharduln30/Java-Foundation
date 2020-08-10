import java.util.*;

class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
}

public class PredessorAndSuccessor {

    public static Node construct(int[] arr) {
        Node root = null;

        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];

                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }

                st.push(t);
            }
        }

        return root;
    }

    public static void display(Node node) {
        int d = node.data;
        System.out.print(d + " -> ");
        for (Node i : node.children) {
            System.out.print(i.data + ", ");
        }
        System.out.println(".");
        for (Node i : node.children) {
            display(i);
        }
    }

    static Node successor;
    static Node predessor;
    static int state;

    public static void PreNSucc(Node node, int ele) {
        if (state == 0) {
            if (node.data == ele) {
                state = 1;
            } else {
                predessor = node;
            }
        } else if (state == 1) {
            state = 2;
            successor = node;
        }

        for (Node child : node.children) {
            PreNSucc(child, ele);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = sc.nextInt();
        }
        int ele = sc.nextInt();
        Node root1 = construct(arr1);

        predessor = null;
        successor = null;
        PreNSucc(root1, ele);
        if (predessor == null) {
            System.out.println("Predecessor = Not found");
        } else {
            System.out.println("Predecessor = " + predessor.data);
        }

        if (successor == null) {
            System.out.println("Successor = Not found");
        } else {
            System.out.println("Successor = " + successor.data);
        }
    }
}
