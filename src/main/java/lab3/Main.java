package lab3;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {

        //ZAD 1
        Set<String> zbiorDni = new TreeSet<>();
        zbiorDni.add("poniedziałek");
        zbiorDni.add("wtorek");
        zbiorDni.add("środa");
        zbiorDni.add("czwartek");
        zbiorDni.add("piątek");
        zbiorDni.add("sobota");
        zbiorDni.add("niedziela");
        System.out.println(zbiorDni);
        for (String dzien : zbiorDni) {
            System.out.println(dzien);
        }
        // czym się różni HashSet od TreeSet? -- HashSet jest nieuporządkowany ale działa szybciej, TreeSet jest uporządkowany zgodnie z naturalnym porządkiem lub podanym przy deklaracji
        //której klasy użyć w jakiej sytuacji? -- TreeSet, ponieważ mamy możliwość podania porządku zgodnie z którym będzie posortowany zbiór, jeśli koniecznie chcemy mieć dni po kolei
        //czy były wymagane jakiekolwiek zmiany w kodzie poza miejscem tworzenia obiektu (new HashSet<>() / new TreeSet<>()) ? -- nie

        //ZAD 2
        Map<String, Teacher> przedmioty = new HashMap<>();
        przedmioty.put("Systemy internetowe", new Teacher("Izabela", "Rejer", "irejer@zut.edu.pl"));
        przedmioty.put("Modelowanie systemów", new Teacher("Piotr", "Piela", "ppiela@zut.edu.pl"));
        przedmioty.put("Programowanie obiektowe", new Teacher("Maciej", "Poliwoda", "mpoliwoda@zut.edu.pl"));
        System.out.println(przedmioty.get("Programowanie obiektowe"));

        Map<Integer, List<Student>> grupy = new HashMap<>();

        List<Student> grupa31 = new ArrayList<>();
        grupa31.add(new Student("Maciej", "Nowak", "mnowak@zut.edu.pl"));
        grupa31.add(new Student("Michał", "Kowalski", "mkowalski@zut.edu.pl"));

        List<Student> grupa32 = new ArrayList<>();
        grupa32.add(new Student("Jan", "Kowalski", "jkowalski@zut.edu.pl"));
        grupa32.add(new Student("Zenon", "Nowak", "znowak@zut.edu.pl"));

        grupy.put(31, grupa31);
        grupy.put(32, grupa32);
        for (Student s : grupy.get(32)) {
            System.out.println(s.getFirstName() + " " + s.getLastName());
        }

        //ZAD 3
        try (BufferedReader in = new BufferedReader(new FileReader("plik.txt"))) {
            String s = "";
            List<Product> products = new ArrayList<>();
            Map<Integer, Product> productsById = new HashMap<>();
            Map<String, List<Product>> productsByCategory = new HashMap<>();
            
            //odczytywanie produktów z pliku
            while((s = in.readLine()) != null){
                String[] pola = s.split(";");
                Integer id = Integer.parseInt(pola[0]);
                String name = pola[1];
                String category = pola[2];
                Double price = Double.parseDouble(pola[3]);
                products.add(new Product(id, name, category, price));
            }
            
            //tworzenie map do wyszukiwania po id i kategorii
            for (Product p : products){
                String category = p.getCategory();
                Integer id = p.getId();
                productsById.put(id, p);
                if(!productsByCategory.containsKey(category)){
                    productsByCategory.put(category, new ArrayList<>());
                }
                productsByCategory.get(category).add(p);
            }
            
            //wyswietlanie
            for (Product p : products){
            System.out.println(p.getId() + " " + p.getName() + " " + p.getCategory() + " " + p.getPrice());
            }
            
            {
                Product p = productsById.get(111);
                System.out.println("\n Produkt o id \"111\":\n" + p.getId() + " " + p.getName() + " " + p.getCategory() + " " + p.getPrice());
            }
            
            {
                List<Product> list = productsByCategory.get("oprogramowanie");
                System.out.println("\n Produkty w kategorii \"oprogramowanie\":\n");
                for (Product p : list){
                    System.out.println(p.getId() + " " + p.getName() + " " + p.getCategory() + " " + p.getPrice());
                }
            }
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
