Let's implement method
public List<Employee>getEmployeesByCityAndYearOfBirth(Map<Employee, String> employeesInformation, int yearOfBirth, String city) 
which will return the list of employees according to the specified parameters.

# You should find all employees who:

* *int yearOfBirth* - were born in the specified year, or later.
* *String city* - work in the specified city.

Employee information is contained in HashMap<Employee, String> employeesInformation, 
where the ***key*** is the employee, and the ***value*** is the city in which he works.

### задача була виконана в декілька кроків : 
 * я створив лист в який буду додавати працівників які відповідають всім вимогам.(Це рік народження та місто).
 * ***for (Map.Entry<Employee, String> employee : employeesInformation.entrySet())***
      Використовую цикл для того щоб перебрати всі записи.
   ***кожен запис містить об'єкти типу Employee як *ключ* та *рядок* і місто як значення***
 * ***employee.getKey().getYearOfBirth()***
     За допомогою *getKey()* ми отримуємо об'єкт типу *Employee (ключ)* з поточного запису. 
     Після цього викликається метод *getYearOfBirth()*, щоб отримати рік народження працівника.
* ***if (employee.getKey().getYearOfBirth() >= yearOfBirth)***: 
     Умова перевіряє, чи рік народження працівника більший або рівний ***yearOfBirth***,
     який був переданий в метод як параметр. Якщо ця умова виконується, 
     ми переходимо до наступного рівня умов.
* ***employee.getValue().equals(city)***:
     За допомогою ***getValue()*** ми отримуємо значення *(місто)*,
     яке відповідає поточному запису. Ми порівнюємо його з *city*, 
     яке було передано в метод як параметр, використовуючи метод *equals()*.
     Ця умова перевіряє, чи місто працівника збігається з вказаним містом.
* Якщо обидві умови виконуються, ми доходимо до внутрішнього блоку коду.
* ***employeeList.add(employee.getKey())***: Цей рядок додає працівника *(employee.getKey())* до *employeeList*,
     який був створений на початку методу. Це означає, що працівник відповідає умовам по році народження та місту, 
     тому ми додаємо його до списку.
* Після завершення циклу, ми повертаємо список *employeeList*, який містить всі працівники, що відповідають заданим умовам.
* Отже, цей блок коду перебирає записи у employeesInformation, перевіряє умови року народження та міста для кожного працівника і додає працівників, 
     що відповідають умовам, до employeeList.

 # Чому ми використовуємо Map.Entry<Employee,String> employee.Та навіщо взагалі така команда

1. Використання **Map.Entry<Employee, String>** у цьому контексті дозволяє нам отримати доступ до об'єктів **Employee (ключі)** та рядків (значення) 
з кожного запису employeesInformation.

2. ***Map.Entry*** є внутрішнім інтерфейсом в Java, який представляє пару ключ-значення в мапі (в даному випадку, у employeesInformation).
Використання *Map.Entry<Employee, String>* означає, що кожен запис мапи буде представлений як об'єкт *Map.Entry*,
де ключом є об'єкт типу *Employee*, а значенням є рядок (String).

3. Отримання запису ***Map.Entry<Employee, String>*** забезпечує нам доступ до *ключа (об'єкта Employee)* та *значення (рядка)*,
пов'язаних з кожним записом у мапі. Таким чином, ми можемо отримати рік народження працівника ***(employee.getKey().getYearOfBirth())***
та місто, де він працює ***(employee.getValue())***, щоб перевірити умови задачі.
4. Коротше кажучи, використання ***Map.Entry<Employee, String>***~~~~ дозволяє нам отримати доступ до ключа (об'єкта Employee) 
   та значення (рядка) кожного запису у мапі employeesInformation.