import java.lang.RuntimeException;
public class Example1 {

    public static void div1(double a, double b) {
        // throw new RuntimeException("程序出错");

    }
    
    public static void div2(double a, double b) {
        System.out.println(a/b);
    }

    public static void main(String[] args) {
        // 假设程序员不知道 div1 的内部实现, 知道 div2 的实现没有问题
        // div1 可能会有错误(run time error)
        //
        try {
            div1(1, 2);

        }
        
        // try block 出现异常才执行这里
        catch (Exception e) {
            System.out.println("div1 出现异常, 执行 div2");
            System.out.println(e.toString());
            div2(1, 2);
        }

        // optional
        // 表示无论有没有异常, 都需要执行的代码
        finally {
             System.out.println("这个代码一定会执行");
        }
    }
}