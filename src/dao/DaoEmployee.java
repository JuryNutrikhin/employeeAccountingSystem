package dao;

import modul.Department;
import modul.Employee;

import java.util.List;

public interface DaoEmployee {
    void addEmployee(Employee employee);

    void updateEmployee(int id, Employee employee);

    void deleteEmployee(int id,List<Employee> employees);

    Employee searchEmployee(int id, List<Employee> employees);//поиск сотрудника

    void saveData();//сохранение в фаил

    boolean register(String nickname, String password,List<Employee> employees);//принимает на вход логин с паролем.
    // Если уже существует юзер с таким именем, то возвращает false.
    // Иначе, создается новый пользователь с этими данными и кладётся в список и возвращается true.

 //   Employee login(String nickname, String password,List<Employee>employees);//- принимает на вход какой-то логин и пароль.
    // Если существует юзер с такими данными, то возвращает его, иначе возвращает null.

  //  void reportDepartment(Department department);//структура организации (информация об отделах, ФИО начальников отделов)

    double reportAverageSalary(List<Employee> employees);//средняя зарплата по организации и по отделам

    void reportTop10Salary(List<Employee> employees);//ТОП-10 самых дорогих сотрудников по зарплате

    void reportTop10Employee(List<Employee> employees);//ТОП-10 самых преданных сотрудников по количеству лет работы в организации.


}
