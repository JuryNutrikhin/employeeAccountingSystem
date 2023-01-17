import modul.Employee;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Employee> em = new ArrayList<>();
        em.add(new Employee("Nick","11111","Bob",24051982,221211,"руководитель","Производство",100000)) ;
        em.add(new Employee("Nick1","11112","Ann",22051982,231211,"специалист","Производство",60000)) ;
        em.add(new Employee("Nick2","11113","Den",20051982,241211,"работник","Производство",30000)) ;
        em.add(new Employee("Nick3","11114","Pit",24061982,251211,"руководитель","Бухгалтерия",90000)) ;
        em.add(new Employee("Nick4","11115","Elli",24081982,621211,"специалист","Бухгалтерия",50000)) ;
        em.add(new Employee("Nick5","11116","Katy",24051992,721211,"работник","Бухгалтерия",40000)) ;
        em.add(new Employee("Nick6","11117","Edd",24051972,228211,"руководитель","Отдел продаж",80000)) ;
        em.add(new Employee("Nick7","11118","Sem",24091982,229211,"специалист","Отдел продаж",55000)) ;
        em.add(new Employee("Nick8","11119","Li",24051981,221201,"работник","Отдел продаж",30000)) ;
        em.add(new Employee("Nick9","111110","Jhon",24051982,331211,"руководитель","Отдел продаж",70000)) ;

        try (FileOutputStream fos = new FileOutputStream("Department.bin");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(em);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
