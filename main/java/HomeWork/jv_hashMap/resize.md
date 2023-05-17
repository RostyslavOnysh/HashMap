### implementing a resize method that increases the map size and prevents collisions can be a good idea.
The resize method can be called within the put method or at an appropriate location when a certain threshold value for the number of elements in the map 
is reached (e.g., based on a load factor).
When invoked, the resize method can create a new larger array or another data structure to accommodate
a larger volume of data.

In addition to increasing the map size, the resize method can also rehash the elements to evenly
distribute them in the new data structure. 
This helps *prevent collisions* and improves the efficiency of read and write operations.
Implementing the resize method allows your map implementation to dynamically grow and adapt 
to changes in the amount of data, providing greater flexibility and efficiency.

### Here's a step-by-step guide for implementing the resize() method to avoid collisions:

* Check if the new capacity newCapacity exceeds MAX_CAPACITY.
If it does, stop the map expansion process as you have reached the maximum capacity.

* Create a new array of elements newTable with the size newCapacity.

* Iterate over all elements in the old array table and transfer them to the new array newTable.
Use the appropriate strategy to avoid collisions:

* If you are using open addressing, add elements with the same hash code to a linked list
for each array index.

* If you are using open addressing with chaining, add elements with the same hash code to a binary tree for each array index.

* Update the value of table to the new array newTable.

* Update the value of capacity to the new capacity newCapacity.

### These are general steps for implementing the resize() method to avoid collisions. 
### Depending on your specific map implementation and chosen collision avoidance strategy,
### there may be additional steps or nuances to con~~~~sider.













Так, написання методу resize, який буде збільшувати мапу і запобігати колізіям, може бути гарною ідеєю.
Метод resize може бути викликаний у методі put або в іншому відповідному місці,
коли досягнуто певного порогового значення для кількості елементів у мапі (наприклад, заснованого на факторі навантаження). 
При запуску resize він може створювати новий більший масив або іншу структуру даних для збереження більшого обсягу даних.
Окрім збільшення розміру мапи, resize також може перехешувати елементи,
щоб розподілити їх рівномірно в новій структурі даних. Це допоможе запобігти колізіям 
та покращити ефективність операцій зчитування та запису.

Написання методу resize дозволить вашій реалізації мапи динамічно збільшуватися та адаптуватися до змін
у кількості даних, що забезпечує більшу гнучкість та ефективність.


## При реалізації методу *resize()*, який допомагає уникати колізій, вам можна використовувати такі кроки:

* Перевірте, чи нова ємність *newCapacity* перевищує *MAX_CAPACITY*, якщо так,
  то зупиніть процес збільшення мапи, оскільки ви досягли максимальної ємності.
* Створіть новий масив елементів *newTable* з розміром *newCapacity*.
* Переберіть всі елементи в старому масиві *table* і перенесіть їх у новий масив *newTable*. 
 #### При цьому використовуйте відповідну стратегію для уникнення колізій:
* Якщо ви використовуєте ***відкрите зв'язування***, додайте елементи з однаковим hash code в зв'язаний список
  для кожного індексу масиву.
* Якщо ви використовуєте ***відкрите зв'язування з ланцюжками***, додайте елементи з однаковим hash code в
 бінарне дерево для кожного індексу масиву.
* Оновіть значення table на новий масив newTable.
* Оновіть значення capacity на нову ємність newCapacity.

#### Це загальна ідея для реалізації методу resize(), що допомагає уникати колізій. 
#### Залежно від вашої конкретної реалізації мапи та вибраної стратегії уникнення колізій, 
#### можуть бути додаткові кроки або нюанси.



