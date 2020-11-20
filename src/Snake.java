
public class Snake {

    public static void main(String[] args) {
        new LaunchWindow();
        while (true) {
            InfoPanel.score.setText("Score: " + GamePanel.score);
            InfoPanel.direction.setText(GamePanel.snakeDirection);
        }
    }
}
