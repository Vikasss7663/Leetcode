import java.util.HashMap;

/*
 * @lc app=leetcode id=12 lang=java
 *
 * [12] Integer to Roman
 */

// @lc code=start
class Solution {

    public String nTimeString(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++) sb.append(s);
        return sb.toString();
    }

    public String getRomanValue(int num, HashMap<Integer, String> map) {
        
        if(map.containsKey(num)) return map.get(num);
        
        if(num > 1 && num < 5) {
            if(num==4) return map.get(5) + map.get(1);
            else return nTimeString(map.get(1), num/1);
        } 
        else if(num > 5 && num < 10) {
            if(num==9) return map.get(10) + map.get(1);
            else return nTimeString(map.get(1), num-5) + map.get(5);
        } 
        else if(num > 10 && num < 50) {
            if(num==40) return map.get(50) + map.get(10);
            else return nTimeString(map.get(10), num/10);
        } 
        else if(num > 50 && num < 100) {
            if(num==90) return map.get(100) + map.get(10);
            else return nTimeString(map.get(10), (num-50)/10) + map.get(50);
        } 
        else if(num > 100 && num < 500) {
            if(num==400) return map.get(500) + map.get(100);
            else return nTimeString(map.get(100), num/100);
        } 
        else if(num > 500 && num < 1000) {
            if(num==900) return map.get(1000) + map.get(100);
            else return nTimeString(map.get(100), (num-500)/100) + map.get(500);
        }
        else {
            // num > 1000 && num < 4000
            return nTimeString(map.get(1000), num/1000);
        }

    }
    public String intToRoman(int num) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
        int dec = 1;
        StringBuilder res = new StringBuilder();
        while(num > 0) {
            int rem = num%10;
            if(rem != 0)
                res.append(getRomanValue(dec*rem, map));
            num /= 10;
            dec *= 10;
        }
        return res.reverse().toString();
    }
}
// @lc code=end

