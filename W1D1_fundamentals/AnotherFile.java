public class AnotherFile {
// access modifier
//    |
//    |   return type
//    |     |
//    |     |   method name (class function)
//    |     |     |
//    V     V     V
    public void sayHi() {
        System.out.println("hello there");
    }

    public String sayHello(String someName) {
        return "hello " + someName;
    }

    public String sayHello(String someName, int age) {
        System.out.println("this one!!!");
        return "hello " + someName;
    }
    public String sayHello( int age, String someName) {
        System.out.println("this one!!!");
        return "hello " + someName;
    }
}