import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Jamie on 13/12/14.
 */

public class HighScore implements Serializable {

    private int score;
    private String name;


    public HighScore(int score, String name) {

        setName(name);
        setScore(score);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}
