package Practice;
class LL{
    static Node head=null;
    static Node tail=null;
     static class Node{
         int data;
         Node next;
         Node(int data){
             this.data=data;
         }
     }
     static void add(int data){
         Node node=new Node(data);
         if(head==null){
             head=node;
             tail=node;
         }
         else{
             tail.next=node;
             tail=tail.next;
         }
     }
     static void addfirst(int data){
         Node node=new Node(data);
         if(head==null){
             head=node;
             tail=node;
         }
         else{
             node.next=head;
             head=node;
         }
     }
     static void addAt(int index,int data){
         Node node = new Node(data);
         Node temp=head;
         if(head==null){
             head=node;
             tail=node;
         } 
         else{
             if(index==0){
                 node.next=head;
                 head=node;
             }
             else{
    
             while(--index!=0){
                 temp=temp.next;
             }
            node.next=temp.next;
            temp.next=node;
         }
     }
     }
     static void display(){
         Node temp=head;
         while(temp!=null){
             System.out.print(temp.data+"->");
             temp=temp.next;
         }
     }

    public static void main(String[] args){
        add(20);
        display();
        System.out.println();
        add(30);
        display();
        System.out.println();
        add(40);
        display();
        System.out.println();
        addfirst(1);
        display();
        System.out.println();
        addfirst(2);
        display();
        System.out.println();
        addfirst(3);
        display();
        System.out.println();
        addAt(4,60); 
        display();
        System.out.println();
    }
}