package others;/*
 * @author:一身都是月~
 * @date：2020/10/1 17:49
 * */

import java.util.Objects;

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
    public String toString() {
        return "Bee{" +
                "varity='" + getVarity() + '\'' +
                ", gender='" + getGender() + '\'' +
                ", age=" + getAge() +
                "work='" + work + '\'' +
                '}';
    }
}
