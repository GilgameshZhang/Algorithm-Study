package org.example.HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * 如果可以，返回 true ；否则返回 false 。
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 */
public class CanConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < magazine.length(); i++) {
            char cur = magazine.charAt(i);
            if (hashMap.containsKey(cur)) {
                int value = hashMap.get(cur);
                hashMap.put(cur,value+1);
            } else {
                hashMap.put(cur,1);
            }
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char cur = ransomNote.charAt(i);
            if (!hashMap.containsKey(cur)) {
                return false;
            } else {
                int value = hashMap.get(cur);
                if (value == 0) return false;
                hashMap.put(cur,value-1);
            }
        }
        return true;
    }
}
