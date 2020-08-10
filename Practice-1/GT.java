import java.util.*;

class GT{
    static class Node{
        int data;
        ArrayList<Node> children= new ArrayList<>();

        Node(int data){
            this.data=data;
        }

        //To avoid null pointer exception
        Node(){

        }
    }

    static Node constructGT(int[] arr){
      
        Stack<Node> st = new Stack<>();
        Node root=null;
        for(int i:arr){
            if(i==-1){
                st.pop();
            }
            else{
                Node node = new Node(i);
                if(root==null){
                    root=node;
                }
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

        System.out.print(root.data+"-->");

        for(Node i:root.children){//print children of children
            
             System.out.print(i.data+", ");

        }
             System.out.println();

        for(Node i:root.children){// call children
            display(i);
        }
    }

    static boolean find(Node root,int n){
        
        if(n==root.data){
            return true;
        }
        
        boolean ans = false;

        for(Node i: root.children){
            ans = find(i,n)||ans;
        }
        return ans;
        
    }
 
    static int max(Node root){
        
        int max=root.data;    
        for(Node i: root.children){
            max=Math.max(max,max(i));
        }
        return max;
    }
    
    
    static int size(Node root){
        int count=1;
        for(Node n: root.children){
            count+=size(n);
        }
        return count;
    }

    public static void main(String[] args){
        int[] arr ={10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
        Node root = constructGT(arr);
        display(root);
        System.out.println(find(root, 50));
        System.out.println(max(root));
        System.out.println(size(root));
        
        
        
    }
}
u