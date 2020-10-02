package others;

import java.util.Objects;

public class Cow extends Animal {
    private String color;

    public Cow(String varity, String gender, int age, String color) {
        super(varity, gender, age);
        this.color = color;
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
    public String toString() {
        return "Cow{" +
                "varity='" + getVarity() + '\'' +
                ", gender='" + getGender() + '\'' +
                ", age=" + getAge() + '\'' +
                ", color=" + color +
                '}';
    }
}
