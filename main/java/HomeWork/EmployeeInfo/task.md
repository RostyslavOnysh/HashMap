Let's implement method
public List<Employee>getEmployeesByCityAndYearOfBirth(Map<Employee, String> employeesInformation, int yearOfBirth, String city) 
which will return the list of employees according to the specified parameters.

# You should find all employees who:

* *int yearOfBirth* - were born in the specified year, or later.
* *String city* - work in the specified city.

Employee information is contained in HashMap<Employee, String> employeesInformation, 
where the ***key*** is the employee, and the ***value*** is the city in which he works.