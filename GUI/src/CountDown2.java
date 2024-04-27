import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class CountDown2 extends JFrame {
    public JButton[][] buttons;
    public JLabel statusLabel;
    public int[][] grid;
    public int remainingCount;

    public CountDown2() {
        setTitle("CountDown Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(400, 400);
        setLayout(new BorderLayout());
        setVisible(true);

        buttons = new JButton[4][4];
        grid = new int[4][4];
        remainingCount = 16;

        JPanel gridPanel = new JPanel(new GridLayout(4, 4));
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                buttons[i][j] = new JButton();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CountDown();
            }
        });
    }
}
