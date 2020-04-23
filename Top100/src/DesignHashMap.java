import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class DesignHashMap {


    List<Pair> map;

    /** Initialize your data structure here. */
    public DesignHashMap() {
        map = new ArrayList<>();
    }

    public static void main(String [] args){
        DesignHashMap hashMap = new DesignHashMap();

        hashMap.put(1, 1);
        hashMap.put(2, 2);
        System.out.println(hashMap.get(1));
        System.out.println(hashMap.get(3));

        hashMap.put(2, 1);          // update the existing value
        System.out.println(hashMap.get(2));
                   // returns 1
        hashMap.remove(2);          // remove the mapping for 2
        System.out.println(hashMap.get(2));
                  // returns -1 (not found)
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        Pair<Integer, Integer>  pair = new Pair(key, value);

        for(Pair newPoint: map){
            if((int)newPoint.getKey() == key){

                map.remove(newPoint);
                break;
            }

        }

        map.add(pair);
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        for(Pair newPoint: map){
            if((int)newPoint.getKey() == key){
                return (int)newPoint.getValue();
            }
        }

        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        for(Pair newPoint: map){
            if((int)newPoint.getKey() == key){
                map.remove(newPoint);
                break;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */