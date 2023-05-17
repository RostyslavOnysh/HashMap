# HashMap

* What is Map ?
* HashMap Structure 
* Collision
* HashMap resize
* HasMap performance
* HasMap usage. Entry set

# What is HashMap?
Java HashMap is similar to *HashTable*, but it is unsynchronized. It allows to store the null keys as well, but there should be only one null key object and there can be any number of null values. This class makes no guarantees as to the order of the map. To use this class and its methods, you need to *import java.util.HashMap* package or its superclass.

### Create a HashMap object called capitalCities that will store String keys and String values:

```java 
import java.util.HashMap; // import the HashMap class
HashMap<String, String> capitalCities = new HashMap<String, String>();
```

# Add Items :

```java
import java.util.HashMap;

public class Main {
  public static void main(String[] args) {
    // Create a HashMap object called capitalCities
    HashMap<String, String> capitalCities = new HashMap<String, String>();

    // Add keys and values (Country, City)
    capitalCities.put("England", "London");
    capitalCities.put("Germany", "Berlin");
    capitalCities.put("Norway", "Oslo");
    capitalCities.put("USA", "Washington DC");
    System.out.println(capitalCities);
  }
}
```

# Access an Item : 
To access a value in the HashMap, use the *get()* method and refer to its key:

```java 
capitalCities.get("England");
```

In Java, *HashMap* is a part of Java’s collection since Java 1.2. This class is found in *java.util package*. It provides the basic implementation of the Map interface of Java. HashMap in Java stores the data in ***(Key, Value)*** pairs, and you can access them by an index of another type (e.g. an Integer). One object is used as a ***key (index) to another object (value)***. If you try to insert the duplicate key in HashMap, it will replace the element of the corresponding key. 

# Characteristics of HashMap:
A HashMap is a data structure that is used to store and retrieve values based on keys. Some of the key characteristics of a hashmap include:
* ***Fast access time:*** HashMaps provide constant time access to elements, which means that retrieval and insertion of elements are very fast, usually O(1) time complexity.
* ***Uses hashing function:*** HashMaps uses a hash function to map keys to indices in an array. This allows for a quick lookup of values based on keys.
* ***Stores key-value pairs:*** Each element in a HashMap consists of a key-value pair. The key is used to look up the associated value.
* ***Supports null keys and values:*** HashMaps allow for null values and keys. This means that a null key can be used to store a value, and a null value can be associated with a key.
* ***Not ordered:*** HashMaps are not ordered, which means that the order in which elements are added to the map is not preserved. However, LinkedHashMap is a variation of HashMap that preserves the insertion order.
* ***Allows duplicates:*** HashMaps allow for duplicate values, but not duplicate keys. If a duplicate key is added, the previous value associated with the key is overwritten.
* ***Thread-unsafe:*** HashMaps are not thread-safe, which means that if multiple threads access the same hashmap simultaneously, it can lead to data inconsistencies. If thread safety is required, ConcurrentHashMap can be used.
* ***Capacity and load factor:*** HashMaps have a capacity, which is the number of elements that it can hold, and a load factor, which is the measure of how full the hashmap can be before it is resized.


```java 
import java.util.HashMap;
  
public class ExampleHashMap {
   public static void main(String[] args) {
        
      // Create a HashMap
      HashMap<String, Integer> hashMap = new HashMap<>();
        
      // Add elements to the HashMap
      hashMap.put("John", 25);
      hashMap.put("Jane", 30);
      hashMap.put("Jim", 35);
        
      // Access elements in the HashMap
      System.out.println(hashMap.get("John")); // Output: 25
        
      // Remove an element from the HashMap
      hashMap.remove("Jim");
        
      // Check if an element is present in the HashMap
      System.out.println(hashMap.containsKey("Jim")); // Output: false
        
      // Get the size of the HashMap
      System.out.println(hashMap.size()); // Output: 2
   }
}
```

# Performance of HashMap
The performance of HashMap depends on 2 parameters which are named as follows:

* Initial Capacity
* Load Factor


* *Initial Capacity – It is the capacity of HashMap at the time of its creation (It is the number of buckets a HashMap can hold when the HashMap is instantiated). In java, it is 2^4=16 initially, meaning it can hold 16 key-value pairs.*

* *Load Factor – It is the percent value of the capacity after which the capacity of Hashmap is to be increased (It is the percentage fill of buckets after which Rehashing takes place). In java, it is 0.75f by default, meaning the rehashing takes place after filling 75% of the capacity.*

* *Threshold – It is the product of Load Factor and Initial Capacity. In java, by default, it is (16 * 0.75 = 12). That is, Rehashing takes place after inserting 12 key-value pairs into the HashMap.*

* *Rehashing – It is the process of doubling the capacity of the HashMap after it reaches its Threshold. In java, HashMap continues to rehash(by default) in the following sequence – 2^4, 2^5, 2^6, 2^7, …. so on.* 

If the initial capacity is kept higher then rehashing will never be done. But by keeping it higher increases the time complexity of iteration. So it should be chosen very cleverly to increase performance. The expected number of values should be taken into account to set the initial capacity. The most generally preferred load factor value is 0.75 which provides a good deal between time and space costs. The load factor’s value varies between 0 and 1. 

# Collision
В Java, колізія відноситься до ситуації, коли два або більше ключів у HashMap (або іншій хеш-таблиці) вказують на один і той же індекс (bucket) у внутрішньому масиві, де зберігаються значення, відповідні цим ключам. Такі ключі називаються колізійними ключами.
При спробі додати колізійний ключ в HashMap, його значення зберігається в списку, що містить усі значення, що були збережені під цим же індексом. Під час пошуку значення, яке відповідає ключу, який може бути колізійним, HashMap спочатку використовує хеш-функцію, щоб знайти потрібний індекс, а потім перевіряє усі значення в списку, які зберігаються під цим індексом, щоб знайти потрібне значення.
* ***Колізії можуть знижувати швидкість роботи HashMap***, тому що додатково потрібно виконувати пошук по списку, а не тільки по індексу. Щоб зменшити імовірність колізій, рекомендується використовувати хеш-функції, які розподіляють ключі рівномірно по всьому масиву. Також можна збільшити розмір масиву, щоб зменшити кількість колізій.

* Колізія строкових ключів : 

```java
Map<String, Integer> map = new HashMap<>();
map.put("apple", 1);
map.put("orange", 2);
map.put("banana", 3);
map.put("dog", 4);
map.put("god", 5);
```
У цьому прикладі, ключі "dog" та "god" мають однаковий хеш-код, тому вони вказують на той самий індекс у HashMap. Оскільки ключ "god" був доданий пізніше, він буде збережений в списку для цього індексу, тому пошук ключа "god" поверне значення 5, а не 4.

* Колізія ключів з власними реалізаціями хеш-функцій : 
```java 
class MyKey {
    private int id;
    
    public MyKey(int id) {
        this.id = id;
    }
    
    @Override
    public int hashCode() {
        return id % 2; // Завжди повертає 0 або 1
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyKey myKey = (MyKey) o;
        return id == myKey.id;
    }
}

Map<MyKey, String> map = new HashMap<>();
map.put(new MyKey(1), "one");
map.put(new MyKey(2), "two");
map.put(new MyKey(3), "three");
map.put(new MyKey(4), "four");
```
У цьому прикладі, реалізація хеш-функції для класу MyKey завжди повертає 0 або 1, залежно від того, чи є id парним або непарним числом. Це призводить до колізій, оскільки ключі з парними id та ключі з непарними id будуть мати однаковий хеш-код. У цьому прикладі, ключі з id=1 та id=3 вказують на той самий індекс у HashMap, тому другий ключ буде доданий до списку значень, що зберігаються за цим індексом.
