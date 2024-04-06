import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Example3 {

    // 声明方法可能会抛出IOException异常
    public static String readFile(String filePath) throws IOException {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            return stringBuilder.toString();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }


    public static void main(String[] args) {
        try {
            System.out.println(readFile("./Example1.java"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
