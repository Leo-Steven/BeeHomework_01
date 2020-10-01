package others;

import java.util.Objects;
import java.util.Scanner;

public class Cow extends Animal {
    private String color;
    public Cow(String varity, String gender, int age,String color) {
        super(varity, gender, age);
        this.color=color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cow cow = (Cow) o;
        return color.equals(cow.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void set(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("请选择需要修改的内容：\n" +
                "1. varity \n" +
                "2. gender \n" +
                "3. age \n" +
                "4. color \n" +
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
                int age1 =scanner.nextInt();
                this.setAge(age1 );
                break;
            case 4:
                String color1 =scanner.next();
                this.setColor(color1 );
                break;
            case 5:
                varity1 =scanner.next();
                gender1 =scanner.next();
                age1=scanner.nextInt();
                color1=scanner.next();
                this.setVarity(varity1);
                this.setColor(color1);
                this.setAge(age1);
                this.setGender(gender1);
            default:
                break;
        }
    }

    @Override
    public String toString() {
        return "Cow{" +
                "varity='" + getVarity() + '\'' +
                ", gender='" + getGender() + '\'' +
                ", age=" + getAge() + '\'' +
                ", color="+color+
                '}';
    }
}
