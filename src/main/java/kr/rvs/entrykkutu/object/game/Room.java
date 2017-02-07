package kr.rvs.entrykkutu.object.game;

/**
 * Created by Junhyeong Lim on 2017-02-07.
 */
public class Room extends GameObject {
    protected int id;
    protected String channel;
    protected String title;
    protected boolean password;
    protected int limit;
    protected int mode;
    protected int round;
    protected int time;
    protected String master;
    protected Object[] players;
    protected boolean gaming;
    protected UserState game;
    protected boolean practice;
    protected RoomOption opts;
//    private Map<String, > readies;

    public int getId() {
        return id;
    }

    public String getChannel() {
        return channel;
    }

    public String getTitle() {
        return title;
    }

    public boolean isPassword() {
        return password;
    }

    public int getLimit() {
        return limit;
    }

    public int getMode() {
        return mode;
    }

    public int getRound() {
        return round;
    }

    public int getTime() {
        return time;
    }

    public String getMaster() {
        return master;
    }

    public Object[] getPlayers() {
        return players;
    }

    public boolean isGaming() {
        return gaming;
    }

    public UserState getGame() {
        return game;
    }

    public boolean isPractice() {
        return practice;
    }

    public RoomOption getOpts() {
        return opts;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPassword(boolean password) {
        this.password = password;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public void setPlayers(Object[] players) {
        this.players = players;
    }

    public void setGaming(boolean gaming) {
        this.gaming = gaming;
    }

    public void setGame(UserState game) {
        this.game = game;
    }

    public void setPractice(boolean practice) {
        this.practice = practice;
    }

    public void setOpts(RoomOption opts) {
        this.opts = opts;
    }
}
