//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/44.%20%E6%95%B0%E5%AD%97%E5%BA%8F%E5%88%97%E4%B8%AD%E7%9A%84%E6%9F%90%E4%B8%80%E4%BD%8D%E6%95%B0%E5%AD%97.md
//剑指44. 数字序列中的某一位数字
//数字以 0123456789101112131415... 的格式序列化到一个字符串中，
// 求这个字符串的第 index 位。
//未理解
public class GetDigitAtIndex {
    public int getDigitAtIndex(int index){
        if(index<0)
            return -1;
        int place = 1; //1表示个位，2表示十位
        while (true){
            int amount = getAmountOfPlace(place);
            int totalAmount = amount*place;
            if(index<totalAmount)
                return getDigitAtIndex(index,place);
            index -= totalAmount;
            place++;
        }
    }
    /*
    place位数的数字组成的字符串长度
    10, 90, 900，...
     */
    private int getAmountOfPlace(int place){
        if(place==1)
            return 10;
        return  (int)Math.pow(10,place-1)*9;
    }
    /**
     * place位数的起始数字
     * 0，10，100，...
     */
    private int getBeginNumberOfPlace(int place){
        if(place==1)
            return 0;
        return (int)Math.pow(10,place-1);
    }
    /**
     * 在place位数组成的字符串中，第index个数
     */
    private int getDigitAtIndex(int index,int place){
        int beginNumber = getBeginNumberOfPlace(place);
        int shiftNumber = index/place;
        String number = (beginNumber+shiftNumber)+"";
        int count = index%place;
        return number.charAt(count)-'0';
    }

    public static void main(String[] args) {
        GetDigitAtIndex getDigit = new GetDigitAtIndex();

        int digit = getDigit.getDigitAtIndex(15);
        System.out.println(digit);
    }
}
