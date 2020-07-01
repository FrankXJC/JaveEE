package cn.domain;


/**
 * 用户
 */
public class User {
    private Integer uid;
    private String username;
    private String password;
    private String name;
    private String sex;
    private int age;
    private String phonenumber;
    private String address;
    private Character status;
    private String ramarks;


    @Override
    public String toString() {
        return "User{" +
                "id=" +uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", phoneNumber='" +phonenumber + '\'' +
                ", address='" + address + '\'' +
                ", status=" + status +
                ", ramarks='" + ramarks + '\'' +
                '}';
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phonenumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phonenumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public String getRamarks() {
        return ramarks;
    }

    public void setRamarks(String ramarks) {
        this.ramarks = ramarks;
    }
}
