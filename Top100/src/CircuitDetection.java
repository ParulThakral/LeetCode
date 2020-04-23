import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CircuitDetection {

    public static void main(String [] args){
        List<List<Integer>> list=new ArrayList<>(){{
            add(new ArrayList<Integer>(){{
                add(0);
                add(1);
            }});
            add(new ArrayList<Integer>(){{
                add(1);
                add(2);

            }});
            add(new ArrayList<Integer>(){{
                add(2);
                add(0);

            }});
            add(new ArrayList<Integer>(){{
                add(1);
                add(3);

            }});
            add(new ArrayList<Integer>(){{
                add(3);
                add(0);

            }});

        }};
        System.out.println(new CircuitDetection().criticalConnections(4, list));
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        if(connections == null || n == 0){
            return null;
        }
        List<List<Integer>> resultList = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> subSetMap = new HashMap<>();

        for (List<Integer> collection : connections){
            map.put(collection.get(0), map.getOrDefault(collection.get(0), 0) + 1);
            map.put(collection.get(1), map.getOrDefault(collection.get(1), 0) - 1);
        }

        for (Integer key : map.keySet()){
            if (map.get(key)!=0){
                subSetMap.put(key, map.get(key));
            }
        }

        for (List<Integer> collection : connections){
            if(subSetMap.containsKey(collection.get(0)) && subSetMap.containsKey(collection.get(1))){
                resultList.add(collection);
            }
        }

        return resultList;
    }
}