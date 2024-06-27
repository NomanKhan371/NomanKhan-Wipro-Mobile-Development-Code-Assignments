public class patterns {
    public static void main(String[] args) {
        // for (int i = 1; i <= 5; i++) {
        // for (int j = 0; j < i; j++) {
        // System.out.print("*");
        // }
        // System.out.println();

        // }

        // for (int i = 5; i >= 1; i--) {
        // for (int j = i; j >=1; j--) {
        // System.out.print("*");
        // }
        // System.out.println();
        // }

        // with two loops
        // int n = 5;
        // for (int i = 1; i <=n; i++) {
        // if (i%2==0) {
        // continue;}
        // // spaces
        // for (int j = 1; j <= n-i; j++) {
        // System.out.print(" ");
        // }
        // //stars
        // for (int j = 1; j <= i; j++) {
        // System.out.print("* ");

        // }
        // System.out.println();
        // }
        



        // with three loops
        // int n = 5;
        // for(int i=1; i<=n; i++) {
        // //spaces
        // for(int j=1; j<=n-i; j++) {
        // System.out.print(" ");
        // }

        // //first part
        // for(int j=i; j>=1; j--) {
        // System.out.print("*");
        // }

        // //second part
        // for(int j=2; j<=i; j++) {
        // System.out.print("*");
        // }
        // System.out.println();
        // }
        // }



        // TODO Hollow Triangle
        int n = 5;
        int i, j, k;

        // outer loop to handle rows
        for (i = 1; i <= n; i++) {
            // inner loop to print spaces.
            for (j = i; j < n; j++) {
                System.out.print(" ");
            }
            for (k = 1; k <= (2 * i - 1); k++) {
                // printing stars.
                if (k == 1 || i == n || k == (2 * i - 1)) {
                    System.out.print("*");
                }
                // printing spaces.
                else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }
}