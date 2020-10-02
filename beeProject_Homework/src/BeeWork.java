import others.Animal;
import others.Bee;
import others.Contorl;
import others.Cow;

import java.util.TreeSet;
/*
* 将动物信息（种类，性别，年龄）保存在集合中（可以先保存一部分，再添加新的；也可以后面录入。在这里要不同的动物可能会有不同的属性）
在控制台输入指令，系统可以对动物信息进行基本的增加、删除、修改、查询、对年龄进行排序然后输出
像C语言题库里面的那种菜单式的系统，如输入1进行...操作，输入2进行...操作
考察内容：面向对象，泛型，异常，集合
* */


/*采用了 TreeSet 集合类，并将Animal类实现了comparable接口，并将compareTo的比较内容设置为 age
放入时会自动排序，forEach语句和Iterator 输出时就是已经按照年龄排序的了
*/

public class BeeWork {
    public static void main(String[] args) {
        TreeSet<Animal> animals = new TreeSet<>();
        Animal animal = new Cow("Cow", "female", 12, "black");
        Animal animal1 = new Cow("Cow", "female", 15, "black");
        Animal animal2 = new Bee("蜂王", "female", 10, "采蜜");
        animals.add(animal);
        animals.add(animal1);
        animals.add(animal2);
        Contorl contorl = new Contorl(animals);
        contorl.run();
    }
}
