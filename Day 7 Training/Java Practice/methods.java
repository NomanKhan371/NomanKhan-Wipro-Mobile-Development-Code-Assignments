public class methods {
    public static int addition(int number1, int number2){
        return number1 + number2;
    }
    public static int subtraction(int number1, int number2){
        return number1 - number2;
    }
    public static int multiplication(int number1, int number2){
        return number1 * number2;
    }
    public static int division(int number1, int number2){
        return number1 / number2;
    }

    public static double sine(int a){
        return Math.sin(a);
    }

    public static double cosine(int a){
        return Math.cos(a);
    }

    public static double tan(int a){
        return sine(a)/ cosine(a);
    }

    public static void main(String[] args) {
       double sine = sine(90);
       System.out.println(sine);
       double cosine=  cosine(0);
       System.out.println(cosine);
    }
}
