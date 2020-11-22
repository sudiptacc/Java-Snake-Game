import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JPanel {

    private static final long serialVersionUID = -2672022111178171467L;
    public static JLabel score = new JLabel("Score: 0", SwingConstants.CENTER), 
                         highscore = new JLabel("Highscore: 0", SwingConstants.CENTER);

    InfoPanel() {
        this.setPreferredSize(new Dimension(500, 50));
        this.setLayout(new GridLayout());
        this.setBackground(Color.BLACK);
        score.setForeground(Color.WHITE);
        highscore.setForeground(Color.WHITE);
        this.add(score);
        this.add(highscore);
    }
}
