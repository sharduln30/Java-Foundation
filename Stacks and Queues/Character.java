import java.util.Scanner;

public class Character {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int l = sc.nextInt();
        int h = sc.nextInt();

        for (int i = l; i <= h; i++) {
            int j = 2;
            int c = 0;
            if (i % 10 == 1) {
                while (j < i) {
                    if (i % j == 0)
                        c++;
                    j++;
                }
                if (c == 0)
                    System.out.print(i + " ");
            }
        }
        for (int i = h+1; i < Integer.MAX_VALUE; i++) {
            int j = 2;
            int c = 0;
            if (i % 10 == 1) {
                while (j < i) {
                    if (i % j == 0)
                        c++;
                    j++;
                }
                if (c == 0)
                    System.out.print(i + " ");
                    return;
            }
        }
    }

}
