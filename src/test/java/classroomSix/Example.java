package classroomSix;

import com.github.javafaker.Faker;

public class Example {
    public static void main(String[] args) {
        System.out.println("this is mawen project");
        Employee employeeOne = new Employee("Janis Berzins", "Šefs", 3434);
        System.out.println(employeeOne.toString());
        Faker fakerObjektaNosaukums = new Faker();
        Employee employeeTwo = new Employee(fakerObjektaNosaukums.name().firstName(), fakerObjektaNosaukums.company().profession(), fakerObjektaNosaukums.number().randomDouble(2, 100, 2000));
        System.out.println(employeeTwo.toString());
        System.out.println(fakerObjektaNosaukums.name().firstName());
        System.out.println(fakerObjektaNosaukums.name().lastName());
        System.out.println(fakerObjektaNosaukums.company().profession());
        System.out.println(fakerObjektaNosaukums.company().industry());
        System.out.println(fakerObjektaNosaukums.animal().name());
        System.out.println(fakerObjektaNosaukums.avatar().image());

        Employee employeeThree = new Employee();
        System.out.println(employeeThree);
        for (int i = 0; i < 100; i++) {
            Employee employee = new Employee();
            System.out.println(employee.toString());
        }

        // uztaisit ciklu, kas uztaisis 100 jaunus employees un katru izvadis uz ekrana.



    }
}
