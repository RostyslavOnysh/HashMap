# How does the put(K key, V value) method work?

### The ***put(K key, V value)*** method in HashMap is used to *insert* or *update* an entry in the map. Here's how it works:

* The put method takes ***two parameters: key of type K and value of type V.*** The key represents the unique identifier 
for the entry, while the value represents the associated data.

* When you call ***put(key, value)***, the HashMap implementation calculates the hash code of the key using its 
hashCode() method.

* The hash code is then used to determine the index in the underlying array ~~~~where the entry will be stored.
This process is called hashing.

* If the calculated index is empty, meaning there are no entries at that index yet, the key-value pair is stored directly 
at that index.

* If the calculated index already contains one or more entries, a *collision occurs*. In this case, the entries at that index
are stored in a linked list or a balanced tree (depending on the implementation) to handle multiple entries with the same index.

* The HashMap implementation then checks if the key already exists in the map. If it does,
the associated value is updated with the new value provided in the method call.

* If the key doesn't exist in the map, a new entry is created with the given key and value and added to the appropriate index in the 
underlying array or linked list/tree.

* If the entry being inserted causes the number of entries in the map to exceed the load factor threshold, the internal capacity of the map is increased, 
and the entries are rehashed to distribute them evenly across the expanded array.

* That's the basic functionality of the put method in HashMap. It allows you to add or update key-value pairs in the map,
ensuring efficient retrieval and storage based on the calculated hash codes.


# Here is a step-by-step guide for creating your custom method put(K key, V value):

* Define your own class or a class that extends an existing map class, such as CustomMap, and specify the parameterized types K and V.

* Add a public method put(K key, V value) to this class so that it can be called externally.

* In the body of the put method, perform the necessary actions for adding or updating elements in the map:

* Accept parameters key of type K and value of type V.

* Implement the logic for inserting or updating the key-value pair in your own map implementation.

* Consider the specifics of your implementation, such as handling collisions, storing elements in internal data structures, resizing the array, etc.

* Consider how the existence of the key will be detected and how the value will be updated or a new value will be inserted.

* Don't forget to consider the appropriate return type for the put method. For example, you may return the previous value if the element was updated or null if a new element was added.

* Use your own map implementation to call the put method and verify its functionality.

* Note that this is a general guide, and depending on your own map class or specific requirements, there may be additional details or nuances to implement the put method.

# *Hint* : 
It would be a good idea to start by writing a resize method that helps the map to grow when needed and prevent collisions. 
This method can also rehash the elements to distribute them evenly in the new data structure.
This will help prevent collisions and improve the efficiency of read and write operations.

# Метод put(K key, V value) в HashMap використовується для додавання або оновлення елемента у мапі. Ось як це працює:

Метод put приймає два параметри: ключ типу K та значення типу V. Ключ представляє унікальний ідентифікатор елемента,
а значення представляє пов'язані дані.

При виклику put(key, value) реалізація HashMap обчислює хеш-код ключа за допомогою методу hashCode().

Хеш-код використовується для визначення індексу в базовому масиві, де буде збережено елемент.
Цей процес називається хешуванням.

Якщо обчислений індекс порожній, що означає, що на цьому індексі ще немає жодного елемента, 
пара ключ-значення зберігається безпосередньо на цьому індексі.

Якщо обчислений індекс вже містить один або кілька елементів, виникає колізія. 
У цьому випадку елементи на цьому індексі зберігаються у зв'язаному списку або збалансованому дереві
(залежно від реалізації) для обробки кількох елементів з однаковим індексом.

Реалізація HashMap перевіряє, чи ключ вже існує в мапі. 
Якщо так, пов'язане значення оновлюється з новим значенням, переданим у виклику методу.

Якщо ключ не існує у мапі, створюється новий елемент з заданим ключем та значенням
і додається до відповідного індексу в базовому масиві або зв'язаному списку/дереву.

Якщо доданий елемент призводить до перевищення порогового значення фактору заповнення, 
внутрішня ємність мапи збільшується, а елементи перехешовуються для рівномірного розподілу по розширеному масиву.

Ось основна функціональність методу put у HashMap. Він дозволяє додавати 
або оновлювати пари ключ-значення в мапі, забезпечуючи ефективне отримання та збереження на основі обчислених хеш-кодів.
