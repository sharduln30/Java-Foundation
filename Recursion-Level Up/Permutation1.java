import java.util.Scanner;

class Permutation1 {

    public static void permutate(int[] tb,int cc, int tc){
        if(cc==tc+1){
            for(int i:tb){
                System.out.print(i);
            }
            System.out.println();
            return;
        }
        for(int i=0;i<tb.length;i++){
            if(tb[i]==0){
                tb[i]=cc;
                permutate(tb, cc+1,tc);
                tb[i]=0;
            }
        } 
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tb=sc.nextInt();
        int tc=sc.nextInt();
        permutate(new int[tb], 1,tc);
    }
}