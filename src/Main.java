
public class Main {
    public static void main(String[] args) {
        new LaunchWindow();
        while (true) {
            InfoPanel.score.setText("Score: " + GamePanel.score);
            InfoPanel.highscore.setText("Highscore: " + GamePanel.highscore);
            if (GamePanel.score > GamePanel.highscore) 
                GamePanel.highscore = GamePanel.score;
        }
    }
}
