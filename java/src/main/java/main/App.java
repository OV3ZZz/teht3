package main;

import java.util.ArrayList;
import java.util.Scanner;

class Animal {
    private String race;
    private String name;
    private int age;

    public Animal(String race, String name, int age) {
        this.race = race;
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return race + ": " + name + ", " + age + " vuotta";
    }

    public void run() {
        System.out.println(name + " juoksee kovaa vauhtia!");
    }
}

class Zoo {
    private String name;
    private ArrayList<Animal> animals = new ArrayList<>();

    public Zoo(String name) {
        this.name = name;
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void listAnimals() {
        System.out.println(name + " pitää sisällään seuraavat eläimet:");
        for (Animal animal : animals) {
            System.out.println(animal.toString());
        }
    }

    public void runAnimals(int rounds) {
        for (Animal animal : animals) {
            for (int i = 0; i < rounds; i++) {
                animal.run();
            }
        }
    }
}

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Anna eläintarhalle nimi:");
        String zooName = scanner.nextLine();
        Zoo zoo = new Zoo(zooName);

        int valinta;
        do {
            System.out.println("1) Luo uusi eläin, 2) Listaa kaikki eläimet, 3) Juoksuta eläimiä, 0) Lopeta ohjelma");
            valinta = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (valinta) {
                case 1:
                    System.out.println("Mikä laji?");
                    String race = scanner.nextLine();
                    System.out.println("Anna eläimen nimi:");
                    String name = scanner.nextLine();
                    System.out.println("Anna eläimen ikä:");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    Animal newAnimal = new Animal(race, name, age);
                    zoo.addAnimal(newAnimal);
                    break;
                case 2:
                    zoo.listAnimals();
                    break;
                case 3:
                    System.out.println("Kuinka monta kierrosta?");
                    int rounds = scanner.nextInt();
                    zoo.runAnimals(rounds);
                    break;
                case 0:
                    System.out.println("Kiitos ohjelman käytöstä.");
                    break;
                default:
                    System.out.println("Syöte oli väärä");
            }
        } while (valinta != 0);

        scanner.close();
    }
}
