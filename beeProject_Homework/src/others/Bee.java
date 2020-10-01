package others;/*
 * @author:一身都是月~
 * @date：2020/10/1 17:49
 * */

import java.util.Objects;
import java.util.Scanner;

public class Bee extends Animal{
    private String work;

    public Bee(String varity, String gender, int age,String work) {
        super(varity, gender, age);
        this.work=work;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Bee bee = (Bee) o;
        return work.equals(bee.work);
    }

    @Override
    public int hashCode() {
        return Objects.hash(work);
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }
    @Override
    public void set(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("请选择需要修改的内容：\n" +
                "1. varity \n" +
                "2. gender \n" +
                "3. age \n" +
                "4. work \n" +
                "5. 修改全部数据");
        int alertId=scanner.nextInt();
        System.out.println("请输入想要修改的值：  ");
        switch (alertId){
            case 1:
                String varity1 =scanner.next();
                this.setVarity(varity1 );
                break;
            case 2:
                String gender1 =scanner.next();
                this.setGender(gender1 );
                break;
            case 3:
                int age1 =Contorl.getNumber();
                this.setAge(age1 );
                break;
            case 4:
                String work =scanner.next();
                this.setWork(work );
                break;
            case 5:
                varity1 =scanner.next();
                gender1 =scanner.next();
                age1=scanner.nextInt();
                work=scanner.next();
                this.setVarity(varity1);
                this.setWork(work);
                this.setAge(age1);
                this.setGender(gender1);
            default:
                break;
        }
    }
    @Override
    public String toString() {
        return "Bee{" +
                "varity='" + getVarity() + '\'' +
                ", gender='" + getGender() + '\'' +
                ", age=" + getAge() +
                "work='" + work + '\'' +
                '}';
    }
}
