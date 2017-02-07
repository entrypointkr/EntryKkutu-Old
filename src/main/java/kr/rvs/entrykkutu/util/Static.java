package kr.rvs.entrykkutu.util;

/**
 * Created by Junhyeong Lim on 2017-02-08.
 */
public class Static {
    public static String str(Object obj) {
        return String.valueOf(obj);
    }

    public static int anInt(Object obj) {
        return Integer.parseInt(str(obj));
    }


}
