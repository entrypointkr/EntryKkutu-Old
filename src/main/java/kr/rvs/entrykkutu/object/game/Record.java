package kr.rvs.entrykkutu.object.game;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Junhyeong Lim on 2017-02-07.
 */
public class Record extends GameObject {
    @SerializedName("EKT")
    private long[] 영어끄투;
    @SerializedName("ESH")
    private long[] 영어끝말잇기;
    @SerializedName("KKT")
    private long[] 한국어쿵쿵따;
    @SerializedName("KSH")
    private Object[] 한국어끝말잇기;
    @SerializedName("CSQ")
    private long[] 자음퀴즈;
    @SerializedName("KCW")
    private long[] 한국어십자말풀이;
    @SerializedName("KTY")
    private long[] 한국어타자대결;
    @SerializedName("KAP")
    private long[] 한국어앞말잇기;
    @SerializedName("HUN")
    private long[] 훈민정음;
    @SerializedName("KDA")
    private long[] 한국어단어대결;
    @SerializedName("EDA")
    private long[] 영어단어대결;
    @SerializedName("KSS")
    private long[] 한국어솎솎;
    @SerializedName("ESS")
    private long[] 영어솎솎;
}
