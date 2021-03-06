import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameWindow extends JFrame implements KeyListener {

    private static final long serialVersionUID = 8224333122641964095L;
    GamePanel gpanel;
    InfoPanel ipanel;
    GridBagConstraints constraints;
    ImageIcon icon;

    GameWindow() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println("ERROR:" + e.getMessage());
        }
        gpanel = new GamePanel();
        ipanel = new InfoPanel();
        constraints = new GridBagConstraints();
        icon = new ImageIcon(getClass().getResource("icon.png"));
        constraints.gridx = 0;
        constraints.gridy = 0;
        this.setLayout(new GridBagLayout());
        this.setTitle("Snake!");
        this.setSize(500, 550);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(icon.getImage());
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.addKeyListener(this);
        this.add(gpanel, constraints);
        constraints.gridy = 1;
        this.add(ipanel, constraints);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT && !(GamePanel.snakeDirection.equals("EAST")))
            GamePanel.snakeDirection = "WEST";
        else if (e.getKeyCode() == KeyEvent.VK_A && !(GamePanel.snakeDirection.equals("EAST")))
            GamePanel.snakeDirection = "WEST";
        else if (e.getKeyCode() == KeyEvent.VK_UP && !(GamePanel.snakeDirection.equals("SOUTH")))
            GamePanel.snakeDirection = "NORTH";
        else if (e.getKeyCode() == KeyEvent.VK_W && !(GamePanel.snakeDirection.equals("SOUTH")))
            GamePanel.snakeDirection = "NORTH";
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT && !(GamePanel.snakeDirection.equals("WEST")))
            GamePanel.snakeDirection = "EAST";
        else if (e.getKeyCode() == KeyEvent.VK_D && !(GamePanel.snakeDirection.equals("WEST")))
            GamePanel.snakeDirection = "EAST";
        else if (e.getKeyCode() == KeyEvent.VK_DOWN && !(GamePanel.snakeDirection.equals("NORTH")))
            GamePanel.snakeDirection = "SOUTH";
        else if (e.getKeyCode() == KeyEvent.VK_S && !(GamePanel.snakeDirection.equals("NORTH")))
            GamePanel.snakeDirection = "SOUTH";
        else if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
            if (GamePanel.playing) {
                GamePanel.playing = false;
            } else {
                GamePanel.playing = true;
            }
    }

    @Override
    public void keyTyped(KeyEvent e) {/* Not to be used */}

    @Override
    public void keyReleased(KeyEvent e) {/* Not to be used */}
}
