import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ihomeTask2 {
    public static void main(String[] args) {
        // очистка консоли
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.printf("Добро пожаловать!%n");

        List<String> arr = readData();
        // List<String> unicName = createUnicData(arr);

        Map<Integer, String> map = new HashMap<>();
        int k = 1;
        for (String i : arr) {
            map.putIfAbsent(k, i);
            k++;
        }

        // печать HashMap
        // for (Object entryObj : map.entrySet()) {
        // Map.Entry entry = (Map.Entry) entryObj;
        // Object key = entry.getKey();
        // Object value = entry.getValue();
        // System.out.printf("Номер: %s имя: %s%n", key, value);
        // }

        Map<String, Integer> out = new HashMap<>();
        List<String> unicName = createUnicData(arr);
        for (String i : unicName) {
            int count = 0;
            String uName = i.substring(0, 1).toUpperCase() + i.substring(1).toLowerCase();// с заглавной
            for (Integer j : map.keySet()) {
                String[] words = map.get(j).split(" ");
                String[] tpm = new String[1];
                tpm[0] = words[0];// имя из hasmap
                if (uName.equals(tpm[0])) {
                    count++;
                }
            }
            out.putIfAbsent(uName, count);
        }

        // сортируем по убывани
        Map<String, Integer> sortedMap = out.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors
                        .toMap(Map.Entry::getKey,
                                Map.Entry::getValue,
                                (e1, e2) -> e1,
                                LinkedHashMap::new));

        // печать ответа
        for (Object entryObj : sortedMap.entrySet()) {
            Map.Entry entry = (Map.Entry) entryObj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            System.out.printf("Имя: %s встречается: %s раз%n", key, value);
        }
    }


    // чтение файла
    public static List<String> readData() {
        List<String> arr = new ArrayList<String>();
        File file = new File("D:\\AndyData\\my_java\\my_java\\lesson5\\homeTask2\\names.txt");
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


    // создание листа уникальных имен
    public static List<String> createUnicData(List<String> names) {
        // List<String> arr = names;
        List<String> out = new ArrayList<String>();
        for (String n : names) {
            String[] tmp = n.toLowerCase().split(" ");
            out.add(tmp[0]);
        }
        Set<String> set = new HashSet<>(out);
        out.clear();
        out.addAll(set);
        // System.out.printf("Уникальные:%S%n ", out);
        // String numb = numS.substring(0, 1).toUpperCase() + numS.substring(1);
        return out;
    }
}
