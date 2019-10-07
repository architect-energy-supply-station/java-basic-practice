package object;

/**
 * @author bill-smith liuwb
 * @Package object
 * @Date 2019/10/4 13:10
 * @Version v1.0
 * @Copyright @ 2019-2020用友网络科技股份有限公司
 * @Email 18232480449@163.com
 * @Contract https://github.com/BillCindy
 * @Blog https://blog.csdn.net/t131452n?viewmode=contents
 */
public class PersonTest {
    public static void main(String[] args) {
        Person bill = new Person("bill");
        Person cindy = new Person("bill");
        System.out.println(bill.equals(cindy));
        System.out.println(bill==cindy);
    }
}
