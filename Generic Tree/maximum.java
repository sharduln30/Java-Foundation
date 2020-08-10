import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
class Node{
    int data;
    ArrayList<Node> children = new ArrayList<>();
}

public class maximum {

    public static int  maxf(Node node){
    
        int max=node.data;
        for(Node i:node.children){
            max=Math.max(maxf(i),max);
        }
        
        return max;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        Node root=null;
        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==-1){
                st.pop();
            }else{
                Node temp = new Node();
                temp.data = arr[i];
                if(st.size()==0){
                    root=temp;
                }else{
                    st.peek().children.add(temp);
                }
                st.push(temp);
            }
        }
        System.out.println(maxf(root));
    }
}