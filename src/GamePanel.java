import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {

    // Variables
    public static String snakeDirection = "NONE";
    private final int PANEL_WIDTH = 500, PANEL_HEIGHT = 500;
    public static int ax, ay, score = 0;
    public ArrayList<ArrayList<Integer>> snakeBody = new ArrayList<>();
    private final Random RANDOM;
    private final Timer TIMER;

    GamePanel() {
        // Adding 4 initial segments to the snake
        snakeBody.add(new ArrayList<>(Arrays.asList(240, 240)));
        snakeBody.add(new ArrayList<>(Arrays.asList(220, 240)));
        snakeBody.add(new ArrayList<>(Arrays.asList(200, 240)));
        snakeBody.add(new ArrayList<>(Arrays.asList(180, 140)));
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.BLACK);
        TIMER = new Timer(100, this);
        TIMER.start();
        RANDOM = new Random();
        // Create random coordinates for apple
       newApple();
    }

    public void paint(Graphics g) {
        // Reset Board
        super.paint(g);
        Graphics2D graphics = (Graphics2D) g;
        // Grid
        graphics.setPaint(Color.DARK_GRAY);
        for (int i = 0; i < PANEL_WIDTH/20; i++) {
            g.drawLine(i*20, 0, i*20, PANEL_HEIGHT);
        }
        for (int i = 0; i < PANEL_HEIGHT/20; i++) {
            g.drawLine(0, i*20, PANEL_WIDTH, i*20);
        }
        // Whole Snake
        graphics.setPaint(Color.GREEN);
        for (ArrayList<Integer> snakePoint : snakeBody)
            graphics.fillRect(snakePoint.get(0), snakePoint.get(1), 20, 20);
        // Apple
        graphics.setPaint(Color.RED);
        graphics.fillRect(ax, ay, 20, 20);
    }

    public void check() {
        // HIT LEFT OR RIGHT
        if (snakeBody.get(0).get(0) >= PANEL_WIDTH)
            gameOver();
        else if (snakeBody.get(0).get(0) < 0)
            gameOver();
        // HIT TOP OR BOTTOM
        if (snakeBody.get(0).get(1) >= PANEL_HEIGHT)
            gameOver();
        else if (snakeBody.get(0).get(1) < 0)
            gameOver();
        // RUN INTO SELF
        for (int i = 4; i < snakeBody.size(); i++)
            if (snakeBody.get(i).get(0).equals(snakeBody.get(0).get(0)) && snakeBody.get(i).get(1).equals(snakeBody.get(0).get(1)))
                gameOver();
        // APPLE EATEN
        if (snakeBody.get(0).get(0) == ax && snakeBody.get(0).get(1) == ay) {
            switch (snakeDirection) {
                case "NORTH" -> snakeBody.add(new ArrayList<>(Arrays.asList(
                        snakeBody.get(snakeBody.size() - 1).get(0),
                        snakeBody.get(snakeBody.size() - 1).get(1) + 20
                )));
                case "SOUTH" -> snakeBody.add(new ArrayList<>(Arrays.asList(
                        snakeBody.get(snakeBody.size() - 1).get(0),
                        snakeBody.get(snakeBody.size() - 1).get(1) - 20
                )));
                case "WEST" -> snakeBody.add(new ArrayList<>(Arrays.asList(
                        snakeBody.get(snakeBody.size() - 1).get(0) + 20,
                        snakeBody.get(snakeBody.size() - 1).get(1)
                )));
                case "EAST" -> snakeBody.add(new ArrayList<>(Arrays.asList(
                        snakeBody.get(snakeBody.size() - 1).get(0) - 20,
                        snakeBody.get(snakeBody.size() - 1).get(1)
                )));
            }
            newApple();
            score++;
        }
    }

    public void newApple() {
        ax = (RANDOM.nextInt(24) + 1) * 20;
        ay = (RANDOM.nextInt(24) + 1) * 20;
    }

    public void gameOver() {
        TIMER.stop();
        int response = JOptionPane.showConfirmDialog(null,
                "Do you want to play again?",
                "Play again?",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );
        if (response == JOptionPane.YES_OPTION) {
            snakeBody.clear();
            snakeBody.add(new ArrayList<>(Arrays.asList(240, 240)));
            snakeBody.add(new ArrayList<>(Arrays.asList(220, 240)));
            snakeBody.add(new ArrayList<>(Arrays.asList(200, 240)));
            snakeBody.add(new ArrayList<>(Arrays.asList(180, 140)));
            snakeDirection = "NONE";
            score = 0;
            newApple();
            TIMER.start();
        } else {
            System.exit(0);
        }
    }

    public void move() {
        for (int i = snakeBody.size() - 1; i > 0; i--) {
            snakeBody.get(i).set(0, snakeBody.get(i - 1).get(0));
            snakeBody.get(i).set(1, snakeBody.get(i - 1).get(1));
        }
        switch (snakeDirection) {
            case "NORTH" -> snakeBody.get(0).set(1, snakeBody.get(0).get(1) - 20);
            case "SOUTH" -> snakeBody.get(0).set(1, snakeBody.get(0).get(1) + 20);
            case "WEST" -> snakeBody.get(0).set(0, snakeBody.get(0).get(0) - 20);
            case "EAST" -> snakeBody.get(0).set(0, snakeBody.get(0).get(0) + 20);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Lose conditions LEFT/RIGHT
        move();
        check();
        repaint();
    }
}
