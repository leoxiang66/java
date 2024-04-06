public class Example2 {

    public static void func1() {
        try {
            func2();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("抓住异常");
        }
    }
    
    public static void func2() {
        func3();
    }
    

    public static void func3() throws RuntimeException  {
        // throws RuntimeException 表示可能会异常
        throw new RuntimeException("程序错误");
    }

    public static void main(String[] args) {
         func1();
    }
}
