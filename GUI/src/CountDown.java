import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountDown extends JFrame implements ActionListener {
    private static final int GRID_SIZE = 4;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 16;

    private JButton[] buttons;
    private List<Integer> numbers;
    private int currentIndex;

    public CountDown() {
        setTitle("Number Countdown Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(GRID_SIZE, GRID_SIZE));

        initializeGame();

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initializeGame() {
        numbers = new ArrayList<>();
        for (int i = MAX_VALUE; i >= MIN_VALUE; i--) {
            numbers.add(i);
        }
        // Collections.shuffle(numbers);

        buttons = new JButton[GRID_SIZE * GRID_SIZE];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(String.valueOf(numbers.get(i)));
            buttons[i].addActionListener(this);
            add(buttons[i]);
        }

        currentIndex = 0;
    }

    private void endGame(boolean win) {
        String message = win ? "Congratulations! You won!" : "Oops! You clicked the wrong number. Game over!";
        JOptionPane.showMessageDialog(this, message, "Game Over", JOptionPane.INFORMATION_MESSAGE);
        initializeGame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        int clickedNumber = Integer.parseInt(clickedButton.getText());
        System.out.println(clickedNumber);
        System.out.println(numbers.get(currentIndex));

        if (clickedNumber == numbers.get(currentIndex)) {
            clickedButton.setEnabled(false);
            currentIndex++;

            if (currentIndex == numbers.size()) {
                endGame(true);
            }
        } else {
            endGame(false);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CountDown2::new);
    }
}