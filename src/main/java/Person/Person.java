package Person;

import java.util.Scanner;

public class Person {
    public static void main(String[] args) {
        String name = EnterName();
    }


    public static String EnterName() {
        {
            System.out.print("Введите имя: ");
            Scanner scan = new Scanner(System.in);
            String namePerson = scan.nextLine();
            return namePerson;

        }
    }
}

