package operation;

/**
 * @author bill-smith liuwb
 * @Package operation
 * @Date 2019/10/4 12:36
 * @Version v1.0
 * @Copyright @ 2019-2020用友网络科技股份有限公司
 * @Email 18232480449@163.com
 * @Contract https://github.com/BillCindy
 * @Blog https://blog.csdn.net/t131452n?viewmode=contents
 */
public class Operation {
    public static void main(String[] args) {
        int bitOperation=4;
        System.out.println(Integer.toBinaryString(bitOperation));
        bitOperation >>= 1;
        System.out.println(Integer.toBinaryString(bitOperation));
        bitOperation <<= 1;
        System.out.println(Integer.toBinaryString(bitOperation));

    }
}
