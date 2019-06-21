package entity;

import android.media.Image;

/**
 * User Bean
 * param1 ID
 * param2  用户名
 * param3  性别
 * param4  年龄
 * param5  邮箱
 * param6  头像
 */
public class User {
    private int id;
    private String name;
    private int sex;
    private int age;
    private String email;
    private Image icon;

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setSex(int sex) {
        this.sex = sex;
    }
    public int getSex() {
        return sex;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }
    public void setIcon(Image icon) {
        this.icon = icon;
    }
    public Image getIcon() {
        return icon;
    }
}
