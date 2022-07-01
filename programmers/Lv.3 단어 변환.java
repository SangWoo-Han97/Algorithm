import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {       
        boolean equal = false;
        for(int i = 0; i<words.length; i++) {
            if(target.equals(words[i])) {
                equal = true;
                break;
            }
        }
        if(!equal) {
            return 0;
        }
        
        int answer = bfs(begin, target, words);               
        
        return answer;
    }
    
    static int bfs(String begin, String target, String[] words) {
        Queue<Node> q = new LinkedList<Node>();
        boolean[] visited = new boolean[words.length];
        
        q.offer(new Node(begin, 0));
        
        while(!q.isEmpty()) {
            Node node = q.poll();
            
            if(node.word.equals(target))
                return node.cnt;
            
            for(int i = 0; i<words.length; i++) {
                if(visited[i]) continue;
                if(changeable(node.word, words[i])) {
                    q.offer(new Node(words[i], node.cnt + 1));
                    visited[i] = true;
                }
            }
        }        

        return 0;        
    }
    
    static boolean changeable(String from, String to) {
        int cnt = 0;
        
        for(int i = 0; i<to.length(); i++) {
            if(from.charAt(i) != to.charAt(i)){
                cnt++;
            }
        }
        
        if(cnt == 1) {
            return true;
        }
        return false;
    }
}

class Node {
    String word;
    int cnt;
    
    Node(String word, int cnt) {
        this.word = word;
        this.cnt = cnt;
    }
}