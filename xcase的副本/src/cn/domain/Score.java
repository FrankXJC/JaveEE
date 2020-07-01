package cn.domain;


/**
 * 分数
 *
 */
public class Score {
    private Integer sid;
    private Integer uid;
    private Integer pid;
    private Integer score;

    public Score() {
    }

    public Score(Integer uid, Integer pid, Integer score) {
        this.uid = uid;
        this.pid = pid;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Score{" +
                "sid=" + sid +
                ", uid=" + uid +
                ", pid=" + pid +
                ", score=" + score +
                '}';
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
