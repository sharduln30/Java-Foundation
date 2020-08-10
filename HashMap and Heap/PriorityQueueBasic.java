import java.util.Collections;
import java.util.PriorityQueue;

class PriorityQueueBasic {
    public static void main(String[] args) {
        int[] arr = {100, 50, 45, -70, 150, -100, 175, -37, 95, -10};

        //for min PQ
        PriorityQueue pq = new PriorityQueue<>();
        
        // for max PQ
        // PriorityQueue pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i:arr){
            pq.add(i);
            System.out.println("added val: "+i+"---new min-> "+pq.peek());
        }

        while(pq.size()>0){
            System.out.print(pq.remove()+" ");
        }
    }
}