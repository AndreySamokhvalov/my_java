package lesson6;

import java.util.HashSet;

public class Laptop {

    String maker;
    int article;
    String model;
    String oc;
    String color;
    int ram;
    int vhd;
    int core;
    double diagonal;

    public Laptop(int article, String maker, String model, String oc, String color, int ram, int vhd, int core,
            double diagonal) {
        this.article = article;
        this.maker = maker;
        this.model = model;
        this.oc = oc;
        this.color = color;
        this.ram = ram;
        this.vhd = vhd;
        this.core = core;
        this.diagonal = diagonal;

    }

    public String toString(StringBuilder model) {
        return "Артикул: " + article + "\n" +
                "Производитель: " + maker + "\n" +
                "Модель: " + model + "\n" +
                "ОС: " + oc + "\n" +
                "Цвет: " + color + "\n" +
                "RAM: " + ram + "\n" +
                "Объем HD: " + vhd + "\n" +
                "Количество ядер: " + core + "\n" +
                "Диагональ: " + diagonal + "\n";
    }

    public static StringBuilder getModel(HashSet<Laptop> laptops, String maker) {
        StringBuilder result = new StringBuilder();
        for (Laptop l : laptops) {
            if (l.maker.equals(maker)) {
                result.append(l.model);
                result.append("\n");
            }
        }
        return result;
    }

    public void setData(String[] qqq) {
        article = Integer.parseInt(qqq[0]);
        maker = qqq[1];
        model = qqq[2];
        oc = qqq[3];
        color = qqq[4];
        ram = Integer.parseInt(qqq[5]);
        vhd = Integer.parseInt(qqq[6]);
        core = Integer.parseInt(qqq[7]);
        diagonal = Double.parseDouble(qqq[8]);
    }

    public static StringBuilder getRam(HashSet<Laptop> laptops, int rMin, int rMax) {
        StringBuilder result = new StringBuilder();
        for (Laptop l : laptops) {
            if (l.ram >= rMin & l.ram <= rMax) {
                result.append(l.model);
                result.append("\n");
            }
        }
        return result;
    }

    public static StringBuilder getHd(HashSet<Laptop> laptops, int vMin, int vMax) {
        StringBuilder result = new StringBuilder();
        for (Laptop l : laptops) {
            if (l.vhd >= vMin & l.vhd <= vMax) {
                result.append(l.model);
                result.append("\n");
            }
        }
        return result;
    }

    public static StringBuilder getCore(HashSet<Laptop> laptops, int cMin, int cMax) {
        StringBuilder result = new StringBuilder();
        for (Laptop l : laptops) {
            if (l.core >= cMin & l.core <= cMax) {
                result.append(l.model);
                result.append("\n");
            }
        }
        return result;
    }

    public static StringBuilder getOc(HashSet<Laptop> laptops, String os) {
        StringBuilder result = new StringBuilder();
        for (Laptop l : laptops) {
            if (l.oc.equals(os)) {
                result.append(l.model);
                result.append("\n");
            }
        }
        return result;
    }

    public static StringBuilder getColor(HashSet<Laptop> laptops, String col) {
        StringBuilder result = new StringBuilder();
        for (Laptop l : laptops) {
            if (l.color.equals(col)) {
                result.append(l.model);
                result.append("\n");
            }
        }
        return result;
    }

    public static StringBuilder getCore(HashSet<Laptop> laptops, Double dMin, Double dMax) {
        StringBuilder result = new StringBuilder();
        for (Laptop l : laptops) {
            if (l.diagonal >= dMin & l.diagonal <= dMax) {
                result.append(l.model);
                result.append("\n");
            }
        }
        return result;
    }

    public void setName(String nm) {
        maker = nm;
    }

    public  void printParm() {
        System.out.print("\n" + "Артикул: " + article + "\n");
        System.out.print("Производитель: " + maker + "\n");
        System.out.print("Модель: " + model + "\n");
        System.out.print("ОС: " + oc + "\n");
        System.out.print("Цвет: " + color + "\n");
        System.out.print("RAM: " + ram + "\n");
        System.out.print("Объем HD: " + vhd + "\n");
        System.out.print("Количество ядер: " + core + "\n");
        System.out.print("Диагональ: " + diagonal + "\n");
    }

}
