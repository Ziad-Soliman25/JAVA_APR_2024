// to run this:
// javac HelloWorld.java && java HelloWorld

// every file is a class
public class HelloWorld {

    // entry point to start the app
    public static void main(String[] unicorn) {
        System.out.println("Hello World");

        // VARIABLES
        // primitive types
        boolean vote = true;
        int year = 2024;
        // byte x = 123; // -128 up to 128
        double taxRate = 3.44;
        char letter = 'a';
        long veryLargeNumber = 2138746128364128763L;

        // Object Types - Class Wrappers
        String name = "Steve";
        Integer width = 5;
        Double pie = 3.1459;
        Boolean isAdmin = false;
        // System.out.println(name.length());
        int nameLength = name.length();
        System.out.println(name + " is " + nameLength + " characters long");

        // String a = "Bob";
        // String b = "Bob";

        String a = new String("Bob");
        String b = new String("Bob");

        System.out.println(a.equals(b));

        String ninja = String.format("Hi %s, you owe me $ %d !", "Jack", 25);
        System.out.println(ninja);

        // instantiate the other class here
        AnotherFile x = new AnotherFile();

        x.sayHi();
        String message =  x.sayHello("Alice");
        System.out.println(message);

        x.sayHello("john", 39);
    }
}