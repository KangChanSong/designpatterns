package algorithm;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BFS2 {

    static HashMap<String, String[]> map = new HashMap<>();

    static void findMafia(HashMap<String ,String[]> map){

        Queue<String> queue = new LinkedList();
        for (String name: map.get("송강찬")) {
            queue.add(name);
        }
        Queue<String> searched = new LinkedList();

        while (queue.size() > 0){
            String target = queue.poll();

            if(!searched.contains(target)){
                searched.add(target);
                if(target.substring(0, 1).equals("강")){
                    System.out.println(target + "이(가) 마피아입니다.");
                    return;
                } else {
                    String[] neighbors = map.get(target);
                    if(neighbors != null) {
                        for (String neighbor : neighbors) {
                            queue.add(neighbor);
                        }
                    }
                }

            }
        }

        System.out.println("마피아가 없습니다.");
    }

    public static void main(String[] args) {
        map.put("송강찬", new String[]{"장해수", "김재형", "이준영"});
        map.put("장해수", new String[]{"이창한", "강기호", "강영길"});
        map.put("김재형", new String[]{"강영길", "황금성"});
        map.put("이준영", new String[]{"윤재성", "박성민", "곽민주"});

        findMafia(map);
    }
}
