import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

     public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 25));
        people.add(new Person("Charlie", 35));
        people.add(new Person("Dave", 20));

        System.out.println("Before sorting:");
        people.forEach(System.out::println);

        // Sorting using lambda expression
        people.sort((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()));

        System.out.println("\nAfter sorting by age:");
        people.forEach(System.out::println);
    }
}
