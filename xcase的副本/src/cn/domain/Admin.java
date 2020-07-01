package cn.domain;

/**
 * 管理员
 */
public class Admin {
    private Integer aid;
    private String a_name;
    private String a_password;

    public Admin(Integer aid, String a_name, String a_password) {
        this.aid = aid;
        this.a_name = a_name;
        this.a_password = a_password;
    }

    public Admin() {
    }

    @Override
    public String toString() {
        return "Admin{" +
                "aid=" + aid +
                ", a_name='" + a_name + '\'' +
                ", a_password='" + a_password + '\'' +
                '}';
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getA_name() {
        return a_name;
    }

    public void setA_name(String a_name) {
        this.a_name = a_name;
    }

    public String getA_password() {
        return a_password;
    }

    public void setA_password(String a_password) {
        this.a_password = a_password;
    }
}
