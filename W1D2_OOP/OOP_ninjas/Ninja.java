public class Ninja{
    // member variables
    private String name;
    private String weapon;
    private Integer health;
    private static int numberOfNinjasGraduated = 0;

    // constructor(s)
    public Ninja() {
        this.name = "anonymous";
        this.weapon = "hands";
        this.health = 1000;
        numberOfNinjasGraduated++;
    }
    public Ninja(String someName, String weapon, Integer health) {
        this.name = someName;
        this.weapon = weapon;
        this.health = health;
        numberOfNinjasGraduated++;
    }

    // === METHODS ====
    public void displayStats() {
        System.out.println(this.getName() + " has: \n " + this.getWeapon() + " as their weapon and\n " + this.getHealth() + " hp");
    }

    public Ninja attack(Ninja target){
        System.out.println(this.getName() + " attacks " + target.getName());
        target.setHealth(target.getHealth() - 10);
        System.out.println(target.getName() + " now has " + target.getHealth() + " hp left");
        return this;
    }

    // STATIC getter
    public static int getNumberOfNinjasGraduated() {
        return numberOfNinjasGraduated;
    }

    // ====== GETTERS AND SETTERS ========
    // getter for name
    public String getName() {
        return this.name;
    }
    // setter for name
    public void setName(String someName){
        this.name = someName;
    }
    // getter for weapon
    public String getWeapon() {
        return this.weapon;
    }
    // setter for weapon
    public void setWeapon(String someWeapon){
        this.weapon = someWeapon;
    }
    // getter for health
    public Integer getHealth() {
        return this.health;
    }
    // setter for health
    public void setHealth(Integer someHealth){
        this.health = someHealth;
    }
}