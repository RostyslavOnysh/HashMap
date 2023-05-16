package Theory.resize;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> flats = new HashMap<>();

        flats.put(17, "John");      // 17  % 16  = 1
        flats.put(8, "Bob");       // 8 % 16 = 8
        flats.put(35, "Alice");   // 35 % 16 = 3
        flats.put(43, "Artem");  // 43 % 16 = 11
        flats.put(56, "Anna");  // 56 % 16 = 8
        flats.put(62, "Dima"); // 62 % 16 = 14
        flats.put(77, "Kate"); // 77 % 16 = 13
        flats.put(89, "Oleg"); // 89 % 16 = 9
        flats.put(105, "Roman"); // 17 % 16 =9
    }
}
