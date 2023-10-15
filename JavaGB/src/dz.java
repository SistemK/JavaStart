import java.util.*;

//Реализуйте структуру телефонной книги с помощью HashMap.
//Программа также должна учитывать, что в во входной структуре будут повторяющиеся имена с разными телефонами, их необходимо считать, как одного человека с разными телефонами.
// Вывод должен быть отсортирован по убыванию числа телефонов.
class TelBook{
    private static HashMap<String, List<String>> telBook = new HashMap<>();

    public void addNumber(String name, String number){
        if (telBook.containsKey(name)){
            List<String> value = new ArrayList<>(telBook.get(name));             ;
            value.add(number);
            telBook.put(name, value);
        }
        else {
            telBook.put(name,List.of(number));
        }
    }

    public static void printSortTelBook(){
        ArrayList<Map.Entry<String,ArrayList>> sortTelBook = new ArrayList(telBook.entrySet());
        sortTelBook.sort((o1, o2) -> o2.getValue().size() - o1.getValue().size());
        for (Map.Entry<String, ArrayList> item : sortTelBook){
            System.out.println(item.getKey() + ":" + item.getValue());
        }
    }
}

public class dz {
    public static void main(String[] args) {
        TelBook telbook = new TelBook();
        telbook.addNumber("Петров", "79819119294");
        telbook.addNumber("Петров", "79819111231");
        telbook.addNumber("Иванов", "79816574477");
        telbook.addNumber("Иванов", "79811235590");
        telbook.addNumber("Сидоров", "79819110000");
        telbook.addNumber("Иванов", "798191254322");
        telbook.addNumber("Петров", "79819111231");
        telbook.addNumber("Петров", "79819111231");
        telbook.addNumber("Сидоров", "79819111231");
        telbook.addNumber("Петров", "79819111231");
        telbook.addNumber("Власов", "79819111231");
        telbook.addNumber("Власов", "79819111231");
        telbook.printSortTelBook();
    }
}
