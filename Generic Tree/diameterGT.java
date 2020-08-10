import java.util.*;

class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
}

public class diameterGT {

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

    static int dia;

    static int findDiameter(Node node) {
        int fheight = -1;
        int sheight = -1;
        for (Node child : node.children) {
            int cDepth = findDiameter(child);
            if (cDepth > fheight) {
                sheight = fheight;
                fheight = cDepth;
            } else if (cDepth > sheight) {
                sheight = cDepth;
            }
        }
        if (fheight + sheight + 2 > dia) {
            dia = fheight + sheight + 2;
        }
        fheight += 1;
        return fheight;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        Node root = construct(arr);

        dia = 0;
        findDiameter(root);
        System.out.println(dia);

    }
}
