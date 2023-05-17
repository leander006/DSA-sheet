public class Interface_eg {
      public static void main(String[] args) {
            Ani a = new Ani();
            a.eat_grass();
            a.eat_meat();
      }
}

interface Herbivore {
      void eat_grass();
}

interface Carnivores {
      void eat_meat();
}

class Ani implements Herbivore, Carnivores {
      public void eat_grass() {
            System.out.println("EATS GRASS");
      }

      public void eat_meat() {
            System.out.println("EATS MEAT");
      }
}