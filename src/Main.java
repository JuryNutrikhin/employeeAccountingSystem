import dao.DaoClass;
import modul.Employee;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        boolean run = true;
        DaoClass daoClass = new DaoClass();

        while (run) {
            String password = null;
            int telefon = 0;
            String position = null;
            String department = null;
            int salary = 0;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Меню :" +
                    "\n1 - Вход" +
                    "\n2 - Регистрация " +
                    "\n3 - Выход ");
            int enter = scanner.nextInt();
            if (enter == 1) {
                System.out.println("Введите логин");
                String login = scanner.next();
                System.out.println("Введите пароль");
                String pass = scanner.next();

                if (daoClass.register(login, pass, daoClass.employees)) {
                    System.out.println("Вход совершен ");
                    //.................................................................................................................................
                    System.out.println("Выберите один из  пунктов меню :\n");
                    System.out.println("Добавить нового сотрудника - нажмите 1");
                    System.out.println("Изменить данные  сотрудника - нажмите 2");
                    System.out.println("Удалить данные  сотрудника - нажмите 3");
                    System.out.println("Поиск сотрудника по имени - нажмите 4");
                    System.out.println("Поиск сотрудника по должности - нажмите 5");
                    System.out.println("Поиск сотрудника по названию отдела - нажмите 6");
                    System.out.println("Поиск сотрудника по имени начальника отдела  - нажмите 7 \n\n");

                    System.out.println("ОТЧЁТЫ :\n");

                    System.out.println("Для просмотра  информации об отделах: структура организации (информация об отделах, ФИО начальников отделов), средняя зарплата\n" +
                            "по организации и по отделам, - нажмите 8 ");
                    System.out.println("Для просмотра  информации о ТОП-10 самых дорогих сотрудников по зарплате - нажмите 9 ");
                    System.out.println("Для просмотра  информации о ТОП-10 самых преданных сотрудников по количеству лет работы в организации. - нажмите 10 \n");

                    int num = scanner.nextInt();


                    if (num == 1) {

                        System.out.println("Введите  логин  для нового сотрудника ");
                        String nickName = scanner.next();
                        System.out.println("Введите  пароль  для нового сотрудника ");
                        password = scanner.next();
                        System.out.println("Введите  имя  нового сотрудника ");
                        String name = scanner.next();
                        System.out.println("Введите  дату рождения   нового сотрудника ");
                        int birthday = scanner.nextInt();
                        System.out.println("Введите номер телефона  нового сотрудника ");
                        telefon = scanner.nextInt();

                        System.out.println("Выберите  должность для  нового сотрудника :");
                        System.out.println("Должность руководитель - нажмите 1 ");
                        System.out.println("Должность специалист - нажмите 2 ");
                        System.out.println("Должность работник - нажмите 3 ");
                        int a = scanner.nextInt();

                        switch (a) {
                            case (1):
                                position = "руководитель";
                                break;
                            case (2):
                                position = "специалист";
                                break;
                            case (3):
                                position = "работник";
                                break;
                            default:
                                System.out.println("Вы ввели неверное число");
                                break;
                        }

                        System.out.println("Выберите  отдел  для  нового сотрудника :");
                        System.out.println("Должность Бухгалтерия - нажмите 1 ");
                        System.out.println("Должность Производство - нажмите 2 ");
                        System.out.println("Должность Отдел продаж - нажмите 3 ");

                        department = "";
                        switch (scanner.nextInt()) {
                            case (1):
                                department = "Бухгалтерия";
                                break;
                            case (2):
                                department = "Производство";
                                break;
                            case (3):
                                department = "Отдел продаж";
                                break;
                            default:
                                System.out.println("Вы ввели неверное число");
                                break;
                        }

                        System.out.println("Введите зарплату нового сотрудника");
                        salary = scanner.nextInt();

                        daoClass.addEmployee(new Employee(nickName, password, name, birthday, telefon, position, department, salary));
                        System.out.println("Сотрудник создан ");
                    }

                    //..................................................................


                    //Изменить данные  сотрудника
                    else if (num == 2) {
                        System.out.println("Введите имя сотрудника чьи данные нужно изменить");
                        daoClass.employees.stream()
                                .forEach(a -> System.out.println(a.getName()));
                        String name = scanner.next();

                        Employee employeeView = daoClass.employees.stream()
                                .filter(e -> e.getName().equals(name))
                                .findFirst()
                                .orElseThrow();                      //.ifPresentOrElse(() -> System.out.println("Value not found"),v ->v);
                        System.out.println(employeeView);

                        System.out.println("Выберите нужный пункт  из меню :");
                        System.out.println("Изменить пароль - введите 1 , если нет введите 2");
                        if (scanner.next().equals("1")) {
                            System.out.println("Введите новый пароль");
                            password = scanner.next();
                        } else password = employeeView.getPassword();

                        System.out.println("Изменить  номер телефона - введите 1 , если нет введите 2");
                        if (scanner.next().equals("1")) {
                            System.out.println("Введите новый номер телефона");
                            telefon = scanner.nextInt();
                        } else telefon = employeeView.getTelefon();


                        System.out.println("Изменить должность - введите 1 , если нет введите 2");
                        if (scanner.next().equals("1")) {
                            System.out.println("Введите новую должность :     ");
                            System.out.println(" если руководитель  -нажмите  1." +
                                    "\n  если специалист  -нажмите  2." +
                                    "\n  если рабочий   -нажмите  3.");
                            String temp = scanner.next();

                            if (temp.equals("1")) {
                                position = "руководитель";
                            } else if (temp.equals("2")) {
                                position = "специалист";
                            } else {
                                position = "рабочий";
                            }
                        } else position = employeeView.getPosition();

                        System.out.println("Изменить отдел - введите 1 , если нет введите 2");
                        if (scanner.next().equals("1")) {
                            System.out.println("Введите новый отдел :     ");
                            System.out.println(" если Бухгалтерия  -нажмите  1." +
                                    "\n  если Производство  -нажмите  2." +
                                    "\n  если Отдел продаж   -нажмите  3.");
                            String temp = scanner.next();
                            if (temp.equals("1")) {
                                department = "Бухгалтерия";
                            } else if (temp.equals("2")) {
                                department = "Производство";
                            } else {
                                department = "Отдел продаж";
                            }
                        } else department = employeeView.getDepartment();

                        System.out.println("Изменить заработную плату - введите 1 , если нет введите 2");
                        if (scanner.next().equals("1")) {
                            System.out.println("Введите новую заработную плату ");
                            salary = scanner.nextInt();
                        } else {
                            salary = employeeView.getSalary();
                        }

                        Employee employeeUpdata = new Employee(employeeView.getNickName(), password, employeeView.getName(), employeeView.getBirthday(), telefon, position, department, salary);
                        int index = daoClass.employees.indexOf(employeeView);

                        daoClass.updateEmployee(index, employeeUpdata);
                        System.out.println("Данные измены");

//..................................................................

                        //Удалить данные  сотрудника - нажмите 3

                    } else if (num == 3) {
                        System.out.println("Выберите id сотрудника чьи данные требуется удалить из списка , и введите его");
                        daoClass.employees.forEach(a -> System.out.println("id = " + daoClass.employees.indexOf(a) + "   Имя сотрудника   :" + a.getName()));
                        int indexArray = scanner.nextInt();
                        daoClass.deleteEmployee(indexArray, daoClass.employees);

                    } else if (num == 4) {//поиск по имени

                        System.out.println("Введите имя сотрудника");
                        String searchName = scanner.next();
                        daoClass.employees.stream()
                                .filter(a -> a.getName().equals(searchName))
                                .forEach(a -> System.out.println(daoClass.searchEmployee(daoClass.employees.indexOf(a), daoClass.employees)));

                        //...................................................................

                    } else if (num == 5) {//поиск по должности
                        System.out.println("Выберите из списка нужную должность для поиска  сотрудника : \n" +
                                "Руководитель нажмите  1 \n" +
                                "Специалист нажмите 2 \n" +
                                "Работник нажмите 3");
                        String sourchEmlpoyee = scanner.next();
                        String finalPosition;

                        if (sourchEmlpoyee.equals("1")) {
                            finalPosition = "руководитель";
                        } else if (sourchEmlpoyee.equals("2")) {
                            finalPosition = "специалист";
                        } else {
                            finalPosition = "рабочий";
                        }

                        System.out.println("Введите Id из списка : ");
                        daoClass.employees.stream()
                                .filter(n -> n.getPosition().equals(finalPosition))
                                .forEach(d -> System.out.print( "  Имя сотрудника : " + d.getName()+ "  нажмите "+ daoClass.employees.indexOf(d) +"\n"));

                        int id = scanner.nextInt();


                        System.out.println(daoClass.searchEmployee(id, daoClass.employees));


                        //...................................................................
//              поиск по организации
                    } else if (num == 6) {

                        System.out.println("Выберите из списка нужный отдел для поиска сотрудника : \n" +
                                "Бухгалтерия нажмите  1 \n" +
                                "Производство нажмите 2 \n" +
                                "Отдел продаж нажмите 3");
                        String sourchEmlpoyee = scanner.next();
                        String finaldepartment;

                        if (sourchEmlpoyee.equals("1")) {
                            finaldepartment = "Бухгалтерия";
                        } else if (sourchEmlpoyee.equals("2")) {
                            finaldepartment = "Производство";
                        } else {
                            finaldepartment = "Отдел продаж";
                        }

                        System.out.println("Введите Id из списка : ");
                        daoClass.employees.stream()
                                .filter(n -> n.getDepartment().equals(finaldepartment))
                                .forEach(d -> System.out.print("  Имя сотрудника : " + d.getName()+ "  нажмите "+ daoClass.employees.indexOf(d) +"\n"));

                        int id = scanner.nextInt();

                        System.out.println(daoClass.searchEmployee(id, daoClass.employees));


                        //............................................................................
                        //Поиск сотрудника по имени начальника отдела
                    } else if (num == 7) {
                        System.out.println("Введите имя начальника отдела где работает сотрудник из списка");
                        daoClass.employees.stream()
                                .filter(a -> a.getPosition().equals("руководитель"))
                                .forEach(a -> System.out.println(a.getName()));

                        String dirName = scanner.next();
                        System.out.println("Введите Id из списка : ");
                        Employee e = daoClass.employees.stream()
                                .filter(a -> a.getName().equals(dirName))
                                .findFirst()
                                .orElseThrow(() -> new NullPointerException("Сотрудника с таким именем нет"));

                        String s = e.getDepartment();
                        daoClass.employees.stream()
                                .filter(a -> a.getDepartment().equals(s))
                                .forEach(a -> System.out.println("  Имя сотрудника : " + a.getName()+ "  нажмите "+ daoClass.employees.indexOf(a) +"\n"));

                        int index = scanner.nextInt();
                        System.out.println(daoClass.searchEmployee(index, daoClass.employees));

//......................................................................................
                        //"Для просмотра  информации об отделах: структура организации (информация об отделах, ФИО начальников отделов), средняя зарплата\n" +
                        //                    "по организации и по отделам, - нажмите 8 "
                    } else if (num == 8) {

                        System.out.println("Структура организации : \n");

                        int countEmployee = (int) daoClass.employees.stream().count();
                        System.out.println("Общее количество сотрудников в организации : " + countEmployee + " человек\n");

                        daoClass.employees.stream()
                                .filter(n -> n.getPosition().equals("руководитель"))
                                .forEach(a -> System.out.println("Отдел " + a.getDepartment() + "- должность - " + a.getPosition() + " - Имя - " + a.getName() + "- зарплата - " + a.getSalary()));
                        //..............................................
                        System.out.println();

                        System.out.println("Средняя оплата труда по организации : " + (int) daoClass.reportAverageSalary(daoClass.employees));//средняя оплата труда по организации
                        List<Employee> e1 = daoClass.employees.stream()
                                .filter(a -> a.getDepartment().equals("Бухгалтерия"))
                                .collect(Collectors.toList());

                        System.out.println("Средняя оплата труда  в Бухгалтерии : " + (int) daoClass.reportAverageSalary(e1));//средняя оплата труда по Бухгалтерии

                        e1 = daoClass.employees.stream()
                                .filter(a -> a.getDepartment().equals("Производство"))
                                .collect(Collectors.toList());
                        System.out.println("Средняя оплата труда  в отделе Производство : " + (int) daoClass.reportAverageSalary(e1));//средняя оплата труда по Производство

                        e1 = daoClass.employees.stream()
                                .filter(a -> a.getDepartment().equals("Отдел продаж"))
                                .collect(Collectors.toList());
                        System.out.println("Средняя оплата труда  в отделе Отдел продаж : " + (int) daoClass.reportAverageSalary(e1));//средняя оплата труда по Отдел продаж


                        //............................................
                    } else if (num == 9) {// топ 10 по оплате труда
                        System.out.println("Tоп 10 по оплате труда в организации ");
                        daoClass.reportTop10Salary(daoClass.employees);
                        //System.out.println(daoClass.reportTop10Salary(daoClass.employees));
//                List<Employee> employeeList = daoClass.reportTop10Salary(daoClass.employees);1
//                employeeList.stream()
//                        .limit()
//..............................................
                    } else if (num == 10) {// топ 10  самых преданных сотрудников
                        //  System.out.println( daoClass.reportTop10Employee(daoClass.employees));
                        System.out.println("Топ 10  самых преданных сотрудников");
                        daoClass.reportTop10Employee(daoClass.employees);

                        //.................................................................................................................................


                    } else System.out.println("Не верно ввели номер .Выберите пункт из меню");
                } else {
                    System.out.println("Логин и пароль введен не правильно");

                }

            } else if (enter == 2) {

                System.out.println("Введите  логин  для нового сотрудника ");
                String nickName = scanner.next();
                System.out.println("Введите  пароль  для нового сотрудника ");
                password = scanner.next();
                System.out.println("Введите  имя  нового сотрудника ");
                String name = scanner.next();
                System.out.println("Введите  дату рождения   нового сотрудника ");
                int birthday = scanner.nextInt();
                System.out.println("Введите номер телефона  нового сотрудника ");
                telefon = scanner.nextInt();

                System.out.println("Выберите  должность для  нового сотрудника :");
                System.out.println("Должность руководитель - нажмите 1 ");
                System.out.println("Должность специалист - нажмите 2 ");
                System.out.println("Должность работник - нажмите 3 ");
                int a = scanner.nextInt();

                switch (a) {
                    case (1):
                        position = "руководитель";
                        break;
                    case (2):
                        position = "специалист";
                        break;
                    case (3):
                        position = "работник";
                        break;
                    default:
                        System.out.println("Вы ввели неверное число");
                        break;
                }

                System.out.println("Выберите  отдел  для  нового сотрудника :");
                System.out.println("Должность Бухгалтерия - нажмите 1 ");
                System.out.println("Должность Производство - нажмите 2 ");
                System.out.println("Должность Отдел продаж - нажмите 3 ");

                department = "";
                switch (scanner.nextInt()) {
                    case (1):
                        department = "Бухгалтерия";
                        break;
                    case (2):
                        department = "Производство";
                        break;
                    case (3):
                        department = "Отдел продаж";
                        break;
                    default:
                        System.out.println("Вы ввели неверное число");
                        break;
                }

                System.out.println("Введите зарплату нового сотрудника");
                salary = scanner.nextInt();

                daoClass.addEmployee(new Employee(nickName, password, name, birthday, telefon, position, department, salary));
            } else {
                run = false;
                break;
            }


            System.out.println(" Для продолжения нажмите 1  " +
                    "     для выхода нажмите   2");
            int a = scanner.nextInt();
            if (a != 1) {
                run = false;
                // daoClass.saveData();
            } else {
                run = true;
            }
            daoClass.saveData();
        }
    }
}
