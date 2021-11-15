package Lab_3;
import java.util.ArrayList;
import java.io.IOException;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Accountant {

    public static void paySalary(Employee employee) {
        if (employee.getRole().equals(Employee.Role.STAFF) && employee.getGender().equals(Employee.Gender.FEMALE) )
            System.out.println(employee.getGivenName() + " получила зарплату в размере " + SalaryOfStaff);
        if (employee.getRole().equals(Employee.Role.MANAGER) && employee.getGender().equals(Employee.Gender.FEMALE) )
            System.out.println(employee.getGivenName() + " получила зарплату в размере " + SalaryOfManager);
        if (employee.getRole().equals(Employee.Role.EXECUTIVE) && employee.getGender().equals(Employee.Gender.FEMALE) )
            System.out.println(employee.getGivenName() + " получила зарплату в размере " + SalaryOfExecutive);

        if (employee.getRole().equals(Employee.Role.STAFF) && employee.getGender().equals(Employee.Gender.MALE) )
            System.out.println(employee.getGivenName() + " получил зарплату в размере " + SalaryOfStaff);
        if (employee.getRole().equals(Employee.Role.MANAGER) && employee.getGender().equals(Employee.Gender.MALE) )
            System.out.println(employee.getGivenName() + " получил зарплату в размере " + SalaryOfStaff);
        if (employee.getRole().equals(Employee.Role.EXECUTIVE) && employee.getGender().equals(Employee.Gender.MALE) )
            System.out.println(employee.getGivenName() + " получил зарплату в размере " + SalaryOfStaff);
    }

    public static void payPremium(Employee employee) {
        double coeffStaff = 0.1;
        double coeffManager = 0.2;
        double coeffExecutive = 0.3;

        if (employee.getRole().equals(Employee.Role.STAFF) && employee.getGender().equals(Employee.Gender.FEMALE) )
            System.out.println(employee.getGivenName() + " получила премию в размере " + SalaryOfStaff * coeffStaff);
        if (employee.getRole().equals(Employee.Role.MANAGER) && employee.getGender().equals(Employee.Gender.FEMALE) )
            System.out.println(employee.getGivenName() + " получила премию в размере " + SalaryOfManager * coeffManager);
        if (employee.getRole().equals(Employee.Role.EXECUTIVE) && employee.getGender().equals(Employee.Gender.FEMALE) )
            System.out.println(employee.getGivenName() + " получила премию в размере " + SalaryOfExecutive * coeffExecutive);

        if (employee.getRole().equals(Employee.Role.STAFF) && employee.getGender().equals(Employee.Gender.MALE) )
            System.out.println(employee.getGivenName() + " получил премию в размере " + SalaryOfStaff * coeffStaff);
        if (employee.getRole().equals(Employee.Role.MANAGER) && employee.getGender().equals(Employee.Gender.MALE) )
            System.out.println(employee.getGivenName() + " получил премию в размере " + SalaryOfStaff * coeffManager);
        if (employee.getRole().equals(Employee.Role.EXECUTIVE) && employee.getGender().equals(Employee.Gender.MALE) )
            System.out.println(employee.getGivenName() + " получил премию в размере " + SalaryOfStaff * coeffExecutive);
    }

    public static void consumerLE(ArrayList<Employee> emList) {
        Consumer<ArrayList<Employee>> greatestAge = (list) -> {
            int age = 0;
            for (Employee employee:list) {
                if (age < employee.getAge())
                    age = employee.getAge();
            }
            System.out.println("Самый большой возраст в компании равен " + age);
        };
        greatestAge.accept(emList);
    }

    public static Employee functionLE(ArrayList<Employee> emList) {
        Function<ArrayList<Employee>, Employee> bigestCode = (list) -> {
            int code = 0;
            EmployeeBuilder builder = new EmployeeBuilder();
            Employee em = builder.getResult();
            for (Employee employee: list) {
                if (code < employee.getCode()) {
                    code = employee.getCode();
                    em = employee;
                }
            }
            return em;
        };
        return bigestCode.apply(emList);
    }

    public static Employee.Gender supplierLE() {
        Supplier<Employee.Gender> getFemaleGender = () -> Employee.Gender.FEMALE;
        return getFemaleGender.get();
    }

    public static Boolean biPredicate(Employee employee, Employee.Gender gender) {
        BiPredicate<Employee, Employee.Gender> genderCheck = (em, gen) -> {
            if (employee.getGender().equals(gender))
                return true;
            return false;
        };
        return genderCheck.test(employee, gender);
    }



    public static void example(int quantity, Employee.Dept department) throws IOException {
       ArrayList<Employee> list = Employee.createShortList(quantity);

       for (int i = 0; i < list.size(); i++) {
           System.out.println(list.get(i));
       }

       System.out.println("\nВыплата премии женщинам сотрудникам:");
       Stream<Employee> stream1 = list.stream();
       stream1.filter(employee -> employee.getGender().equals(Employee.Gender.FEMALE)).forEach(Accountant::payPremium);

        System.out.println("\nВыплата зарплаты сотрудникам определенного департамента");
        Stream<Employee> stream2 = list.stream();
        if (department.equals(Employee.Dept.KRABOV)){
            stream2.filter(employee -> employee.getDept().equals(Employee.Dept.KRABOV)).forEach(Accountant::paySalary);
        }
        if (department.equals(Employee.Dept.LOGISTIC)){
            stream2.filter(employee -> employee.getDept().equals(Employee.Dept.LOGISTIC)).forEach(Accountant::paySalary);
        }
        if (department.equals(Employee.Dept.POSLEOBEDENNOGOSNA)){
            stream2.filter(employee -> employee.getDept().equals(Employee.Dept.POSLEOBEDENNOGOSNA)).forEach(Accountant::paySalary);
        }
        if (department.equals(Employee.Dept.VKUSNOYEDI)){
            stream2.filter(employee -> employee.getDept().equals(Employee.Dept.VKUSNOYEDI)).forEach(Accountant::paySalary);
        }

        System.out.println("\nВыплата премии сотрудникам старше 30, работающим в определенном департаменте ");
        Stream<Employee> stream3 = list.stream();
        if (department.equals(Employee.Dept.KRABOV)){
            stream3.filter(employee -> employee.getDept().equals(Employee.Dept.KRABOV) && employee.getAge() > 30).forEach(Accountant::paySalary);
        }
        if (department.equals(Employee.Dept.LOGISTIC)){
            stream3.filter(employee -> employee.getDept().equals(Employee.Dept.LOGISTIC) && employee.getAge() > 30).forEach(Accountant::paySalary);
        }
        if (department.equals(Employee.Dept.POSLEOBEDENNOGOSNA)){
            stream3.filter(employee -> employee.getDept().equals(Employee.Dept.POSLEOBEDENNOGOSNA) && employee.getAge() > 30).forEach(Accountant::paySalary);
        }
        if (department.equals(Employee.Dept.VKUSNOYEDI)){
            stream3.filter(employee -> employee.getDept().equals(Employee.Dept.VKUSNOYEDI) && employee.getAge() > 30).forEach(Accountant::paySalary);
        }

        System.out.println("\nВыплата зарплаты менеджерам");
        Stream<Employee> stream4 = list.stream();
        stream4.filter(employee -> employee.getRole().equals(Employee.Role.MANAGER)).forEach(Accountant::paySalary);

        System.out.println("\nВыплата премии стаффу");
        Stream<Employee> stream5 = list.stream();
        stream5.filter(employee -> employee.getRole().equals(Employee.Role.STAFF)).forEach(Accountant::payPremium);

        consumerLE(list);
        System.out.println(functionLE(list));
        System.out.println(supplierLE());
        System.out.println(biPredicate(list.get(0), Employee.Gender.MALE));

    }


    private static final int SalaryOfStaff = 35000;
    private static final int SalaryOfManager = 65000;
    private static final int SalaryOfExecutive = 120000;
}
