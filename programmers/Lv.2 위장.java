import java.util.*;

class Solution {
    public int solution(String[][] clothes) {      
        HashMap <String, ArrayList<String>> map = new HashMap();
        
        for(int i = 0; i<clothes.length; i++) {
            if(!map.containsKey(clothes[i][1])) {
                map.put(clothes[i][1], new ArrayList());
            }
            map.get(clothes[i][1]).add(clothes[i][0]);
        }
        
        System.out.println(map);
        
        Set<String> set = map.keySet();
        int answer = 1;
        for(String str : set) {
            System.out.println(map.get(str).size());
            answer *= (map.get(str).size() + 1);
        }
        
        return answer-1;
    }
}