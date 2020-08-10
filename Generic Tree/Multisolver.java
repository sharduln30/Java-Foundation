import java.util.*;

class Node{
    int data;
    ArrayList<Node> children = new ArrayList<>();
}

public class Multisolver {

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
    

    public static void display(Node node){
        int d = node.data;
        System.out.print(d+" -> ");
        for(Node i:node.children){
            System.out.print(i.data+", ");
        }
        System.out.println(".");
        for(Node i:node.children){
            display(i);
        }
    }

    static int size;
    static int max;
    static int min;
    static int height;


    public static void multisolver(Node node, int depth){
		size+=1;
		max = Math.max(max,node.data);
		min = Math.min(min,node.data);
		height = Math.max(height,depth);
		for(Node child:node.children){
			multisolver(child,depth+1);
		}
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = sc.nextInt();
		}        
        Node root1=construct(arr1);
		
		size = 0;
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		height = 0;
		multisolver(root1, 0);
		System.out.println("Size: "+size);
		System.out.println("Max: "+max);
		System.out.println("Min: "+min);
		System.out.println("Height: "+height);

    
    }
}
