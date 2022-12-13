// .Реализуйте структуру телефонной книги с помощью HashMap, 
//  учитывая, что 1 человек может иметь несколько телефонов.
//package lesson5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.*;

public class homeTask1 {

    public static void main(String[] args) {
        // очистка консоли
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.printf("Добро пожаловать!%n");

        Map<String, String> phoneBook = new HashMap<>();
        phoneBook.putIfAbsent("9027458965", "Иван Иванов");
        phoneBook.putIfAbsent("9054789413", "Светлана Петрова");
        phoneBook.putIfAbsent("9158756149", "Кирилл Немцов");
        phoneBook.putIfAbsent("9024758075", "Иван Иванов");
        phoneBook.putIfAbsent("9258741785", "Мария Савина");
        phoneBook.putIfAbsent("9041257634", "Марина Лугова");
        phoneBook.putIfAbsent("9284575541", "Карл Ян");
        phoneBook.putIfAbsent("9354785123", "Иван Кошкин");

        System.out.printf("Вберите команду:%n");
        int search;
        Scanner in = new Scanner(System.in);
        System.out.printf("1 - поиск по номеру%n2 - поиск по имени%n3 - по фамилии%n4 - создать контакт%n5 - удалить%n6 - показать все записи%nВведите цифру:");
        search = in.nextInt();
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // поиск по номеру
        if (search == 1) {
            String number = numberSearch();
            if (phoneBook.containsKey(number)) {
                System.out.printf("Контакт: %s %s", number, phoneBook.get(number));
            } else {
                System.out.println("Такого номера не существует");
            }

            // поиск по имени
        } else if (search == 2) {
            String nam = nameSearch();
            String key = "";
            for (String k : phoneBook.keySet()) {
                String[] words = phoneBook.get(k).toLowerCase().split(" ");
                // System.out.println(words[0]);
                String[] tpm = new String[1];
                tpm[0] = words[0];
                for (String word : tpm) {
                    if (word.equals(nam)) {
                        key = k;
                        System.out.printf("Контакт: %s %s%n", key, phoneBook.get(k));
                    } else {
                        // System.out.println("Такого номера не существует");
                    }

                }
            }

            // поиск по фамилии
        } else if (search == 3) {
            String nam = famSearch();
            String key = "";
            for (String k : phoneBook.keySet()) {
                String[] words = phoneBook.get(k).toLowerCase().split(" ");
                String[] tpm = new String[1];
                tpm[0] = words[1];
                for (String word : tpm) {
                    if (word.equals(nam)) {
                        key = k;
                        System.out.printf("Контакт: %s %s%n", key, phoneBook.get(k));
                    } else {
                        // System.out.println("Такого номера не существует");
                    }
                }
            }

            // создание нового
        } else if (search == 4) {
            String key = addContNum();
            String val = addCont();
            phoneBook.putIfAbsent(key, val);
            System.out.printf("Контакт %s %s создан", key, val);
            System.out.println(phoneBook);
            
            // удаление
        } else if (search == 5) {
            for (Object entryObj : phoneBook.entrySet()) {
                Map.Entry entry = (Map.Entry) entryObj;
                Object key = entry.getKey();
                Object value = entry.getValue();
                System.out.printf("Номер: %s контакт: %s%n", key, value);
            }
            System.out.print("Введите номер телефона удаляемого контакта: ");
            Scanner it = new Scanner(System.in, "Cp866");
            String dell = in.next();
            phoneBook.remove(dell);
            System.out.print("Запись удалена");

            // показать все
        } else if (search == 6) {
            for (Object entryObj : phoneBook.entrySet()) {
                Map.Entry entry = (Map.Entry) entryObj;
                Object key = entry.getKey();
                Object value = entry.getValue();
                System.out.printf("Номер: %s контакт: %s%n", key, value);
            }
        }
    }


    // поиск по номеру
    public static String numberSearch() {
        Scanner in = new Scanner(System.in, "UTF-8");
        System.out.print("Введите номер в формате 'XXXXXXXXXX': ");
        String numbS = in.next();
        return numbS;
    }


    // поиск по имени
    public static String nameSearch() {
        Scanner in = new Scanner(System.in, "Cp866");
        System.out.print("Введите имя контакта: ");
        String nameS = in.nextLine();
        System.out.printf("%nПоиск по имени: %s%n", nameS);
        return nameS.toLowerCase();
    }


    // поиск по фамилии
    public static String famSearch() {
        System.out.print("Введите фамилию контакта: ");
        Scanner in = new Scanner(System.in, "Cp866");
        String famS = in.next();
        System.out.printf("%nПоиск по фамилии: %s%n", famS);
        return famS;
    }


    // создание имени контакта
    public static String addCont() {
        Scanner innam = new Scanner(System.in, "Cp866");
        System.out.print("Введите имя контакта: ");
        String nameS = innam.nextLine();
        // С заглавной буквы
        String name = nameS.substring(0, 1).toUpperCase() + nameS.substring(1);
        Scanner infam = new Scanner(System.in, "Cp866");
        System.out.print("Введите фамилию контакта: ");
        String famS = infam.nextLine();
        String fam = famS.substring(0, 1).toUpperCase() + famS.substring(1);
        String cont = name + " " + fam;
        return cont;
    }


    // создание номера контакта
    public static String addContNum() {
        Scanner in = new Scanner(System.in, "Cp866");
        System.out.print("Введите номер телефона контакта в формате ХХХХХХХХХХ: ");
        String numS = in.nextLine();
        // С заглавной буквы
        String numb = numS.substring(0, 1).toUpperCase() + numS.substring(1);
        return numb;
    }
}