import java.util.ArrayList;

public class Main {
    public void myFunction() {
        String userInput = Terminal.readString();
        ArrayList<String> tokens = new ArrayList<String>();

        while (!userInput.equals("")) {
            // invalid token
            if (userInput.matches("(.*[0-9].*)")) {
                System.err.println("不能有数字");
                userInput = Terminal.readString();
            }

            // valid token
            else {
                tokens.add(userInput);
                // update userInput
                userInput = Terminal.readString();
            }
        }

        // user entered empty string
        printStartCase(tokens);
        printUpperCase(tokens);
        printSnakeCase(tokens);
        printPascalCase(tokens);

    }

    private void printPascalCase(ArrayList<String> tokens) {
        System.out.print("Pascal case: ");

        for (String string : tokens) {
            printCaptilized(string);
        }
        System.out.println();
    }

    private void printSnakeCase(ArrayList<String> tokens) {
        System.out.print("Snake case: ");

        for (String string : tokens) {
            System.out.print(string);
            System.out.print("_");

        }
        System.out.println();
    }

    private void printUpperCase(ArrayList<String> tokens) {
        System.out.print("Uppercase: ");
        for (String string : tokens) {
            System.out.print(string.toUpperCase());
        }
        System.out.println();
    }

    private void printStartCase(ArrayList<String> tokens) {
        // TODO Auto-generated method stub
        System.out.print("Startcase: ");

        // print first token, with first char uppercase
        printCaptilized(tokens.get(0));

        // print rest tokens
        for (int i = 1; i < tokens.size(); i++) {
            System.out.print(tokens.get(i).toLowerCase());
        }

        // new line
        System.out.println();
    }

    private void printCaptilized(String token) {
        String firstToken = token.toUpperCase();
        char firstChar = firstToken.charAt(0);
        String restchars = firstToken.substring(1).toLowerCase();
        System.out.print(firstChar);
        System.out.print(restchars);
    }

    public static void main(String[] args) {
        Main hi = new Main();
        hi.myFunction();
    }
}
