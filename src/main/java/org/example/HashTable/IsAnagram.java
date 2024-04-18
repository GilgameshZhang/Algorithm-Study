package org.example.HashTable;
/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 */
public class IsAnagram {
    //数组其实是一个特殊的散列表，存储了k-下标，value-值，
    // 其实就是将一个字符串里的字符映射到数组下标中
    //对于字母而言，其ASCII码就是天然的Int下标，只需要用字母-'a'就可以获得其相对于a的位置，从而加入数组中
    public boolean isAnagram(String s, String t) {
        int hashArray[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int m = s.charAt(i) - 'a';
            hashArray[m]++;
        }
        for (int i = 0; i < t.length(); i++) {
            int m = t.charAt(i) - 'a';
            hashArray[m]--;
        }
        for (int i = 0; i < hashArray.length; i++) {
            if (hashArray[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "car";
        String t = "cat";
        IsAnagram isAnagram = new IsAnagram();
        System.out.println(isAnagram.isAnagram(s, t));
    }
}
