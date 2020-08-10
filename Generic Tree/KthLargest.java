import java.util.*;

class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
}

public class KthLargest {

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

    static int ceil;
    static int floor;

    public static void ceilNfloor(Node node, int data) {

        if (node.data > floor && node.data < data) {
            floor = node.data;
        }
        if (node.data > data && node.data < ceil) {
            ceil = node.data;

        }

        for (Node child : node.children) {
            ceilNfloor(child, data);
        }
    }

    public static int kLargest(Node node, int k) {
        floor = Integer.MIN_VALUE;
        int factor = Integer.MAX_VALUE;

        for (int i = 0; i < k; i++) {
            ceilNfloor(node, factor);
            factor = floor;
            floor = Integer.MIN_VALUE;
        }
        return factor;        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        Node root = construct(arr);


        int kthLargest = kLargest(root, k);
        System.out.println(kthLargest);

    }
}
