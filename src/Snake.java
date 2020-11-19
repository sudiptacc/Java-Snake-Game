
public class Snake {

    public static void main(String[] args) {
       GameWindow window = new GameWindow();
        while (true) {
            InfoPanel.score.setText("Score: " + GamePanel.score);
            InfoPanel.direction.setText(GamePanel.snakeDirection);
        }
    }
}
