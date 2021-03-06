import java.awt.*;

enum Direction {UP, DOWN, LEFT, RIGHT}


public class Snake {
    final int[] x = new int[GamePanel.GAME_UNITS];
    final int[] y = new int[GamePanel.GAME_UNITS];
    int bodyParts;
    int score;
    Color c;
    Direction direction;

    Snake() {
        bodyParts = 2;
        c = new Color(69, 255, 69);
        direction = Direction.DOWN;
    }

    public void move() {
        //shifts body parts one by one
        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }
        switch (direction) {
            case UP -> y[0] = y[0] - GamePanel.UNIT_SIZE;
            case DOWN -> y[0] = y[0] + GamePanel.UNIT_SIZE;
            case LEFT -> x[0] = x[0] - GamePanel.UNIT_SIZE;
            case RIGHT -> x[0] = x[0] + GamePanel.UNIT_SIZE;
        }
    }

    public boolean checkCollisions() {      //checks if collision occurs:
        //with its body
        for (int i = bodyParts; i > 0; i--) {
            if ((x[0] == x[i] && y[0] == y[i])) {
                return true;
            }
        }
        //with left border
        if (x[0] < 0)
            return true;

        //with right border
        if (x[0] > GamePanel.SCREEN_WIDTH - GamePanel.UNIT_SIZE)
            return true;

        //with upper border
        if (y[0] < 0)
            return true;

        //with downer border
        return y[0] > GamePanel.SCREEN_HEIGHT - GamePanel.UNIT_SIZE;
    }
}
