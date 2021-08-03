package algorithm;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BreadthFirstSearch {
    //그래프를 해시테이블로 구현
    static HashMap<String , String[]> map = new HashMap<>();

    static void bfs(HashMap<String, String[]> map){


        Queue<String> search_queue = new LinkedList();
        for (String name: map.get("you")) {
            search_queue.add(name);
        }

        Queue searched = new LinkedList(); // 확인한 사람을 넣을 큐

        while (search_queue.size() > 0){
            // search_queue 를 pop
            String target = search_queue.poll();

            // 만약 이미 확인한 사람이 아니면
            if(!searched.contains(target)){
                //확인한 사람 목록에 추가
                searched.add(target);
                // mango seller 인지 확인
                if(isMangoSeller(target)){
                    System.out.println(target + " 이 망고 판매상입니다!");
                    return;
                }
                // 아니라면 search_queue 모든 이웃들을 추가
                else
                {
                    String[] neighbors = map.get(target);
                    if(neighbors != null) {
                        for (String neighbor : neighbors) {
                            search_queue.add(neighbor);
                        }
                    }
                }
            }
        }

        System.out.println("망고 판매상이 없습니다ㅠ");
        // 해당 큐가 mango seller 가 아니면 그 큐의 자식들을 추가
    }

    static boolean isMangoSeller(String name){

        return name == "thome" ? true : false;
    }

    public static void main(String[] args) {

        //map 에 그래프를 구현
        map.put("you", new String[]{"alice", "bob", "claire"});
        map.put("bob", new String[]{"anuj", "peggy"});
        map.put("alice", new String[]{"peggy"});
        map.put("claire", new String[]{"thome", "johnny"});
        map.put("anuj", new String[]{});
        map.put("peggy", new String[]{});
        map.put("thome", new String[]{});
        map.put("johnny", new String[]{});

        bfs(map);
    }
}
