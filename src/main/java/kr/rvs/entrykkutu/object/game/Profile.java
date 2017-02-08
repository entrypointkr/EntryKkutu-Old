package kr.rvs.entrykkutu.object.game;

/**
 * Created by Junhyeong Lim on 2017-02-07.
 */
public class Profile extends GameObject {
    private String token;
    private String type;
    private String id;
    private String name;
    private String title;
    private String image;
    private boolean isAjae;
    private String sid;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isAjae() {
        return isAjae;
    }

    public void setAjae(boolean ajae) {
        isAjae = ajae;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }
}
