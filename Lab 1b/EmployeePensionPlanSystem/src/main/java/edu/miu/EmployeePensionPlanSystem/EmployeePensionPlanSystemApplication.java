package edu.miu.EmployeePensionPlanSystem;

import com.google.gson.*;
import edu.miu.EmployeePensionPlanSystem.domain.Employee;
import edu.miu.EmployeePensionPlanSystem.domain.PensionPlan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

@SpringBootApplication
public class EmployeePensionPlanSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeePensionPlanSystemApplication.class, args);

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Daniel", "Agar", LocalDate.of(2022, 1, 17), 105945.50));
        employees.add(new Employee(2, "Benard", "Shaw", LocalDate.of(2018, 10, 03), 197750.00));
        employees.add(new Employee(3, "Carly", "Agar", LocalDate.of(2014, 5, 16), 842000.75));
        employees.add(new Employee(4, "Wesley", "Schneider", LocalDate.of(2018, 11, 02), 74500.00));

        List<PensionPlan> pensionPlans = new ArrayList<>();
        pensionPlans.add(new PensionPlan("EX1089", LocalDate.of(2023, 1, 17), 100.00));
        pensionPlans.add(new PensionPlan(null, null, 0.0));
        pensionPlans.add(new PensionPlan("SM2307", LocalDate.of(2019, 11, 4), 1555.50));
        pensionPlans.add(new PensionPlan(null, null, 0.0));

        printEmployeeList(employees);
        generateMonthlyUpcomingEnrollmentReport(employees, pensionPlans);

    }

    public static void printEmployeeList(List<Employee> employees) {

        employees.sort(Comparator.comparing(Employee::getLastName).thenComparing(Employee::getYearlySalary).reversed());

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
                .setPrettyPrinting()
                .create();
        String json = gson.toJson(employees);
        System.out.println("List of Employees............................");
        System.out.println(json);
    }

    public static void generateMonthlyUpcomingEnrollmentReport(List<Employee> employees, List<PensionPlan> pensionPlans) {

        List<Employee> newEnrollments = new ArrayList<>();
        for (Employee employee : employees) {
            if ((Period.between(employee.getEmploymentDate(), LocalDate.now().plusMonths(1).withDayOfMonth(1)).getYears() >= 5 ||
                    Period.between(employee.getEmploymentDate(), LocalDate.now().plusMonths(1).withDayOfMonth(LocalDate.now().plusMonths(1).withDayOfMonth(1).lengthOfMonth())).getYears() >= 5)) {
                if (employee.getPensionPlan() == null) {
                    newEnrollments.add(employee);
                }
            }
        }
        newEnrollments.sort(Comparator.comparing(Employee::getEmploymentDate));

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
                .setPrettyPrinting()
                .create();

        String json = gson.toJson(newEnrollments);
        System.out.println("\nMonthly Upcoming enrollment report..................");
        System.out.println(json);
    }

    private static class LocalDateTypeAdapter implements JsonSerializer<LocalDate>, JsonDeserializer<LocalDate> {
        @Override
        public JsonElement serialize(LocalDate src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(src.toString());
        }

        @Override
        public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            return LocalDate.parse(json.getAsString());
        }
    }
}


