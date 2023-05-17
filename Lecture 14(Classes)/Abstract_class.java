public class Abstract_class {
      public static void main(String[] args) {

            // Animal a1 = new Animal() not possible since abstract class

            Horse h1 = new Horse();
            h1.eat();
            h1.walk();
      }
}

abstract class Animal {
      void eat() {
            System.out.println("eats");
      }

      abstract void walk();
}

class Horse extends Animal {
      void walk() {
            System.out.println("Horse walks on 4 legs");
      }
}
