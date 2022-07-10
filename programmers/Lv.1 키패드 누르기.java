import java.util.*;

class Solution {
    static Point[] keypad;
    static Point leftHand, rightHand;
    static StringBuffer answer;
    
    public String solution(int[] numbers, String hand) {
        keypad = new Point[10];
        keypad[0] = new Point(3, 1);
        for(int i = 1; i <= 9; i++) {
            keypad[i] = new Point((i-1)/3, (i-1)%3);
        } 
        
        leftHand = new Point(3, 0);
        rightHand = new Point(3, 2);
        
        answer = new StringBuffer();
        
        for(int number : numbers) {
            clickKeypad(number, hand);   
        }       
        
        return answer.toString();
    }
    
    static void clickKeypad(int number, String hand) {
        switch(number) {
            case 1:
            case 4:
            case 7: 
                answer.append("L");
                leftHand.move(keypad[number]);
                break;
            case 3:
            case 6:
            case 9: 
                answer.append("R"); 
                rightHand.move(keypad[number]);
                break;
            default: answer.append(findFinger(number, hand)); break;
        }
    }
    
    static String findFinger(int number, String hand) {
        int leftDistance = calculateDistance(keypad[number], leftHand);
        int rightDistance = calculateDistance(keypad[number], rightHand);
        
        if(leftDistance < rightDistance) {
            leftHand.move(keypad[number]);
            return "L";
        } else if(leftDistance > rightDistance) {
            rightHand.move(keypad[number]);
            return "R";
        } else {
            if(hand.equals("left")) {
                leftHand.move(keypad[number]);
                return "L";
            } else {
                rightHand.move(keypad[number]);
                return "R";
            }
        }
    }
    
    static int calculateDistance(Point from, Point to) {
        int distance = 0;
        distance += Math.abs(from.x - to.x);
        distance += Math.abs(from.y - to.y);
        return distance;
    }
}

class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void move(Point p) {
        this.x = p.x;
        this.y = p.y;
    }
}