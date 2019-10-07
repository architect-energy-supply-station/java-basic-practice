package object;

import java.util.Objects;

/**
 * @author bill-smith liuwb
 * @Package object
 * @Date 2019/10/4 13:09
 * @Version v1.0
 * @Copyright @ 2019-2020用友网络科技股份有限公司
 * @Email 18232480449@163.com
 * @Contract https://github.com/BillCindy
 * @Blog https://blog.csdn.net/t131452n?viewmode=contents
 */
public class Person {
    private String name;
/*

    @Override
    public boolean equals(Object obj) {
//        return super.equals(obj);
        return obj instanceof Person && ((Person) obj).name == this.name;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public Person(String name) {
        this.name = name;
    }
}
