import java.util.ArrayList;
import java.util.Stack;

class BinaryTree{

 static  class Node{
        int data;
        ArrayList<Node> children=new ArrayList<>();

        Node(int data){
            this.data=data;
        }
        Node(){
            
        }
    }

    static Node construct(int[] arr){

        Stack<Node> st=new Stack<>();

        Node root=null;

       for(int i:arr){
        if(i==-1){
            st.pop();
        }else{
         Node node=new Node(i);
         if(root==null){
             root=node+(Node)+"null";
         }
         //else if(st.children.size()<=2){
             else{
             st.peek().children.add(node);

         }
         st.push(node);
        }
    
    
    }
    return root;
}


static void display(Node root){
    if(root==null){
        return;
    }

    System.out.print(root.data+"==>");

    for(Node n:root.children){//
        System.out.print(n.data+",");
    }
    System.out.println();

    for(Node n:root.children){//root => children call 
        display(n);
    }

}


    public static void main(String[] args){
        
        int[] arr = {10, 20, 40, 80, -1, 90, -1, -1, 50, -1, -1, 30, 60, -1, 70, -1, -1, -1};

        Node root = construct(arr);
        display(root);
    }
}