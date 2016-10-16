package W24;

public class Multiply {
    String name;

    public Multiply(String personName) {
        name = personName;
    }

    public String greet(String yourName) {
        return String.format("Hi %s, my name is %s", name, yourName);
    }

    public static void main(String[] args) {
        Multiply multiply=new Multiply("pankaj");
        System.out.println(multiply.greet("Tiwari"));
    }
}