package com.bee.firsthomework.others;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Contorl {
    public static final String QUERY_MENU = "------------------------\n" +
            "请选择需要查询的字段：\n" +
            "1. varity\n" +
            "2. gender\n" +
            "3. age\n" +
            "4. color\n" +
            "5. work\n";
    // 定义一个字符串用于每次功能执行完后清屏
    public static final String BLANK = "\n" + "\n" + "\n" + "\n" + "\n";
    // 定义几个菜单的显示文字
    private static final String MENU01 = "-------------------------------" + '\n' +
            "-------欢迎来到宠物管理系统-------" + '\n' +
            "-------------------------------" + '\n' +
            "1. ---->查询功能" + '\n' +
            "2. ---->添加功能" + '\n' +
            "3. ---->删除功能" + '\n' +
            "4. ---->修改功能" + '\n' +
            "-1. ---->退出系统！";
    private static final String MENU02 = "0. ---->返回上一菜单上一级！" + '\n' +
            "-1. ---退出系统！\n";
    public static final String ADD_MENU = "------------------------\n" +
            "1. ---->添加Cow\n" +
            "2. ---->添加Bee\n" + MENU02;
    private static Scanner scanner = new Scanner(System.in);
    private static int menu_layer = 0;   // 定义一个静态全局变量记录菜单所处层级
    private TreeSet<Animal> animals;

    public Contorl(TreeSet animals) {
        this.animals = animals;
    }

    /*
     * 用于给数字类型的参数从键盘输入赋值，避免了
     * 因为InputMismatchException错误而导致程序崩溃
     * */
    public static int getNumber() {
        int number = 0;
        try {
            number = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("请检查输入是否有误！！！");
            getNumber();
        }
        return number;
    }

    public void run() {
        int number;
        while (menu_layer != -1) {
            // 当 menu_layer 的值等于 -1 时退出程序
            // 当且仅当菜单层级为 0 时 在run（）中使用输入选择（个人认为这样较为方便）
            if (menu_layer == 0) {
                System.out.println(MENU01);
                all();
                number = scanner.nextInt();
                System.out.println(BLANK);
                // 使用switch语句来控制菜单层级
                switch (number) {
                    case 1:
                        menu_layer = 1;
                        break;
                    case 2:
                        menu_layer = 2;
                        break;
                    case 3:
                        menu_layer = 3;
                        break;
                    case 4:
                        menu_layer = 4;
                        break;
                    case -1:
                        System.out.println("bye~bye!");
                        break;
                    default:
                        System.out.println("错误代码请重新输入");
                        break;
                }
            } else if (menu_layer == 1) {
                //  ----------------> 跳转到查询功能菜单
                operationQuery();
            } else if (menu_layer == 2) {
                // -------------> 跳转到添加功能菜单
                operationAdd();
            } else if (menu_layer == 3) {
                // --------->  跳转到删除功能菜单
                operationRemove();
            } else if (menu_layer == 4) {
                // -----------> 跳转到修改功能菜单
                operationAlert();
            }
            System.out.println(BLANK);
        }
    }

    public void operationRemove() {
        all();
        System.out.println(MENU02);

        System.out.println("输入需要删除的信息前的编号:");
        int removeId = getNumber();
        //  ID值不会出现 0  或  -1 所以将其与菜单的层级控制绑定
        if (removeId == 0 || removeId == -1) {
            menu_layer = removeId;
            return;
        }
        //  避免因为空指针异常导致程序崩掉
        try {
            animals.remove(query(removeId));
            System.out.println("======删除成功======");
        } catch (NullPointerException e) {
            System.out.println("没有找到编号为" + removeId + "的宠物信息");
        }
        //  使用 sleep 使得清屏代码延时执行，不过似乎没什么用，哈哈哈
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void operationAlert() {        //  ------------> 用于修改功能的调用方法
        all();
        System.out.println(MENU02);

        System.out.println("请输入需要修改的信息前的编号进行修改:");
        int number;
        number = getNumber();
        System.out.println(BLANK);
        if (number == 0 || number == -1) {
            menu_layer = number;
            return;
        }
        Animal alertAnimal = query(number);
        if (alertAnimal == null) {
            System.out.println("没有找到编号为" + number + "的宠物信息");
            operationAlert();
        } else {
            alertAnimal(alertAnimal);
        }
        menu_layer = 0;
    }

    // 用于给数字类型的参数从键盘输入赋值，避免了因为InputMismatchException错误而导致程序崩溃
    public Animal query(int id) {
        Iterator iterator = animals.iterator();
        for (int i = 1; iterator.hasNext(); i++, iterator.next()) {
            if (i == id) {
                return (Animal) iterator.next();
            }
        }
        return null;
    }

    // 通过一个总的query方法去调用其余的query方法
    public void operationQuery() {
        System.out.println(QUERY_MENU + MENU02);
        int queryType;
        queryType = getNumber();

        switch (queryType) {
            case 1:
                System.out.println("请输入需要查询的值！！！");
                String queryName = scanner.next();
                queryByVarity(queryName);
                break;
            case 2:
                System.out.println("请输入需要查询的值！！！");
                String queryGender = scanner.next();
                queryByGender(queryGender);
                break;
            case 3:
                System.out.println("请输入需要查询的值！！！");
                int age = getNumber();
                queryByAge(age);
                break;
            case 4:
                System.out.println("请输入需要查询的值！！！");
                String queryColor = scanner.next();
                queryByColor(queryColor);
                break;
            case 5:
                System.out.println("请输入需要查询的值！！！");
                String queryWork = scanner.next();
                queryByWork(queryWork);
                break;
            case 0:
                menu_layer = 0;
                break;
            case -1:
                menu_layer = -1;
                break;
            default:
                System.out.println("请检查是否输入正确！");
                operationQuery();
                break;
        }
    }

    // 通过一个add方法，选择 添加的动物类别
    public void operationAdd() {
        System.out.println(ADD_MENU);
        System.out.println(MENU02);

        int num = scanner.nextInt();
        if (num == 0 || num == -1) {
            menu_layer = num;
            return;
        }
        switch (num) {
            case 1:
                addCow();
                break;
            case 2:
                addBee();
                break;
            default:
                break;
        }
        System.out.println(BLANK);
        operationAdd();
    }

    public void addCow() {
        System.out.println("请输入对应的属性：varity:       gender       age    color");
        String varity;
        String gender;
        String color;
        int age;
        varity = scanner.next();
        gender = scanner.next();
        age = getNumber();
        color = scanner.next();
        animals.add(new Cow(varity, gender, age, color));
        System.out.println("添加成功！！！");

    }

    public void addBee() {
        System.out.println("请输入对应的属性：varity:       gender       age    work");
        String varity;
        String gender;
        String work;
        int age;
        varity = scanner.next();
        gender = scanner.next();
        age = getNumber();
        work = scanner.next();
        animals.add(new Bee(varity, gender, age, work));
        System.out.println("添加成功！！！");
    }

    /*
    用于查询容器中所有的动物信息，且因为采用了TreeSet的集合类，可以将其自动按年龄排序输出
    并且继承了comparable接口、覆写了compareTo()方法
    */
    public void all() {
        // 使用 number 进行编号，方便用户操作
        System.out.println("===============系统中所有动物信息：=========");
        int number = 0;
        for (Object animal : animals) {
            number++;
            System.out.print(number + "   ");
            System.out.println(animal);
        }
        System.out.println("-----------------------------------------");
    }

    public void queryByVarity(String queryName) {
        int count = 0;
        for (Animal animal : animals) {
            if (animal.getVarity().equals(queryName)) {
                count++;
                System.out.println(animal);
            }
        }
        if (count == 0) {
            System.out.println("很遗憾，没有您要找的宠物！！！\n");
        } else {
            System.out.println("总共有" + count + "只宠物满足您的需求！！！\n");
        }
        operationQuery();
    }

    public void queryByGender(String queryGender) {
        int count = 0;
        for (Animal animal : animals) {
            if (animal.getGender().equals(queryGender)) {
                count++;
                System.out.println(animal);
            }
        }
        if (count == 0) {
            System.out.println("很遗憾，没有您要找的宠物！！！\n");
        } else {
            System.out.println("总共有" + count + "只宠物满足您的需求！！！\n");
        }
        operationQuery();
    }

    public void queryByColor(String queryColor) {
        int count = 0;
        for (Animal animal : animals) {
            if (animal instanceof Cow) {
                //因为只有Cow 类才设置有 color属性，所以进行类型判断后进行向下转型
                Cow c = (Cow) animal;
                if (c.getColor().equals(queryColor)) {
                    count++;
                    System.out.println(c);
                }
            }
        }
        if (count == 0) {
            System.out.println("很遗憾，没有您要找的宠物！！！\n");
        } else {
            System.out.println("总共有" + count + "只宠物满足您的需求！！！\n");
        }
        operationQuery();
    }

    public void queryByWork(String queryWork) {
        int count = 0;
        for (Animal animal : animals) {
            //因为只有Bee 类才设置有 work 属性，所以进行类型判断后进行向下转型
            if (animal instanceof Bee) {
                Bee b = (Bee) animal;
                if (b.getWork().equals(queryWork)) {
                    count++;
                    System.out.println(b);
                }
            }
        }
        if (count == 0) {
            System.out.println("很遗憾，没有您要找的宠物！！！\n");
        } else {
            System.out.println("总共有" + count + "只宠物满足您的需求！！！\n");
        }
        operationQuery();
    }

    public void queryByAge(int queryAge) {
        int count = 0;
        for (Animal animal : animals) {
            if (animal.getAge() == queryAge) {
                count++;
                System.out.println(animal);
            }
        }
        if (count == 0) {
            System.out.println("很遗憾，没有您要找的宠物！！！\n");
        } else {
            System.out.println("总共有" + count + "只宠物满足您的需求！！！\n");
        }
        operationQuery();
    }


    public void alertAnimal(Animal animal) {

        if (animal instanceof Cow) {
            System.out.println("请选择需要修改的内容：\n" +
                    "1. varity \n" +
                    "2. gender \n" +
                    "3. age \n" +
                    "4. color \n" +
                    "5. 修改全部数据");
        } else if (animal instanceof Bee) {
            System.out.println("请选择需要修改的内容：\n" +
                    "1. varity \n" +
                    "2. gender \n" +
                    "3. age \n" +
                    "4. work \n" +
                    "5. 修改全部数据");
        }
        int alertId = scanner.nextInt();
        System.out.println("请输入想要修改的值：  ");
        switch (alertId) {
            case 1:
                String varity1 = scanner.next();
                animal.setVarity(varity1);
                break;
            case 2:
                String gender1 = scanner.next();
                animal.setGender(gender1);
                break;
            case 3:
                int age1 = getNumber();
                animal.setAge(age1);
                break;
            case 4:
                String others = scanner.next();
                if (animal instanceof Cow) {
                    ((Cow) animal).setColor(others);
                } else if (animal instanceof Bee) {
                    ((Bee) animal).setWork(others);
                }
                break;
            case 5:
                varity1 = scanner.next();
                gender1 = scanner.next();
                age1 = getNumber();
                others = scanner.next();
                animal.setVarity(varity1);
                animal.setAge(age1);
                animal.setGender(gender1);
                if (animal instanceof Cow) {
                    ((Cow) animal).setColor(others);
                } else if (animal instanceof Bee) {
                    ((Bee) animal).setWork(others);
                }
            default:
                break;
        }
    }
}
