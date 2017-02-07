package kr.rvs.entrykkutu.object.game;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Junhyeong Lim on 2017-02-07.
 */
public class Record extends GameObject {
    @SerializedName("EKT")
    private int[] 영어끄투;
    @SerializedName("ESH")
    private int[] 영어끝말잇기;
    @SerializedName("KKT")
    private int[] 한국어쿵쿵따;
    @SerializedName("KSH")
    private int[] 한국어끝말잇기;
    @SerializedName("CSQ")
    private int[] 자음퀴즈;
    @SerializedName("KCW")
    private int[] 한국어십자말풀이;
    @SerializedName("KTY")
    private int[] 한국어타자대결;
    @SerializedName("KAP")
    private int[] 한국어앞말잇기;
    @SerializedName("HUN")
    private int[] 훈민정음;
    @SerializedName("KDA")
    private int[] 한국어단어대결;
    @SerializedName("EDA")
    private int[] 영어단어대결;
    @SerializedName("KSS")
    private int[] 한국어솎솎;
    @SerializedName("KSS")
    private int[] 영어솎솎;
}
