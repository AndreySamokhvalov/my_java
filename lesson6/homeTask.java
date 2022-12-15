package lesson6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class homeTask {
    public static void main(String[] args) throws InterruptedException {

        // очистка консоли
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.printf("Добро пожаловать!%n");

        List<String> menu = readMenu();

        // храним критерии в HashMap
        Map<Integer, String> criteria = new HashMap<>();
        int k = 1;
        for (String i : menu) {
            criteria.putIfAbsent(k, i);
            k++;
        }

        // Laptop lt1 = new Laptop(1, "hp", "HP 15-dw11045ur", "win", "black", 2, 512,
        // 2, 14.5);
        //

        HashSet<Laptop> laptops = getSet();

        Scanner in = new Scanner(System.in, "Cp866");
        boolean mainLoop = true;

        int choice;
        do {
            for (Object entryObj : criteria.entrySet()) {
                Map.Entry entry = (Map.Entry) entryObj;
                Object key = entry.getKey();
                Object value = entry.getValue();
                System.out.printf("%s - %s%n", key, value);
            }
            System.out.println("Выбирите пункт меню: ");
            choice = in.nextInt();

            switch (choice) {

                // по производителю
                case 1:
                    // очистка консоли
                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    System.out.println("Введите производителя: ");
                    Scanner inOne = new Scanner(System.in, "Cp866");
                    String one = inOne.nextLine();
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.printf("Вот что нашлось по производителю %s: %n", one);

                    System.out.println(Laptop.getModel(laptops, one));
                    if (Laptop.getModel(laptops, one).length() == 0) {
                        System.out.printf("Поиск не дал результатов%n");

                    }
                    int qq;
                    do {
                        System.out.printf("%n1 - Выполнить новый поиск%n2 - Выход%n");
                        Scanner q = new Scanner(System.in, "Cp866");
                        qq = q.nextInt();

                        switch (qq) {
                            case 1:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                break;
                            case 2:
                                // красивый выход с обратным отсчетом
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                System.out.println("Завершение работы через 3");
                                Thread.sleep(1000);
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                System.out.println("Завершение работы через 2");
                                Thread.sleep(1000);
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                System.out.println("Завершение работы через 1");
                                Thread.sleep(1000);
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                System.out.println("До свидания!");
                                System.exit(0);

                            default:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();

                                System.out.printf("Пункта %d нет в меню%n", qq);
                                Thread.sleep(2000);
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                break;
                        }

                    } while (qq != 2 & qq != 1);
                    break;

                // по ram
                case 2:
                    // очистка консоли
                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    System.out.println("Введите минимальный объем RAM (Gb): ");
                    Scanner ramMin = new Scanner(System.in, "Cp866");
                    int rMin = ramMin.nextInt();
                    System.out.println("Введите максимальный объем RAM (Gb): ");
                    Scanner ramMax = new Scanner(System.in, "Cp866");
                    int rMax = ramMax.nextInt();
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.printf("Вот что нашлось в диапозоне  %s (Gb) - %s (Gb)%n", rMin, rMax);
                    System.out.println(Laptop.getRam(laptops, rMin, rMax));
                    if (Laptop.getRam(laptops, rMin, rMax).length() == 0) {
                        System.out.printf("Поиск не дал результатов%n");

                    }
                    int ww;
                    do {
                        System.out.printf("%n1 - Выполнить новый поиск%n2 - Выход%n");
                        Scanner w = new Scanner(System.in, "Cp866");
                        ww = w.nextInt();

                        switch (ww) {
                            case 1:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                break;
                            case 2:
                                // красивый выход с обратным отсчетом
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                System.out.println("Завершение работы через 3");
                                Thread.sleep(1000);
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                System.out.println("Завершение работы через 2");
                                Thread.sleep(1000);
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                System.out.println("Завершение работы через 1");
                                Thread.sleep(1000);
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                System.out.println("До свидания!");
                                System.exit(0);

                            default:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();

                                System.out.printf("Пункта %d нет в меню%n", ww);
                                Thread.sleep(2000);
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                break;
                        }
                    } while (ww != 2 & ww != 1);
                    break;

                // по объему vhd
                case 3:
                    // очистка консоли
                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    System.out.println("Введите минимальный объем HD (Gb): ");
                    Scanner hdMin = new Scanner(System.in, "Cp866");
                    int vMin = hdMin.nextInt();
                    System.out.println("Введите максимальный объем HD (Gb): ");
                    Scanner hdMax = new Scanner(System.in, "Cp866");
                    int vMax = hdMax.nextInt();
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.printf("Вот что нашлось в диапозоне  %s (Gb) - %s (Gb)%n", vMin, vMax);
                    System.out.println(Laptop.getHd(laptops, vMin, vMax));
                    if (Laptop.getHd(laptops, vMin, vMax).length() == 0) {
                        System.out.printf("Поиск не дал результатов%n");

                    }
                    int ee;
                    do {
                        System.out.printf("%n1 - Выполнить новый поиск%n2 - Выход%n");
                        Scanner e = new Scanner(System.in, "Cp866");
                        ee = e.nextInt();

                        switch (ee) {
                            case 1:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                break;
                            case 2:
                                // красивый выход с обратным отсчетом
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                System.out.println("Завершение работы через 3");
                                Thread.sleep(1000);
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                System.out.println("Завершение работы через 2");
                                Thread.sleep(1000);
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                System.out.println("Завершение работы через 1");
                                Thread.sleep(1000);
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                System.out.println("До свидания!");
                                System.exit(0);

                            default:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();

                                System.out.printf("Пункта %d нет в меню%n", ee);
                                Thread.sleep(2000);
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                break;
                        }
                    } while (ee != 2 & ee != 1);
                    break;

                // по количеству ядер
                case 4:
                    // очистка консоли
                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    System.out.println("Введите минимальное количество ядер: ");
                    Scanner сMin = new Scanner(System.in, "Cp866");
                    int coreMin = сMin.nextInt();
                    System.out.println("Введите максимальное количество ядер: ");
                    Scanner cMax = new Scanner(System.in, "Cp866");
                    int coreMax = cMax.nextInt();
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.printf("Вот что нашлось в диапозоне от %s  до %s ядер:%n", coreMin, coreMax);
                    System.out.println(Laptop.getCore(laptops, coreMin, coreMax));
                    if (Laptop.getCore(laptops, coreMin, coreMax).length() == 0) {
                        System.out.printf("Поиск не дал результатов%n");

                    }
                    int rr;
                    do {
                        System.out.printf("%n1 - Выполнить новый поиск%n2 - Выход%n");
                        Scanner r = new Scanner(System.in, "Cp866");
                        rr = r.nextInt();

                        switch (rr) {
                            case 1:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                break;
                            case 2:
                                // красивый выход с обратным отсчетом
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                System.out.println("Завершение работы через 3");
                                Thread.sleep(1000);
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                System.out.println("Завершение работы через 2");
                                Thread.sleep(1000);
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                System.out.println("Завершение работы через 1");
                                Thread.sleep(1000);
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                System.out.println("До свидания!");
                                System.exit(0);

                            default:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();

                                System.out.printf("Пункта %d нет в меню%n", rr);
                                Thread.sleep(2000);
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                break;
                        }
                    } while (rr != 2 & rr != 1);
                    break;

                // поиск по ос
                case 5:

                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    System.out.println("Введите название ОС: ");
                    Scanner inосOne = new Scanner(System.in, "Cp866");
                    String oсОne = inосOne.nextLine();
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.printf("Вот что нашлось по операционной системе %s: %n", oсОne);

                    System.out.println(Laptop.getOc(laptops, oсОne));
                    if (Laptop.getOc(laptops, oсОne).length() == 0) {
                        System.out.printf("Поиск не дал результатов%n");

                    }
                    int yy;
                    do {
                        System.out.printf("%n1 - Выполнить новый поиск%n2 - Выход%n");
                        Scanner y = new Scanner(System.in, "Cp866");
                        yy = y.nextInt();

                        switch (yy) {
                            case 1:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                break;
                            case 2:
                                // красивый выход с обратным отсчетом
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                System.out.println("Завершение работы через 3");
                                Thread.sleep(1000);
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                System.out.println("Завершение работы через 2");
                                Thread.sleep(1000);
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                System.out.println("Завершение работы через 1");
                                Thread.sleep(1000);
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                System.out.println("До свидания!");
                                System.exit(0);

                            default:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();

                                System.out.printf("Пункта %d нет в меню%n", yy);
                                Thread.sleep(2000);
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                break;
                        }

                    } while (yy != 2 & yy != 1);
                    break;

                case 6:
                    // поиск по цвету
                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    System.out.println("Введите цвет: ");
                    Scanner inColor = new Scanner(System.in, "Cp866");
                    String color = inColor.nextLine();
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.printf("Вот что нашлось по цвету %s: %n", color);

                    System.out.println(Laptop.getColor(laptops, color));
                    if (Laptop.getColor(laptops, color).length() == 0) {
                        System.out.printf("Поиск не дал результатов%n");

                    }
                    int uu;
                    do {
                        System.out.printf("%n1 - Выполнить новый поиск%n2 - Выход%n");
                        Scanner u = new Scanner(System.in, "Cp866");
                        uu = u.nextInt();

                        switch (uu) {
                            case 1:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                break;
                            case 2:
                                // красивый выход с обратным отсчетом
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                System.out.println("Завершение работы через 3");
                                Thread.sleep(1000);
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                System.out.println("Завершение работы через 2");
                                Thread.sleep(1000);
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                System.out.println("Завершение работы через 1");
                                Thread.sleep(1000);
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                System.out.println("До свидания!");
                                System.exit(0);

                            default:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();

                                System.out.printf("Пункта %d нет в меню%n", uu);
                                Thread.sleep(2000);
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                break;
                        }

                    } while (uu != 2 & uu != 1);
                    break;
                // поиск по диагонали
                case 7:
                    // очистка консоли
                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    System.out.println("Введите минимальную диагональ: ");
                    Scanner dMin = new Scanner(System.in, "Cp866");
                    Double dgMin = dMin.nextDouble();
                    System.out.println("Введите максимальную диагональ: ");
                    Scanner dMax = new Scanner(System.in, "Cp866");
                    Double dgMax = dMax.nextDouble();
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.printf("Вот что нашлось с диагоналями от %s''  до %s'' :%n", dgMin, dgMax);
                    System.out.println(Laptop.getCore(laptops, dgMin, dgMax));
                    if (Laptop.getCore(laptops, dgMin, dgMax).length() == 0) {
                        System.out.printf("Поиск не дал результатов%n");

                    }
                    int pp;
                    do {
                        System.out.printf("%n1 - Выполнить новый поиск%n2 - Выход%n");
                        Scanner p = new Scanner(System.in, "Cp866");
                        pp = p.nextInt();

                        switch (pp) {
                            case 1:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                break;
                            case 2:
                                // красивый выход с обратным отсчетом
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                System.out.println("Завершение работы через 3");
                                Thread.sleep(1000);
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                System.out.println("Завершение работы через 2");
                                Thread.sleep(1000);
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                System.out.println("Завершение работы через 1");
                                Thread.sleep(1000);
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                System.out.println("До свидания!");
                                System.exit(0);

                            default:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();

                                System.out.printf("Пункта %d нет в меню%n", pp);
                                Thread.sleep(2000);
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                break;
                        }
                    } while (pp != 2 & pp != 1);
                    break;

                case 8:
                    // красивый выход с обратным отсчетом
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("Завершение работы через 3");
                    Thread.sleep(1000);
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("Завершение работы через 2");
                    Thread.sleep(1000);
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("Завершение работы через 1");
                    Thread.sleep(1000);
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("До свидания!");
                    System.exit(0);
                default:
                    System.out.printf("Пункта %d нет в меню%n", choice);

            }

        } while (choice != 8 /* Exit loop when choice is 8 */);

    }

    // чтение файла
    public static List<String> readMenu() {
        List<String> arr = new ArrayList<String>();
        File file = new File("D:\\AndyData\\my_java\\my_java\\lesson6\\menu.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                // System.out.println(line);
                arr.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr;
    }

    // чтение файла
    public static List<String> readData() {
        List<String> arr = new ArrayList<String>();
        File file = new File("D:\\AndyData\\my_java\\my_java\\lesson6\\assortment.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                // System.out.println(line);
                arr.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr;
    }

    // Создание множества ноутбуков
    public static HashSet<Laptop> getSet() {
        List<String> data = readData();
        HashSet<Laptop> laptops = new HashSet<Laptop>();

        Laptop lt1 = new Laptop(0, null, null, null, null, 0, 0, 0, 0);
        Laptop lt2 = new Laptop(0, null, null, null, null, 0, 0, 0, 0);
        Laptop lt3 = new Laptop(0, null, null, null, null, 0, 0, 0, 0);
        Laptop lt4 = new Laptop(0, null, null, null, null, 0, 0, 0, 0);
        Laptop lt5 = new Laptop(0, null, null, null, null, 0, 0, 0, 0);
        Laptop lt6 = new Laptop(0, null, null, null, null, 0, 0, 0, 0);
        Laptop lt7 = new Laptop(0, null, null, null, null, 0, 0, 0, 0);
        Laptop lt8 = new Laptop(0, null, null, null, null, 0, 0, 0, 0);

        String one = data.get(0);
        lt1.setData(one.split("/"));
        laptops.add(lt1);

        String two = data.get(1);
        lt2.setData(two.split("/"));
        laptops.add(lt2);

        String three = data.get(2);
        lt3.setData(three.split("/"));
        laptops.add(lt3);

        String four = data.get(3);
        lt4.setData(four.split("/"));
        laptops.add(lt4);

        String five = data.get(4);
        lt5.setData(five.split("/"));
        laptops.add(lt5);

        String six = data.get(5);
        lt6.setData(six.split("/"));
        laptops.add(lt6);

        String seven = data.get(6);
        lt7.setData(seven.split("/"));
        laptops.add(lt7);

        String eight = data.get(7);
        lt8.setData(eight.split("/"));
        laptops.add(lt8);

        // Laptop [] laptops = new Laptop[]{lt1,lt2,lt3,lt4};

        return laptops;

    }
}
