package kr.rvs.entrykkutu.object.game;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Junhyeong Lim on 2017-02-07.
 */
public class Record extends GameObject {
    @SerializedName("EKT")
    private Object[] 영어끄투;
    @SerializedName("ESH")
    private Object[] 영어끝말잇기;
    @SerializedName("KKT")
    private Object[] 한국어쿵쿵따;
    @SerializedName("KSH")
    private Object[] 한국어끝말잇기;
    @SerializedName("CSQ")
    private Object[] 자음퀴즈;
    @SerializedName("KCW")
    private Object[] 한국어십자말풀이;
    @SerializedName("KTY")
    private Object[] 한국어타자대결;
    @SerializedName("KAP")
    private Object[] 한국어앞말잇기;
    @SerializedName("HUN")
    private Object[] 훈민정음;
    @SerializedName("KDA")
    private Object[] 한국어단어대결;
    @SerializedName("EDA")
    private Object[] 영어단어대결;
    @SerializedName("KSS")
    private Object[] 한국어솎솎;
    @SerializedName("ESS")
    private Object[] 영어솎솎;
}
