public class Inheritance_eg {
      public static void main(String[] args) {
            Animal a1 = new Animal();
            a1.eat();
            a1.breathe();

            Fish f1 = new Fish();
            f1.eat();
            f1.breathe();
            f1.swim();
      }
}

class Animal {
      String col;

      void eat() {
            System.out.println("eats");
      }

      void breathe() {
            System.out.println("breathe");
      }

}

class Fish extends Animal {

      String name;

      void swim() {
            System.out.println("swim");
      }
}