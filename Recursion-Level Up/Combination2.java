import java.util.Scanner;

class Combination2 {

    public static void combination(int[] tb,int cc, int tc,int lcu){
        if(cc==tc+1){
            for(int i:tb){
                if(i==0)
                    System.out.print("-");
                else
                    System.out.print("i");
            }
            System.out.println();
            return;
        }
        for(int i=lcu+1;i<tb.length;i++){
            if(tb[i]==0){
                tb[i]=cc;
                combination(tb, cc+1,tc,lcu+1);
                tb[i]=0;
            }
        } 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tb=sc.nextInt();
        int tc=sc.nextInt();
        combination(new int[tb], 1,tc,-1);
    }
}
