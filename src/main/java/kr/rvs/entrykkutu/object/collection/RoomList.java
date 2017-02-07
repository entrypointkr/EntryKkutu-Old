package kr.rvs.entrykkutu.object.collection;

import com.sun.javafx.collections.ObservableListWrapper;
import kr.rvs.entrykkutu.gui.item.RoomItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Junhyeong Lim on 2017-02-08.
 */
public class RoomList extends ObservableListWrapper<RoomItem> {
    public Map<Integer, Integer> indexMap = new HashMap<>();

    public RoomList(List<RoomItem> list) {
        super(list);
        int i = 0;
        for (RoomItem item : list) {
            indexMap.put(item.getId(), i++);
        }
    }

    @Override
    public boolean add(RoomItem roomItem) {
        indexMap.put(roomItem.getId(), size());
        return super.add(roomItem);
    }

    @Override
    public RoomItem remove(int index) {
        indexMap.remove(index);
        return super.remove(index);
    }
}
