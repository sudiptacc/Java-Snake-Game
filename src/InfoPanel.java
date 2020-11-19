import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JPanel {

    public static JLabel score, info, direction;

    InfoPanel() {
        this.setPreferredSize(new Dimension(500, 50));
        this.setLayout(new GridLayout());
        this.setBackground(Color.BLACK);
        score = new JLabel("Score: 0", SwingConstants.CENTER);
        info = new JLabel("Snake!", SwingConstants.CENTER);
        direction = new JLabel("NONE", SwingConstants.CENTER);
        score.setForeground(Color.WHITE);
        info.setForeground(Color.WHITE);
        direction.setForeground(Color.WHITE);
        this.add(score);
        this.add(info);
        this.add(direction);
    }
}
