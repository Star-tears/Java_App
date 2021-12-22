package work.DataInfo;

public class UserScore implements Comparable {
    private String name;
    private int score;

    public UserScore(String _name, int _score) {
        this.name = _name;
        this.score = _score;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
