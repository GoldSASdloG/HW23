import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    private static final String FORMAT_NUM_REGEX = "(\\d{3})(\\d{3})(\\d{2})(\\d{2})";

    private static Set<String> numeras = new TreeSet<>();


    public static void main(String[] args) {

        System.out.println("\t\t\t Добро пожаловать в книжку с номерами!!!\n\n");
        while (true){
            System.out.println("Введите номер или команду \"print\"\n");

            String input = new Scanner(System.in).nextLine();
            if (input.equalsIgnoreCase("print")) {
                prints();
            } else if (input.equalsIgnoreCase("exit")) {
                System.out.println("Всего доброго!!!");
                return;
            } else {
                String num = input.replaceAll("\\D+", "");

                if (num.length() > 11 || num.length() < 9) {
                    System.out.println("Номер не коректен!");
                    return;
                } else if (num.length() == 11) {
                    num = num.substring(1);
                    add(num);
                }
//                add(num);
            }
        }
    }
    private static void add(String num) {
        if (numeras.contains(num)) {
            System.out.println("Такой номер " + num + " уже есть в списке!");
            return;
        }
        numeras.add(num);
        System.out.println("Этот номер " + num + " успешно добавлен!");
    }

    private static void prints() {
        if (numeras.isEmpty()){
            System.out.println("Телефонная книга пуста!");
            return;
        }
        for (String num : numeras) {
            String formatNumers = num.replaceAll(FORMAT_NUM_REGEX, "+7($1) $2-$3-$4");
            System.out.println(formatNumers);
        }
    }
}