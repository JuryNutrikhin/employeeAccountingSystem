package dao;

import modul.Department;
import modul.Employee;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.List;

public class DaoClass implements DaoEmployee {
    private final String fileName = "Department.bin";
    public List<Employee> employees;


    public DaoClass() {
        try (FileInputStream fis = new FileInputStream(getFileName());
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            employees = (List<Employee>) ois.readObject();

        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public String getFileName() {
        return fileName;
    }



  //  public void setEmployees(List<Employee> employees) {
//        this.employees = employees;
 //   }

    @Override
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }


    @Override
    public void updateEmployee(int id, Employee employee) {
        employees.set(id, employee);

    }

    @Override
    public void deleteEmployee(int id,List<Employee> employees) {
        // employees.remove(id);
          System.out.println("Данные сотрудника под именем \"" +employees.remove(id).getName() + " \" удалены");


    }

    @Override
    public Employee searchEmployee(int id, List<Employee> employees) {
         return employees.stream()
                .filter(n -> employees.indexOf(n)==id)
                .findAny()
                .orElseThrow(() -> new NullPointerException("Сотрудника с таким именем нет"));
    }


    //..........................................
    @Override
    public void saveData() {
        try (FileOutputStream fos = new FileOutputStream(getFileName());
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(employees);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public boolean register(String nickname, String password,List<Employee> employees) {
        boolean bool = false;
        for (Employee user : employees) {
            if ((user.getNickName()).equals(nickname) && (user.getPassword()).equals(password)) {
                return bool = true;
            }
        }
        return bool;
    }

//    @Override
//    public Employee login(String nickname, String password,List<Employee> employees) {
//        Employee loginUser = null;
//        for (Employee user : employees) {
//            if ((user.getNickName()).equals(nickname) && (user.getPassword()).equals(password)) {
//                return loginUser = user;
//            }
//        }
//        return loginUser;
  //  }
    //............................................



    @Override
    public double reportAverageSalary(List<Employee > employees) {
      return   employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .getAsDouble();

    }

    @Override
    public void reportTop10Salary(List<Employee> employees) {
         employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .limit(10)
                .forEach(a -> System.out.println(a.getName() +" оплата "+a.getSalary()));


    }

    @Override
    public void reportTop10Employee(List<Employee> employees) {
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
             employees.stream()
                    .sorted(Comparator.comparing(Employee::getRecruitment))
                    .limit(10)
                    .forEach(a -> System.out.println(a.getName()+"   дата начала работы в организации   "+ formater.format(a.getRecruitment())));
    }



}
