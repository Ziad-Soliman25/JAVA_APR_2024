public class TestNinja {
    public static void main(String[] args) {
        Ninja vegeta = new Ninja();

        Ninja naruto = new Ninja("Naruto", "shuriken", 100);


        // System.out.println(naruto.getName());
        vegeta.displayStats();
        naruto.displayStats();

        vegeta.attack(naruto).attack(naruto).attack(naruto).attack(naruto);
        // vegeta.attack(naruto);
        // vegeta.attack(naruto);
        // vegeta.attack(naruto);

        Ninja donatello = new Ninja("Donatello", "staff", 100);

        System.out.println(
        Ninja.getNumberOfNinjasGraduated()
        );


    }
}