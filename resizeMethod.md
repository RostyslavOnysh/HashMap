## Якщо буде потреба перероби цей код в метод та гарно його оформи !

Цей код відповідає за зміну розміру ***(resize) хеш-таблиці*** в класі, який містить цей код. Основна мета зміни розміру полягає в збільшенні або зменшенні розміру масиву table, який використовується для зберігання елементів хеш-таблиці.
Основні кроки, які виконуються у цьому коді:

* Копіюється посилання на поточний масив *table* у змінну *oldTab*, і отримується поточний розмір *oldCap* (кількість елементів у table) та поріг *oldThr* (поріг, за яким відбувається збільшення розміру таблиці).
* Перевіряється, чи поточний розмір *oldCap* більший за 0. Якщо так, перевіряється, чи *oldCap* досягнув максимально допустимого значення ***MAXIMUM_CAPACITY***. Якщо так, поріг *threshold* встановлюється на максимальне значення ***Integer.MAX_VALUE***, і масив oldTab повертається без змін.
* Якщо поточний розмір *oldCap* не досяг максимального значення, обчислюється новий розмір *newCap*, який є подвоєнням поточного розміру. Якщо *newCap* менше ***MAXIMUM_CAPACITY*** і *oldCap* більше або рівний ***DEFAULT_INITIAL_CAPACITY***, поріг *newThr* також подвоюється.
* Якщо поточний розмір *oldCap* = 0, перевіряється, чи поріг *oldThr*  більший за 0. Якщо так, новий розмір newCap встановлюється на значення *oldThr*.
* Якщо жодна з умов попередніх кроків не виконується, встановлюються значення за замовчуванням: *newCap* дорівнює ***DEFAULT_INITIAL_CAPACITY***, а *newThr* обчислюється на основі ***DEFAULT_LOAD_FACTOR*** та ***DEFAULT_INITIAL_CAPACITY***.
* Якщо значення *newThr* дорівнює 0, обчислюється новий поріг *newThr* на основі *newCap* та фактору навантаження *(loadFactor)*. Якщо *newCap* менше ***MAXIMUM_CAPACITY*** і добуток *newCap* і *loadFactor* менше ***MAXIMUM_CAPACITY***, то *newThr* встановлюється рівним цьому добутку. У протилежному випадку, *newThr* встановлюється на максимальне значення ***Integer.MAX_VALUE***.
* Змінна *threshold* оновлюється значенням *newThr*.
* Створюється новий масив ***newTab типу Node<K, V>[] з розміром newCap***. Застосовується підтипізація, оскільки без підтипізації неможливо створити масив з параметризованими типами.
* Змінна ***table*** оновлюється посиланням на новостворений масив *newTab*.
* Якщо *oldTab* не є нульовим, виконується цикл for для кожного індексу ***j*** у межах *oldCap*.
* Усередині циклу перевіряється, чи елемент *e (Node)* за індексом ***j*** масиву *oldTab* не є нульовим.
* Якщо елемент ***e*** не є нульовим, спочатку встановлюється нульове значення для *oldTab[j]*, а потім виконується перевірка.
* Якщо *e.next* дорівнює нулю, елемент ***e*** просто присвоюється до *newTab[e.hash & (newCap - 1)]*. Застосовується побітове *AND* для отримання індексу в новому масиві *newTab*.
* Якщо ***e*** є екземпляром класу *TreeNode*, викликається метод *split(this, newTab, j, oldCap)*. Цей метод виконує спеціальну логіку розділення дерева випадків, коли вузли з одним індексом можуть мати різні хеш-коди.
* У протилежному випадку, коли не виконується жодна з попередніх умов, елементи розподіляються між двома списками *loHead та hiHead*. Залежно від хеш-коду кожного елемента ***e***, він додається до списку *loHead або hiHead*.
* У *циклі do-while* виконується перенесення елементів зі старого списку до нового списку. Кожен елемент переноситься за допомогою змінної *next*. Якщо хеш-код ***e*** в старому масиві *oldTab* дорівнює 0, то елемент ***e*** додається до списку *loHead* та оновлюється *loTail*. В іншому випадку, елемент ***e*** додається до списку *hiHead* та оновлюється *hiTail*.
* Цей процес повторюється, доки ***e*** не стане *null*, тобто всі елементи зі старого списку були перенесені до нових списків *loHead та hiHead*.
* Після цього перевіряється, чи *loTail* не є нульовим. Якщо так, останній елемент *loTail* встановлює *next* в нульове значення, а *loHead* стає першим елементом списку за індексом ***j*** у новому масиві *newTab*.
* Аналогічно, перевіряється, чи *hiTail* не є нульовим. Якщо так, останній елемент *hiTail* встановлює *next* в нульове значення, а *hiHead* стає першим елементом списку за індексом ***j + oldCap*** у новому масиві *newTab*.
* Після проходу через усі індекси ***j*** старого масиву *oldTab*, новий масив *newTab* стає оновленим і повертається як результат зміни розміру хеш-таблиці.

```java 
    /**
     * Initializes or doubles table size.  If null, allocates in
     * accord with initial capacity target held in field threshold.
     * Otherwise, because we are using power-of-two expansion, the
     * elements from each bin must either stay at same index, or move
     * with a power of two offset in the new table.
     *
     * @return the table
     */
    final Node<K,V>[] resize() {
        Node<K,V>[] oldTab = table;
        int oldCap = (oldTab == null) ? 0 : oldTab.length;
        int oldThr = threshold;
        int newCap, newThr = 0;
        if (oldCap > 0) {
            if (oldCap >= MAXIMUM_CAPACITY) {
                threshold = Integer.MAX_VALUE;
                return oldTab;
            }
            else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                     oldCap >= DEFAULT_INITIAL_CAPACITY)
                newThr = oldThr << 1; // double threshold
        }
        else if (oldThr > 0) // initial capacity was placed in threshold
            newCap = oldThr;
        else {               // zero initial threshold signifies using defaults
            newCap = DEFAULT_INITIAL_CAPACITY;
            newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
        }
        if (newThr == 0) {
            float ft = (float)newCap * loadFactor;
            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                      (int)ft : Integer.MAX_VALUE);
        }
        threshold = newThr;
        @SuppressWarnings({"rawtypes","unchecked"})
        Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
        table = newTab;
        if (oldTab != null) {
            for (int j = 0; j < oldCap; ++j) {
                Node<K,V> e;
                if ((e = oldTab[j]) != null) {
                    oldTab[j] = null;
                    if (e.next == null)
                        newTab[e.hash & (newCap - 1)] = e;
                    else if (e instanceof TreeNode)
                        ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
                    else { // preserve order
                        Node<K,V> loHead = null, loTail = null;
                        Node<K,V> hiHead = null, hiTail = null;
                        Node<K,V> next;
                        do {
                            next = e.next;
                            if ((e.hash & oldCap) == 0) {
                                if (loTail == null)
                                    loHead = e;
                                else
                                    loTail.next = e;
                                loTail = e;
                            }
                            else {
                                if (hiTail == null)
                                    hiHead = e;
                                else
                                    hiTail.next = e;
                                hiTail = e;
                            }
                        } while ((e = next) != null);
                        if (loTail != null) {
                            loTail.next = null;
                            newTab[j] = loHead;
                        }
                        if (hiTail != null) {
                            hiTail.next = null;
                            newTab[j + oldCap] = hiHead;
                        }
                    }
                }
            }
        }
        return newTab;
    }

```

### Цей код виконує процес зміни розміру хеш-таблиці з одного розміру на інший, перерозподіляючи елементи зі старого масиву до нового масиву на відповідні позиції. Це дозволяє забезпечити більш ефективне розподілення елементів, зменшуючи колізії та покращуючи час доступу до елементів. Крім того, код також враховує спеціальні випадки, такі як досягнення максимального розміру хеш-таблиці та розподілення елементів у випадку, коли вони мають різні хеш-коди.
