import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
class Node{
    int data;
    ArrayList<Node> children = new ArrayList<>();
}

public class height {

    public static int  heightFun(Node node){
    
        int h=-1;
        for(Node i:node.children){
            h=math.max(heightFun(i)),h;
        }

        
        return h+1;
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
        System.out.println(heightFun(root));
    }
}