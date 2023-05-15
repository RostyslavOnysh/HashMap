package Theory.Collision;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Rectangle rec1 = new Rectangle(10, 20);
        Rectangle rec2 = new Rectangle(15, 30);
        Rectangle rec3 = new Rectangle(15, 30);

        Map<Rectangle, Integer> map = new HashMap<>();
        map.put(rec1, 100);
        map.put(rec2, 200);
        map.put(rec3,300);
        System.out.println(map.get(rec1));
        System.out.println(map.get(rec2));
        System.out.println(map.get(rec3));


    }
}
