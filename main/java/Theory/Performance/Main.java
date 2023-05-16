package Theory.Performance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
      // Hashmap
     // Collision
    // Best and worst case
        User bob = new User("Bob", "Alison", 10);
        User alice = new User("Alice", "Jackson", 26);
        User john = new User("John", "Johnson", 43);
        User bill = new User("Bill", "Swason", 58);


       // User and count of friends
        Map<User, List<String>> usersFavouriteSubjects = new HashMap<>();
        usersFavouriteSubjects.put(bob,List.of("Math","Chemistry"));
        usersFavouriteSubjects.put(alice,List.of("Physics","Math"));
        usersFavouriteSubjects.put(john,List.of("Biology","Chemistry"));
        usersFavouriteSubjects.put(bill,List.of("Atr","Music"));

        // get value by key
        System.out.println(usersFavouriteSubjects.get(bob));
        System.out.println(usersFavouriteSubjects.get(alice));
        System.out.println(usersFavouriteSubjects.get(john));
        System.out.println(usersFavouriteSubjects.get(bill));

    }
}
