//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/48.%20%E6%9C%80%E9%95%BF%E4%B8%8D%E5%90%AB%E9%87%8D%E5%A4%8D%E5%AD%97%E7%AC%A6%E7%9A%84%E5%AD%90%E5%AD%97%E7%AC%A6%E4%B8%B2.md
//剑指48. 最长不含重复字符的子字符串
//输入一个字符串（只包含 a~z 的字符），求其最长不含重复字符的子字符串的长度。例如对于 arabcacfr，最长不含重复字符的子字符串为 acfr，长度为 4。

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutDuplication {
    public int longestSubStringWithoutDuplication(String str){
        int curLen = 0;
        int maxLen = 0;
        int[] preIndexs = new int[26];
        Arrays.fill(preIndexs,-1);
        for(int curI=0;curI<str.length();curI++) {
            int c = str.charAt(curI) - 'a';
            int preI = preIndexs[c];
            if (preI == -1 || curI - preI > curLen) {
                curLen++;
            } else {
                maxLen = Math.max(maxLen, curLen);
                curLen = curI - preI;
            }
            preIndexs[c] = curI;
        }
        maxLen = Math.max(maxLen,curLen);
        return maxLen;
    }

    //法2双指针：来源：https://github.com/heshangcode/LeetCodeAndJianZhiOffer/blob/master/src/com/hs/JianZhiOffer/%E5%AD%97%E7%AC%A6%E4%B8%B2/%E6%9C%80%E9%95%BF%E4%B8%8D%E5%90%AB%E9%87%8D%E5%A4%8D%E5%AD%97%E7%AC%A6%E7%9A%84%E5%AD%90%E5%AD%97%E7%AC%A6%E4%B8%B2Solution1.java
    public int longestSubStringWithoutDuplication2(String s){
        if(s==null||s.length()==0){
            return 0;
        }
        int left = 0,right = -1;//[i,j]
        int res = 0;
        int[] nums = new int[256]; //存字符出现的次数
        while (left<s.length()){
            //判断字符有没有出现过
            if(right+1<s.length()&&nums[s.charAt(right+1)]==0){
                right++;
                nums[s.charAt(right)]++;
            }else{
                //出现过了，把左边出现的值取消一次，然后左边进行右移
                nums[s.charAt(left)]--;
                left++;
            }
            res = Math.max(res,right-left+1);
        }
        return res;
    }

    //法3，哈希表，来源：https://github.com/heshangcode/LeetCodeAndJianZhiOffer/blob/master/src/com/hs/JianZhiOffer/%E5%AD%97%E7%AC%A6%E4%B8%B2/%E6%9C%80%E9%95%BF%E4%B8%8D%E5%90%AB%E9%87%8D%E5%A4%8D%E5%AD%97%E7%AC%A6%E7%9A%84%E5%AD%90%E5%AD%97%E7%AC%A6%E4%B8%B2Solution2.java
    public int longestSubStringWithoutDuplication3(String s){
        if(s==null||s.length()==0){
            return 0;
        }
        int res=0;
        Map<Character,Integer> map = new HashMap<>();
        //定义一个map数据结构存储(k,v)，其中key值为字符，value值为字符位置+1，加1表示从字符位置后一个才开始不重复
        for(int i=0,j=0;j<s.length();j++){
            char alpha = s.charAt(j);
            if(map.containsKey(alpha)){
                i = Math.max(map.get(alpha),i);
            }
            res = Math.max(res,j-i+1);
            map.put(s.charAt(j),j+1);
        }
        return res;
    }

    public static void main(String[] args) {
        LongestSubStringWithoutDuplication longestSubString = new LongestSubStringWithoutDuplication();
        String str = "arabcacfr";
        int res = longestSubString.longestSubStringWithoutDuplication3(str);
        System.out.println(res);
    }
}
