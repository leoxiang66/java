import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.Arrays;
import java.util.Random;
import java.util.Collections;

public class CountDown extends JFrame {
    public JButton[] buttons;
    public JLabel statusLabel;
    public int currentIndex;
    public int MAX_VALUE = 10;
    public int MIN_VALUE = -10;
    public int[] gold;
    public int[] values;
    public Timer timer;
    public int ElapsedTimer;

    public void orderDescending(int[] numbers) {
        Arrays.sort(numbers);
        int temp_Number;
        for (int i = 0; i < numbers.length / 2; i++) {
            temp_Number = numbers[i];
            numbers[i] = numbers[numbers.length - 1 - i];
            numbers[numbers.length - 1 - i] = temp_Number;
        }
    }

    public boolean checkingReaptedNumber(int[] array, int element) {
        for (int i : array) {
            if (i == element) {
                return true;
            }
        }
        return false;
    }

    public void generateNumber() {
        int count = 0;
        values = new int[16];
        Random randomNumber = new Random();
        while (count < values.length) {
            int temp_Number = randomNumber.nextInt(21) - 10;
            if (checkingReaptedNumber(values, temp_Number)) {
                continue;
            } else {
                values[count] = temp_Number;
                count++;
            }
        }
    }

    public void disableAllButtons() {
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setEnabled(false);
        }
    }

    public void finishGame(boolean finish){
        if(finish){
            statusLabel.setText("Congratulation! you finished in" + ElapsedTimer);
        }else{
            statusLabel.setText("Wrong number clicked! Game Over.");  
        }
        disableAllButtons();
        timer.stop();
    }

    public CountDown(){
        setTitle("CountDown Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(400, 400);
        setLayout(new BorderLayout());

        generateNumber();
        gold = Arrays.copyOf(values, values.length);
        orderDescending(gold);
        
        buttons = new JButton[16];
        currentIndex = 0;

        JPanel gridPanel = new JPanel(new GridLayout(4, 4));
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                ElapsedTimer++;
                // String.valueOf(ElapsedTimer);
                setTitle(ElapsedTimer + "Seconds");
            }
        });
        
        for(int i = 0; i < buttons.length; i++){
                buttons[i] = new JButton(Integer.toString(values[i]));
                buttons[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e){
                        JButton clickedButton = (JButton) e.getSource();
                        String buttonLabel = clickedButton.getText();
                        int button_value = Integer.parseInt(buttonLabel); 

                        if(button_value == gold[currentIndex]){
                            statusLabel.setText("Continue");
                            currentIndex++;
                            clickedButton.setEnabled(false);
                        }else{
                            finishGame(false);
                        }
                        if(currentIndex == 16){
                            finishGame(true);
                        }
                    }
                });
                gridPanel.add(buttons[i]);
            }
        this.add(gridPanel, BorderLayout.CENTER);

        statusLabel = new JLabel("Click the button in descending order.");
        this.add(statusLabel, BorderLayout.SOUTH);
        setVisible(true);
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CountDown();
            }
        });
    }
}