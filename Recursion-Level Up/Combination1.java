import java.util.Scanner;

class Combination1 {

    static int r=0;
    public static void combination(int cb,int cc, int tb, int tc, String asf){

        if(cb==tb){
            if(cc==tc){
                System.out.println(asf);
                return;
            }
            return;
        }
        combination(cb+1,cc+1,tb,tc,asf+"i");
        combination(cb+1,cc,tb,tc,asf+"-");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tb=sc.nextInt();
        int tc=sc.nextInt();
        combination(0,0,tb,tc,"");
    }
}