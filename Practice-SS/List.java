import java.util.*;
class List{
    public static void main(String[] args){
    
    ArrayList<Integer> myList = new ArrayList<>(5);
    for(int i=0;i<myList.size();i++)
    myList.add(3);
    for(int i:myList)
        System.out.print(i+" ");
    }
}
