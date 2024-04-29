import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CountDown2 extends JFrame {
    public JButton[][] buttons;
    public JLabel statusLabel;
    public int currentIndex;
    public int MAX_VALUE = 10;
    public int MIN_VALUE = -10;
    public int[] gold;


    public void disableAllButtons() {
        for (int i = 0; i < buttons.length; i++) {
            // buttons[i].
        }
    
    }

    public CountDown2() {
        setTitle("CountDown Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(400, 400);
        setLayout(new BorderLayout());
        setVisible(true);

        buttons = new JButton[4][4];
        gold = new int[16];
        currentIndex = 0;

        // gold = [10,9,8,7,6,...,-10] 
        for (int i = 0; i < gold.length; i++) {
            gold[i] = MAX_VALUE - i;
        }


        

        JPanel gridPanel = new JPanel(new GridLayout(4, 4));
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                buttons[i][j] = new JButton(Integer.toString(gold[i * 4 + j]));
                // 添加点击事件处理程序
                buttons[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // statusLabel.setText("Button clicked!");
                        JButton clickedButton = (JButton) e.getSource();
                        String text = clickedButton.getText();
                        int value = Integer.parseInt(text);
                        System.out.println(value);

                        int goldvalue = gold[currentIndex];

                        // 用户点对了
                        if (goldvalue == value) {
                            statusLabel.setText("Correct number. Continue.");
                            currentIndex++;
                        }
                        //没点对
                        else {
                            statusLabel.setText("Wrong number. Game over.");
                        }

                        // 如果所有button都按顺序点对了
                        if (currentIndex == 16) {
                            statusLabel.setText("You win.");
                        }
                    }
                });

                gridPanel.add(buttons[i][j]);
            }
        }

        add(gridPanel, BorderLayout.CENTER);

        statusLabel = new JLabel("Click the buttons in descending order.");
        add(statusLabel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CountDown2();
            }
        });
    }
}