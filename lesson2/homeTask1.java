package lesson2;

public class homeTask1 {

    public static void main(String[] args) {
        // очистка консоли
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.printf("Добро пожаловать!%n");

        String jsonString = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        jsonString = jsonString.replace("\"", "");
        StringBuilder where = new StringBuilder();
        String query = "select * from students where \n";
        where.append(query);
        String[] myStr = jsonString.substring(1, jsonString.length() - 1).split(", ");
        System.out.println(myStr);
        boolean first = true;
        for (String str : myStr) {
            String[] pair = str.split(":");
            if (pair.length > 1) {
                if (!pair[1].equals("null")) {
                    if (first)
                        first = false;
                    else
                        where.append("\n");
                    where.append(pair[0]);
                    where.append(" = \"");
                    where.append(pair[1]);
                    where.append("\" and");
                }
            }
        }
        if (where.substring(where.length() - 3, where.length()).equals("and")) {
            where.delete(where.length() - 3, where.length());
        }

        System.out.println(where);

    }
}
