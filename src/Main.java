import java.util.*;

public class Main {
    private static final int DEPARTMENT_SIZE = 5;
    private static final int EMPLOYEES_SIZE = 10;

    private static final EmployeeBook EMPLOYEE_BOOK = new EmployeeBook();


    public static void main(String[] args) throws Exception {

        Main.initialEmployees();

        System.out.println(Arrays.toString(EMPLOYEE_BOOK.getEmployees()));
        System.out.printf("Затраты на зарплаты в месяц: %s%n", EMPLOYEE_BOOK.getAmountSalaryEmployees());
        System.out.printf("Сотрудник с минимальной зарплатой: %s%n", EMPLOYEE_BOOK.getEmployeeWithMinimumSalary());
        System.out.printf("Сотрудник с максимальной зарплатой: %s%n", EMPLOYEE_BOOK.getEmployeeWithMaximumSalary());
        System.out.printf("Среднее значение зарплат: %s%n", EMPLOYEE_BOOK.getAvgSalary());
        System.out.printf("Ф. И. О. всех сотрудников: %s%n", Arrays.toString(EMPLOYEE_BOOK.getFullNameEmployees()));

        EMPLOYEE_BOOK.indexSalaryByPercentage(.25);
        System.out.println();
        System.out.printf("Сотрудник с минимальной зарплатой: %s%n", EMPLOYEE_BOOK.getEmployeeWithMinimumSalary());
        System.out.printf("Сотрудник с максимальной зарплатой: %s%n", EMPLOYEE_BOOK.getEmployeeWithMaximumSalary());

        System.out.println("Повышенная сложность");
        int workDepartment = 1;
        System.out.printf(
                "Сотрудник с минимальной зарплатой: %s%n",
                EMPLOYEE_BOOK.getEmployeeWithMinimumSalaryByDepartment(workDepartment)
        );
        System.out.printf(
                "Сотрудник с максимальной зарплатой: %s%n",
                EMPLOYEE_BOOK.getEmployeeWithMaximumSalaryByDepartment(workDepartment)
        );

        System.out.printf(
                "Затраты на зарплаты в месяц: %s, по департаменту №%s%n",
                EMPLOYEE_BOOK.getAmountSalaryEmployeesByDepartment(workDepartment),
                workDepartment
        );

        System.out.printf(
                "Среднее значение зарплат: %s, по департаменту №%s%n",
                EMPLOYEE_BOOK.getAvgSalary(workDepartment),
                workDepartment
        );

        float indexPercent = .5f;
        EMPLOYEE_BOOK.indexSalaryDepartmentByPercentage(workDepartment, indexPercent);
        EMPLOYEE_BOOK.printDepartmentEmployees(EMPLOYEE_BOOK.getEmployeesByDepartment(workDepartment));

        System.out.println();

        EMPLOYEE_BOOK.printExternalEmployees(EMPLOYEE_BOOK.getEmployeesWithLessSalaryByNumber(480));
        EMPLOYEE_BOOK.printExternalEmployees(EMPLOYEE_BOOK.getEmployeesWithGreaterThanSalaryByNumber(480));

        Employee employee = EMPLOYEE_BOOK.getEmployeeByFullName("Сотрудник 1");
        System.out.printf(
                "%n ФИО сотрудника в обработке: %s",
                employee.getFullName()
        );
        System.out.printf(
                "%n Запралата до манипуляций: %s",
                employee.getSalary()
        );
        System.out.printf(
                "%n Отдел до манипуляций: %s",
                employee.getDepartment()
        );

        double newSalary = 10;
        int newDepartmentNum = 10;
        EMPLOYEE_BOOK.changeSalaryEmployeeByFullName(employee.getFullName(), newSalary);
        EMPLOYEE_BOOK.changeDepartmentEmployeeByFullName(employee.getFullName(), new Department(newDepartmentNum));

        // Добавим доп пользователя в отдел №10
        EMPLOYEE_BOOK.add(
                new Employee(
                        String.format("Сотрудник %s", 101),
                        new Department(newDepartmentNum),
                        1
                )
        );


        System.out.printf(
                "%n Запралата после манипуляций: %s",
                employee.getSalary()
        );
        System.out.printf(
                "%n Отдел после манипуляций: %s",
                employee.getDepartment()
        );

        System.out.println();
        System.out.println(
                Arrays.toString(EMPLOYEE_BOOK.getEmployeeNamesByDepartment(newDepartmentNum))
        );
    }

    private static void initialEmployees() {

        for (int i = 0; i < EMPLOYEES_SIZE; i++) {
            int baseNum = i + 1;
            EMPLOYEE_BOOK.add(new Employee(
                    String.format("Сотрудник %s", baseNum),
                    new Department(baseNum % Main.DEPARTMENT_SIZE),
                    baseNum * 100
            ));
        }
    }


}