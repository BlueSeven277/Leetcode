package N76_MinWindomSubstring;

import java.util.*;

/**
 * template
 int findSubstring(string s){
 vector<int> map(128,0);
 int counter; // check whether the substring is valid
 int begin=0, end=0; //two pointers, one point to tail and one  head
 int d; //the length of substring

 for() { // initialize the hash map here  }

        while(end<s.size()){

        if(map[s[end++]]-- ?){  // modify counter here  }

        while(// counter condition ){
                 // update d here if finding minimum
        //increase begin to make it invalid/valid again

        if(map[s[begin++]]++ ?){ //modify counter here }
        }

            // update d here if finding maximum
        }
        return d;
        }
        */
public class min_window_substring {
    public static String minWindow(String s, String t) {
        int[] map = new int[128];
        int count = t.length();
        int res = Integer.MAX_VALUE;
        for(int i = 0;i<t.length();i++)
            map[t.charAt(i)-'A']++;
        int left = 0, right = 0, head = 0;
        while (right<s.length()){
            if (count>0 && map[s.charAt(right++)-'A']-->0){
                count--;
            }
            while (count==0){
                if (right-left<res){
                    res = right-left;
                    head = left;
                }
                if (map[s.charAt(left++)-'A']++==0){
                    count++;
                }
            }
        }
        return res==Integer.MAX_VALUE ? "":s.substring(head,head+res);

    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.print(minWindow(s,t));
    }
}
