package kr.rvs.entrykkutu.object.game;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

/**
 * Created by Junhyeong Lim on 2017-02-07.
 */
public class User extends GameObject {
    private String id;
    @SerializedName("game")
    private UserState game;
    private Profile profile;
    private int place;
    private UserData data;
    private int money;
    private Map<String, String> equip;
    private String exordial;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserState getGame() {
        return game;
    }

    public void setGame(UserState game) {
        this.game = game;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public UserData getData() {
        return data;
    }

    public void setData(UserData data) {
        this.data = data;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Map<String, String> getEquip() {
        return equip;
    }

    public void setEquip(Map<String, String> equip) {
        this.equip = equip;
    }

    public String getExordial() {
        return exordial;
    }

    public void setExordial(String exordial) {
        this.exordial = exordial;
    }
}
