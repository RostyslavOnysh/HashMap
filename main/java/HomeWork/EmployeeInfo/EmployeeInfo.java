package HomeWork.EmployeeInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmployeeInfo {
    public List<Employee> getEmployeesByCityAndYearOfBirth(
            Map<Employee, String> employeesInformation, int yearOfBirth, String city) {
        List<Employee> employeeList = new ArrayList<>();
        for (Map.Entry<Employee, String> employee : employeesInformation.entrySet()) {
            if (employee.getKey().getYearOfBirth() >= yearOfBirth) {
                if (employee.getValue().equals(city)) {
                    employeeList.add(employee.getKey());
                }
            }
        }
        return employeeList;
    }
}
