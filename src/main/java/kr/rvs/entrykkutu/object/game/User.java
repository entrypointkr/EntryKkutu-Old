package kr.rvs.entrykkutu.object.game;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

/**
 * Created by Junhyeong Lim on 2017-02-07.
 */
public class User extends GameObject {
    private String id;
    private boolean guest;
    @SerializedName("game")
    private UserState state;
    private Profile profile;
    private int place;
    private UserData data;
    private int money;
    private Map<String, String> equip;
    private String exordial;
}
