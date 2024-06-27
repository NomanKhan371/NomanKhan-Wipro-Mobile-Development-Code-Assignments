public class loops {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {

            System.out.println(i +" Noman Khan");   
        }

        int i = 0;
        while (i < 100) {
            if (i % 2 != 0) {
                i++;
                continue;
            }

            if (i == 50) {
                break;
            }
            System.out.println(i);
            i++;
        }

        do {
            System.out.println("i will atleast run 1 time");
        } while (i==-4);
    }
}
