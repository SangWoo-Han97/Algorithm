import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        HashMap<String, Integer> phones = new HashMap();
        
        for(int i = 0; i < phone_book.length; i++) {
            phones.put(phone_book[i], i);        
        }
        
        for(int i= 0; i<phone_book.length; i++) {
            for(int j = 1; j<phone_book[i].length(); j++) {
                if(phones.containsKey(phone_book[i].substring(0, j))) {
                    return false;
                }
            }
        }
        
        
        return true;
    }
}