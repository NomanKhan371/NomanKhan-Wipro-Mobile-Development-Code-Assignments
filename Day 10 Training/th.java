
public class th {

    public static void printHelloWorld(){
     for (int i = 0; i < 10; i++) {
        System.out.println("Hello World");
     }
    }  
    
    public static void main(String[] args) throws InterruptedException {
        Thread th = new Thread(() -> printHelloWorld());
        Thread th2 = new Thread(() -> System.out.println(2 + 2));

        th.start();
        // th.join();
        Thread.sleep(2000); // wait 2 seconds
        th2.start();
    }
    
}

