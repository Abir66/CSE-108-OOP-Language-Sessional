public class Mammal extends Animal {

    public Mammal(String name, int age) {
        super(name, age);
        bloodType = "Warm-Blooded";
    }

    public void printBloodType() {
        System.out.print(", " + bloodType);
    }
}
