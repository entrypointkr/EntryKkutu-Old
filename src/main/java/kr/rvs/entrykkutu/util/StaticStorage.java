package kr.rvs.entrykkutu.util;

/**
 * Created by Junhyeong Lim on 2017-02-09.
 */
public class StaticStorage {
    private static String id;

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        StaticStorage.id = id;
    }
}
