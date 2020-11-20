import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Snake => GameWindow => LaunchWindow => GameWindow
public class LaunchWindow extends JFrame implements ActionListener {

    GridBagConstraints constraints;
    ButtonGroup group;
    JRadioButton easy, medium, hard;
    JButton confirm;
    JPanel panel;

    LaunchWindow() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println("ERROR:" + e.getMessage());
        }
        constraints = new GridBagConstraints();
        group = new ButtonGroup();
        easy = new JRadioButton("Easy");
        medium = new JRadioButton("Medium");
        hard = new JRadioButton("Hard");
        confirm = new JButton("Play!");
        confirm.addActionListener(this);
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        panel.add(easy, constraints);
        constraints.gridy = 1;
        panel.add(medium, constraints);
        constraints.gridy = 2;
        panel.add(hard, constraints);
        constraints.gridy = 3;
        panel.add(confirm, constraints);
        group.add(easy);
        group.add(medium);
        group.add(hard);
        this.setTitle("Choose a difficulty!");
        this.setSize(200, 250);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.add(panel);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (easy.isSelected()) {
            GamePanel.difficulty = 100;
            new GameWindow();
            this.dispose();
        } else if (medium.isSelected()) {
            GamePanel.difficulty = 75;
            new GameWindow();
            this.dispose();
        } else if (hard.isSelected()) {
            GamePanel.difficulty = 50;
            new GameWindow();
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Please select a difficulty to play at!");
        }
    }
}
