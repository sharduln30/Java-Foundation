import java.util.*;
import java.util.LinkedList;
class GenericTree{

    static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    static Node construct(int[] arr){
        Node root=null;
        Stack<Node> st=new Stack<>();
        for(int i:arr){
            if(i==-1){
                st.pop();
            }
            else{
                Node node=new Node();
                node.data=i;
                if(root==null){
                    root=node;
                }
                else{
                    Node temp=st.peek();//gives top of the stack.
                    temp.children.add(node);
                }
                st.push(node);  
          }
        }
        return root;
    }
    static void display(Node root){
        System.out.print(root.data+"->");
        if(root.children.size()==0)

            System.out.print("*");
        else{
            for(Node i:root.children){
                System.out.print(i.data+",");
            }
        }
        System.out.println();
        for(Node i:root.children){
            display(i);
        }
    }



    static void preorder(Node root){
        System.out.print(root.data+" ");
        for(Node i:root.children){
            preorder(i);
        }
    }

    static void postorder(Node root){
        for(Node i:root.children){
            postorder(i);
        }
        System.out.print(root.data+" ");
    }

    static int max(Node root){
        int max=root.data;

        for(Node i:root.children)
            max=Math.max(max,max(i));

        return max;
    }
    static int min(Node root){
        int min=root.data;

        for(Node i:root.children)
            min=Math.min(min,min(i));

        return min;

    }
    static int size(Node root){
        int size=1;
        for(Node i:root.children)
            {
                size+=size(i);
            }
        return size;
    }
    
    static boolean find(Node root,int data){

    if(data==root.data) return true;   
       boolean flag=false;

        for(Node i:root.children){
            flag=find(i,root.data)||flag;
            
            }
            return flag;
        
    }
    
    static int height(Node root){

        int hmax=0;//heightThroughvertices
     //   int hmax=-1;//heightThroughedges
        
       for(Node i:root.children){
           hmax=Math.max(hmax,height(i));
       }
    return hmax+1;
    }
    static int ceil=Integer.MAX_VALUE;

    static void ceilFind(Node root,int data){
        
        for(Node i:root.children){
            ceilFind(i,data);
        }
        int d=root.data;
        if(ceil>=d && d>=data){
            ceil=d;
        }
    }
    static int floor=Integer.MIN_VALUE;

    static void floorFind(Node root,int data){
        
        for(Node i:root.children){
            floorFind(i,data);
        }
        int d=root.data;
        if(floor<=d && d<=data){
            floor=d;
        }
    }

    static int flag=0;
    static int pre=0;
    static int succ=0;
    static void successor_predecessor(Node root, int data){
        if(data==root.data){
            flag++;
        }
        else if(flag==0){
            pre=root.data;
        }
        else if(flag==1){
            succ=root.data;
            flag++;
        }
        if(flag==2){
            return;
        }
        for(Node i:root.children){
            successor_predecessor(i,data);
        }
    }

    static void levelOrderPrint(Node root){

       
        
        // LinkedList<Node> q = new LinkedList<>();3
        Queue<Node>  q=new LinkedList<>();
        q.add(root);

        while(q.size()>0){
            Node rn=q.remove();
            System.out.print(rn.data+" " );
            for(Node ch:rn.children){
                q.add(ch);
            }
        }
    }
    // class HeapMover{

    //     int max = Integer.MIN_VALUE;
    //     int min = Integer.MAX_VALUE;

    // }

    
    static void revLevelOrderPrint(Node root){
        
        // LinkedList<Node> q = new LinkedList<>();3
        Queue<Node>  q=new LinkedList<>();
        q.add(root);

        while(q.size()>0){
            Node rn=q.remove();
            System.out.print(rn.data+" " );
            for(int i=rn.children.size()-1;i>=0;i--){
                q.add(rn.children.get(i));
            }
        }
    }
    static int l = 0;
    static void zigzaglevelOrderPrint(Node root){
        
           Stack<Node> st1 = new Stack<>();
           Stack<Node> st2 = new Stack<>();
           st1.push(root);
           while(st1.size()>0 || st2.size()>0){
               while(st1.size()>0){
                   Node n= st1.pop();
                   System.out.print(n.data+", ");
                   for(int i=n.children.size()-1;i>=0;i--){
                       st2.push(n.children.get(i));
                   }
               }
               while(st2.size()>0){
                   Node n = st2.pop();
                   System.out.print(n.data+",");
                   for(Node i:n.children){
                       st1.push(i);
                   }
               }
           }

    }
    public static void main(String[] args){
        int[] arr={10,20,50,-1,60,-1,-1,30,70,-1,80,110,130,-1,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};

        Node root=construct(arr);
        //display(root);
        // preorder(root);
        // System.out.println();
        // postorder(root);
        // System.out.println();
        // int max=max(root);
        // System.out.println(max);
        // int min=min(root);
        // System.out.println(min);
        // int size=size(root);
        // System.out.println(size);
        // boolean find=find(root,10);
        // System.out.println(find);
        // int height=height(root);
        // System.out.println(height);  
        // ceilFind(root,66);
        // System.out.println(ceil);  
        // floorFind(root,66);
        // System.out.println(floor);  
        // successor_predecessor(root,20);
        // System.out.println(pre);
        // System.out.println(succ);
        //HeapMover hp = new HeapMover();
        levelOrderPrint(root);
        System.out.println();
        revLevelOrderPrint(root);
        System.out.println();
        zigzaglevelOrderPrint(root);
        System.out.println();   
       }
}


