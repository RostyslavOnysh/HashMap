package HomeWork.EmployeeInfo;

import java.util.Objects;

    public class Employee {
        private String firstName;
        private String secondName;
        private int yearOfBirth;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getSecondName() {
            return secondName;
        }

        public void setSecondName(String secondName) {
            this.secondName = secondName;
        }

        public int getYearOfBirth() {
            return yearOfBirth;
        }

        public void setYearOfBirth(int yearOfBirth) {
            this.yearOfBirth = yearOfBirth;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Employee employee = (Employee) o;
            return yearOfBirth == employee.yearOfBirth
                    && Objects.equals(firstName, employee.firstName)
                    && Objects.equals(secondName, employee.secondName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(firstName, secondName, yearOfBirth);
        }

        @Override
        public String toString() {
            return "Employee{"
                    + "firstName='" + firstName + '\''
                    + ", secondName='" + secondName + '\''
                    + ", yearOfBirth=" + yearOfBirth
                    + '}';
        }
    }
