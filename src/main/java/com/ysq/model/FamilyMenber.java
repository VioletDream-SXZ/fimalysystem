package com.ysq.model;

public class FamilyMenber {
    private int id;
    private int userId;
    private String name;
    private String sex;
    private String birthday;
    private int point;

    public FamilyMenber(int id, int userId, String name, String sex, String birthday, int point) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.point = point;
    }

    public FamilyMenber(int id, int userId) {
        this(id, userId, "None", "男", "1990.01.01", 0);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setSex(String sex) throws Exception {
        if(!sex.equals("男") && !sex.equals("女")) {
            throw new Exception("性别只有男和女.");
        }
        this.sex = sex;
    }

    public String getSex() {
        return this.sex;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getPoint() {
        return this.point;
    }
}
