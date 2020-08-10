import java.util.Arrays;
import java.util.Scanner;

class Permutation2 {

    
    public static void permutations(int cb, int tb, int[] items, int ssf, int tc, String asf){
        if(cb==tb+1){
        if(ssf==tc){
            System.out.println(asf);
        }
            return;
        }
        
        for(int i=0;i<items.length;i++){
            if(items[i]==0){
                items[i]=cb;
                permutations(cb+1,tb,items,ssf+1,tc,asf+(i+1));
                items[i]=0;
            }
        }
        permutations(cb+1,tb,items,ssf,tc,asf+"0");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nboxes=sc.nextInt();
        int ritems=sc.nextInt();
        permutations(1, nboxes, new int[ritems], 0, ritems, "");
    }
}