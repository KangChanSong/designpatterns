package algorithm;

import java.util.*;

public class DijkstrasAlgorithm {

    static void find_lowest_cost(){

        /**
         * 그래프
         */
        HashMap<String, HashMap> graph = new HashMap<>();
        //출발점
        HashMap<String, Integer> start = new HashMap<>();
        start.put("a", 6);
        start.put("b", 2);
        graph.put("start", start);
        // A
        HashMap<String, Integer> a = new HashMap<>();
        a.put("fin", 1);
        graph.put("a", a);
        // B
        HashMap<String, Integer> b= new HashMap<>();
        b.put("a", 3);
        b.put("fin", 5);
        graph.put("b", b);
        //도착점
        HashMap<String, Integer> fin = new HashMap<>();
        graph.put("fin" , fin);
        /**
         * 비용
         */
        HashMap<String, Integer> costs = new HashMap<>();
        costs.put("a",6);
        costs.put("b",2);
        costs.put("fin", Integer.MAX_VALUE - 1);

        /**
         * 부모
         */
        HashMap<String, String> parents = new HashMap<>();
        parents.put("a", "start");
        parents.put("b", "start");
        parents.put("fin", "");

        /**
         * 1. 가장 싼 정점을 찾는다
         * 2. 그 정점의 모든 이웃과의 거리를 계산한다(출발점에서부터의 )
         * 3. 출발점에서의 거리에서 더 싼 이웃이 잇으면 그 값을 갱신한다.
         * 4. 부모를 새로 갱신한다.
         */
        ArrayList<String> processed = new ArrayList<>();
        String node = findLowestCostNode(costs, processed);

        while (!node.equals("")){

            int cost = costs.get(node);
            HashMap<String, Integer> neighbors = graph.get(node);

            for(String n : neighbors.keySet()){
                int newCost = cost + neighbors.get(n);
                if(costs.get(n) > newCost){
                    costs.put(node, cost);
                    parents.put(n, node);
                }
            }

            processed.add(node);
            node = findLowestCostNode(costs, processed);
        }

        System.out.println(parents.toString());
    }

    static String findLowestCostNode(HashMap<String, Integer> map, ArrayList<String> processed){

        Set<String> strings = map.keySet();
        String result = "";
        int min = Integer.MAX_VALUE;

        for(String s : strings){
            if(map.get(s) < min && !processed.contains(s)){
                result = s;
                min = map.get(s);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        find_lowest_cost();

    }
}
