//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/61.%20%E6%89%91%E5%85%8B%E7%89%8C%E9%A1%BA%E5%AD%90.md
//剑指61. 扑克牌顺子
//五张牌，其中大小鬼为癞子，牌面为 0。判断这五张牌是否能组成顺子。
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

public class PlayingCardStraight {
    public boolean isContinues(int[] nums) {
        if (nums.length < 5)
            return false;

        Arrays.sort(nums);

        //统计癞子数量
        int cnt = 0;
        for(int num:nums)
            if(num==0)
                cnt++;

        //使用癞子去补全不连续的顺子
        for(int i=cnt;i<nums.length-1;i++){
            if(nums[i+1]==nums[i])
                return false;
            cnt-=nums[i+1]-nums[i]-1;
        }

        return cnt>=0;
    }

    public static void main(String[] args) {
        PlayingCardStraight playingCardStraight = new PlayingCardStraight();
        int[] nums =  {1,0,3,4,5};
        boolean isStraight = playingCardStraight.isContinues(nums);
        System.out.println(isStraight);
    }


}
