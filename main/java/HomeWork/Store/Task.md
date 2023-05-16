### Let's work as a store accountant.

* Our store is the best in the area, so we may run out of goods very quickly.
We decided to order each of the units of goods, and now we are waiting for delivery.

* Let's implement the method public Map<String, Integer> supplyFruits(Map<String, Integer> storage, int supply) which will update our stock to the actual quantity of goods.

### Method parameters:

* *Map<String, Integer> storage* - the current number of products in stock.
* *int supply* - the number of units of a new product.

***Example:***
Our storage look like this:
```java
 storage = {
"Apple" = 10,
"Orange" = 20,
...
}
```

We ordered 10 units of each product:
int supply = 10;

Method ***supplyFruits(...)*** should return new storage:
```java
storage = {
"Apple" = 20,
"Orange" = 30,
...
}
```

Це завдання я буду вирішувати використовуючи цикл ***Foreach*** для початку.
Для кожного товару ми отримуємо поточну кількість товару,
додаємо до неї значення ***supply*** (кількість одиниць нового товару) і оновлюємо цю кількість в ***storage***.
Нарешті, ми повертаємо оновлений storage як результат виконання методу ***supplyFruits***.


# Third soling explanation :

```java
for (Map.Entry<String, Integer> fruit : storage.entrySet()) {
fruit.setValue(fruit.getValue() + supply);
}
return storage;
}
```
Inside the supplyFruits method, we iterate over each entry ***(Map.Entry<String, Integer> fruit)*** in the storage map using a for-each loop.
For each entry, we use the ***setValue*** method to update the value (quantity) of the fruit.
We retrieve the current value using ***fruit.getValue()***, add the supply to it,
and set the updated value back to the entry using ***fruit.setValue(updatedValue)***.
By modifying the values directly within the storage map using the ***setValue*** method,
we achieve the desired update of the fruit quantities without explicitly using the put method.
Finally, we return the updated storage map.
This updated code simplifies the logic by directly modifying the values of the storage map entries, making it more concise and readable.