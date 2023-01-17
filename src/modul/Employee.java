package modul;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee implements Serializable {
    private  String nickName;
    private  String password;
    private  static int EMPLOYEE_COUNT ;
    private  int  id= EMPLOYEE_COUNT++;//?
    private   String name;
    private    int birthday;
    private int telefon;
    private String  position;//должность
    private String department;//название отдела
    private  Date recruitment;// дата приема на работу
    private  int  salary;//зарплата


    public Employee(String nickName, String password, String name, int birthday, int telefon, String position,
                    String department, int salary) {
        this.nickName = nickName;
        this.password = password;
        this.id = EMPLOYEE_COUNT++;
        this.name = name;
        this.birthday = birthday;
        this.telefon = telefon;
        this.position = position;
        this.department = department;
       // this.idChief = idChief;
        this.recruitment = new Date();
        this.salary = salary;
    }

    public static int getEmployeeCount() {
        return EMPLOYEE_COUNT;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBirthday() {
        return birthday;
    }

    public Date getRecruitment() {
        return recruitment;
    }

    public String getNickName() {
        return nickName;
    }

    public String getPassword() {
        return password;
    }

    public int getTelefon() {
        return telefon;
    }

    public String getPosition() {
        return position;
    }

    public String getDepartment() {
        return department;
    }



    public int getSalary() {
        return salary;
    }


    @Override
    public String toString() {

        SimpleDateFormat formatForDateNow = new SimpleDateFormat("E yyyy.MM.dd 'и время' hh:mm:ss a zzz");
        String d = formatForDateNow.format(recruitment);

        return "\n\nДанные сотрудника :" +
                "\n логин'" + nickName + '\'' +
                ",\n пароль='" + password + '\'' +
                ",\n id=" + id +
                ",\n Имя ='" + name + '\'' +
                ",\n Дата рождения =" + birthday +
                ",\n Номер телефона =" + telefon +
                ",\n Должность ='" + position + '\'' +
                ",\n Отдел ='" + department + '\'' +
                ",\n Дата приема на работу=" + d +
                ",\n Заработная плата =" + salary ;
    }
}
