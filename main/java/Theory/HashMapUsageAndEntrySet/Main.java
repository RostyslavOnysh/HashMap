package Theory.HashMapUsageAndEntrySet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static Map<User, List<String>> userFavouriteSubjects = new HashMap<>();

    public static void main(String[] args) {

        User bob = new User("Bob", "Alicon", 10);
        User alice = new User("Alice", "Jackson", 26);
        User john = new User("John", "Johnson", 42);
        User bill = new User("Bill", "Swason", 58);


        userFavouriteSubjects.put(bob, List.of("Math", "Chemistry"));
        userFavouriteSubjects.put(alice, List.of("Physics", "Math"));
        userFavouriteSubjects.put(john, List.of("Biology", "Chemistry"));
        userFavouriteSubjects.put(bill, List.of("Art", "Music"));

       // System.out.println(getFavoutireSubject("Alice"));
       // System.out.println(getUsersBySubjects("Art"));

        for(Map.Entry<User,List<String>> entry : userFavouriteSubjects.entrySet()){
            System.out.println("User :" + entry.getKey().getName() + ", Subjects : " + entry.getValue());
        }
    }

    private static List<String> getFavoutireSubject(String username) {
        for (Map.Entry<User, List<String>> entry : userFavouriteSubjects.entrySet()) {
            if (entry.getKey().getName().equals(username)) {
                return entry.getValue();
            }
        }
        return Collections.emptyList();
    }

    private static List<User> getUsersBySubjects(String subject) {
        List<User> users = new ArrayList<>();
        for (Map.Entry<User,List<String>> entry : userFavouriteSubjects.entrySet()){
            if  (entry.getValue().contains(subject)){
                users.add(entry.getKey());
            }
        }
        return users;
    }
}
