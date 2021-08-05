package algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Greedy {

    public static void main(String[] args) {

        greedy();
    }

    private static void greedy() {
        Set<String> statesNeeded = new HashSet<>(Set.of("mt", "wa", "or", "id", "nv", "ut", "ca", "az"));
        HashMap<String, Set<String>> stations = new HashMap<>();

        stations.put("kone", Set.of("id","nv","ut"));
        stations.put("ktwo", Set.of("wa","id","mt"));
        stations.put("kthree", Set.of("or","nv","ca"));
        stations.put("kfour", Set.of("nv","ut"));
        stations.put("kfive", Set.of("ca","az"));

        Set<String> finalStations = new HashSet<>();

        while (statesNeeded.size() > 0 ){

            String bestStation = "";
            int statesCoveredCount = 0;
            for(String s : stations.keySet()){
                Set<String> stationsCovered = stations.get(s);
                int tempCount = 0;
                for(String sts : stationsCovered){
                    if(stationsCovered.contains(sts)){
                        tempCount++;
                    }
                }
                if(statesCoveredCount < tempCount){
                    bestStation = s;
                }
            }

            stations.get(bestStation).forEach(i -> statesNeeded.remove(i));
            stations.remove(bestStation);

            finalStations.add(bestStation);
        }

        System.out.println(finalStations.toString());
    }


}
