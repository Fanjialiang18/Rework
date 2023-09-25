package main.Java.HuiSu;

import java.util.*;

public class LeetCode332 {

    List<String> ans;

    LinkedList<String> path;
    public List<String> findItinerary(List<List<String>> tickets) {
        ans = new ArrayList<>();
        path = new LinkedList<>();
        tickets.sort(Comparator.comparing(o -> o.get(1))); // 按目的地进行排序
        path.add("JFK");
        boolean[] used = new boolean[tickets.size()];
        backTrace((ArrayList) tickets, used);
        return ans;
    }

    private boolean backTrace(ArrayList<List<String>> tickets, boolean[] used){
        if(path.size() == tickets.size() + 1){
            ans = new ArrayList<>(path);
            return true;
        }
        for (int i = 0; i < tickets.size(); i++) {
            if(!used[i] && tickets.get(i).get(0).equals(path.getLast())){
                    path.add(tickets.get(i).get(1));
                    used[i] = true;
                    if(backTrace(tickets, used)){
                        return true;
                    }
                    used[i] = false;
                    path.removeLast();
            }
        }
        return false;
    }
}
