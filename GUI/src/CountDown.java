import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class CountDown extends JFrame {
    public JButton[] buttons;
    public JLabel statusLabel;
    public int currentIndex;
    public int MAX_VALUE = 10;
    public int MIN_VALUE = -10;
    public int[] gold;
    public int[] values;
    public int elapsedTime = 0;
    public Timer timer;

    public void sort_descendingly(int[] numbers) {
        Arrays.sort(numbers);

        // Reverse the array to get descending order
        int temp;
        for (int i = 0; i < numbers.length / 2; i++) {
            temp = numbers[i];
            numbers[i] = numbers[numbers.length - 1 - i];
            numbers[numbers.length - 1 - i] = temp;
        }

    }

    public boolean array_contains(int[] arr, int element) {
        for (int i : arr) {
            if (i == element) {
                return true;
            }
        }
        return false;

    }

    public void generateValues() {
        values = new int[16];
        int count = 0;
        Random random = new Random();
        while (count < values.length) {
            int temp = random.nextInt(21) - 10; // -10 - 10
            if (array_contains(values, temp)) {
                continue;
            } else {
                values[count] = temp;
                count++;
            }
        }
    }

    public void disableAllButtons() {
        // todo
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setEnabled(false);
        }

    }

    public void setup() {
        setTitle("CountDown Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(400, 400);
        setLayout(new BorderLayout());
        setVisible(true);
        buttons = new JButton[16];
        currentIndex = 0; // gold[currentIndex]

        generateValues();

        // gold = new int[16];
        gold = Arrays.copyOf(values, values.length);
        sort_descendingly(gold);

    }

    public void endGame(boolean win) {
        if (win) {
            // win game
            statusLabel.setText("You win.");

        } else {
            // wrong; lose game
            statusLabel.setText("Wrong. Game Over.");

        }

        disableAllButtons();
        timer.stop();

    }

    public CountDown() {
        setup();
        JPanel gridPanel = new JPanel(new GridLayout(4, 4));

        // 创建一个每1000毫秒（1秒）触发一次的定时器
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elapsedTime++; // 增加时间
                setTitle("Timer: " + elapsedTime + " seconds"); // 更新窗口标题
            }
        });

        // 启动定时器
        timer.start();

        for (

                int i = 0; i < buttons.length; i++) {

            buttons[i] = new JButton(Integer.toString(values[i]));
            buttons[i].addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    JButton clickedButton = (JButton) e.getSource();
                    String buttonLabel = clickedButton.getText();
                    int button_value = Integer.parseInt(buttonLabel);

                    if (button_value == gold[currentIndex]) {
                        // correct
                        statusLabel.setText("Continue.");
                        currentIndex++;
                        clickedButton.setEnabled(false);

                    } else {
                        endGame(false);
                    }

                    if (currentIndex == 16) {
                        endGame(true);
                    }

                }

            });
            gridPanel.add(buttons[i]);

        }

        this.add(gridPanel, BorderLayout.CENTER);

        statusLabel = new JLabel("Click the buttons in descending order.");
        this.add(statusLabel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CountDown();
            }
        });
    }
}
