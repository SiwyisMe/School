package com.siwy.zad3;
public class User {
    private String name;
    private int avatarId;

    public User(String name, int avatarId) {
        this.name = name;
        this.avatarId = avatarId;
    }

    public String getName() { return name; }
    public int getAvatarId() { return avatarId; }
}
