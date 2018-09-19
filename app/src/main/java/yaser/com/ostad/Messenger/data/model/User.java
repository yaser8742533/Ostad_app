package yaser.com.ostad.Messenger.data.model;


import yaser.com.ostad.Messenger.commons.models.IUser;

/*
 * Created by troy379 on 04.04.17.
 */
public class User implements IUser {

    private String id;
    private String name;
    private Integer avatar;
    private boolean online;

    public User(String id, String name, Integer avatar, boolean online) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.online = online;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Integer getAvatar() {
        return avatar;
    }

    public boolean isOnline() {
        return online;
    }
}
