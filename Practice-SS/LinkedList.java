//import java.util.LinkedList;
class LinkedList{

    static Node head=null;
    static Node tail=null;
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            next=null;
        }
        Node(){
         
        }
    }
    //=================add=====================

    static void addLast(int n){
        Node node=new Node(n);
        if(head==null){
            head=node;
            tail=node;

        }
        else{
            tail.next=node;
            tail=node;
        }
    }

    static void addFirst(int n){
        Node node=new Node(n);
        if(head==null){
            head=node;
            tail=node;
        }else{
            node.next=head;
            head=node;
        }
    }

    static void addAt(int idx,int val){
        Node node=new Node(val);
        Node slow=null;
        Node fast=head;
        if(idx==0){
        node.next=head;
        head=node;
        return;
    }
    while(idx--!=0){
        slow=fast;
        fast=fast.next;
    }   
    slow.next=node;
    node.next=fast;
}

//===================add======================

//=================delete=====================

    static void delLast(){
        if(head==null)
            {return;}
    
       Node temp;
       temp=head;
       while(temp.next!=tail){
           temp=temp.next;
       }
       tail=temp;
       temp.next=null;

        
    }
    static void delFirst(){
        if(head==null)
            return;
        Node temp=head;
        head=head.next;
        temp.next=null;

    }
    static void delAt(int idx){
        if(head==null)
            return;
        
        if(idx==0){
            Node temp=head;
            head=head.next;
            temp.next=null;
            return;
        }

        Node slow=null;
        Node fast=head;
        while(idx-->0){
          slow=fast;
          fast=fast.next;
        }

        slow.next=fast.next;
        fast.next=null;

    }

//=================delete=====================
  
//===================get=======================

    static int getFirst(){
        if(head==null)
            return 0;
        return head.data;
    }
    static int getLast(){
        if(head==null)
            return 0;
        return tail.data;
    }


    static int getAt(int idx){
        if(head==null)
            return 0;
        Node temp=head;
        while(idx--!=0){
            temp=temp.next;
        }
        return temp.data;
    }

//===================get=======================

    static void display(){
        Node temp=head;

        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }

    static int size(){
        Node temp=head;
        int c=0;
        if(head==null){
            return 0;
        }
        while(temp!=null){
            temp=temp.next;
            c++;
        }
        return c;
    }
    static int getMid(){
        // Node temp=head;
        // if(head==null){
        //     return 0;
        // }
        // int c=0;
        // int s=size();
        // while(c<s/2){
        //     temp=temp.next;
        //     c++;
        // }
        // return temp.data;

        Node slow=head;
        Node fast=head;

        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        return slow.data;
    }
    static int klast(int k){
        
        if(k<=size()){
        if(head==null)
            return 0;
        Node temp1=head;
        Node temp2=head;
        
        while(k--!=0){
            temp2=temp2.next;
        }
        while(temp2.next!=null){
            temp1=temp1.next;
            temp2=temp2.next;
        }
        return temp1.next.data;
        }
        else return 0;
    }

    static Node getNode(int idx){
        Node temp=head;
        while(idx--!=0){
            temp=temp.next;
        }
        return temp;
    }

    static void dataRevIteratively(){
        int r=size()-1;
        int l=0;

        while(l<r){
          Node ln=getNode(l);
          Node rn=getNode(r);
          int temp=ln.data;
          ln.data=rn.data;
          rn.data=temp;
          l++;
          r--;
        }

    }
    static void RevPointerI(){
        if(head==null)
            return;
        Node first=null;
        Node last=head;
     

        while(last!=null){
            Node temp=last.next;
            last.next=first;
            first=last;
            last=temp;
        
        }

        Node temp=head;
        head=tail;
        tail=temp;
    }
// =================================
  static Node left1=null;
  static void update(){
      left1=head;
  }
    static void datarevRecur(Node right,int floor){
     if(right==null){
         return;
     }
    
      datarevRecur(right.next,floor+1); 

      if(floor>size()/2){
          int val=right.data;
        //   System.out.println(val);
          right.data=left1.data;
          left1.data=val;
        left1=left1.next;
      }
    }

    static void pointerrevRecur(Node right,int floor){
     if(right==null){
        
         return;
     }
    
      datarevRecur(right.next,floor+1); 

      if(floor>size()/2){
          int val=right.data;
        //   System.out.println(val);
          right.data=left1.data;
          left1.data=val;
        left1=left1.next;
      }
    }

    static void solve(){
        // dataRevIteratively();
        // RevPointerI();
        update();
        datarevRecur(head,0);
        pointerrevRecur(head,0);
    }
    
    public static void main(String[] args){
            //=====================
            //   LinkedList<Integer> ls=new LinkedList<>();
            //   ls.add(10);
            //   ls.remove();
            //=====================    


        addLast(10);
        addLast(20);
        
        addLast(30);
        addLast(40);
        addLast(50);
        // addLast(60);
        // addFirst(70);
        // addAt(0,100);
    
        //display();
        // // delLast();
        // // delFirst();
        // // delAt(3);
        // // int n=getFirst();
        // // int n=getLast();
        // // int n=getAt(1);
        // System.out.print("\n"+n);
        display();
    //    int size=size();
    // System.out.print("\n"+size);
    // System.out.print(getMid());
    //  System.out.print("\n"+klast(0));
    // Node n=getNode(2);
    //  System.out.println();
    //  solve();
    // display();
    // System.out.println();
     // System.out.print("\n"+n.data);
    }
}