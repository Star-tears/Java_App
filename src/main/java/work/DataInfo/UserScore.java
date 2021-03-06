package work.DataInfo;

public class UserScore implements Comparable {
    private String name;
    private int score;

    public UserScore(String _name, int _score) {
        this.name = _name;
        this.score = _score;
    }

    /**
     * 获取用户名
     *
     * @return 返回用户名
     */
    public String getName() {
        return name;
    }

    /**
     * 获取分数
     *
     * @return 返回分数
     */
    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof UserScore)) {
            throw new RuntimeException("不是UserScore对象");
        }
        UserScore p = (UserScore) o;
        if (this.score < p.score)
            return 1;
        if (this.score == p.score) {
            return this.name.compareTo(p.name);
        }
        return -1;
    }
}
