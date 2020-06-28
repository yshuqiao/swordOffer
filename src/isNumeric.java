//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/20.%20%E8%A1%A8%E7%A4%BA%E6%95%B0%E5%80%BC%E7%9A%84%E5%AD%97%E7%AC%A6%E4%B8%B2.md
//剑指20. 表示数值的字符串
//true
//"+100"
//"5e2"
//"-123"
//"3.1416"
//"-1E-16"

//false
//"12e"
//"1a3.14"
//"1.2.3"
//"+-5"
//"12e+4.3"

//思路：使用正则表达式进行匹配。
// []：字符集合
// ()：分组
// ?：重复0~1次
// +：重复1~n次
// *：重复0~n次
// .：任意字符
// \\.：转义后的.
// \\d：数字
public class isNumeric {
    public boolean isNumeric(char[] str){
        if(str==null||str.length==0)
            return false;
        return new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");

    }
    public static void main(String[] args) {
        char[] str= {'+','1','0','0'};
        isNumeric ismatch = new isNumeric();
        boolean tomatch = ismatch.isNumeric(str);
        System.out.println(tomatch);

        String s = "12e";
        boolean tomatch2 =  ismatch.isNumber(s);
        System.out.println(tomatch2);
    }

    //法2：边界条件判断
    public boolean isNumber(String s){
        s = s.trim();
        if (s.length()==0) return false;
        if(s.charAt(0)=='+'||s.charAt(0)=='-'){
            s=s.substring(1);
        }
        s=s.replace('E','e');
        if (s.indexOf('e')>=0){
            int idxE = s.indexOf('e');
            String first = s.substring(0,idxE);
            String second = s.substring(idxE+1);
            if(second.length()>0){
                if(second.charAt(0)=='+'||second.charAt(0)=='-'){
                    second = second.substring(1);
                }
            }
            return validNumber(first)&&validPureNumber(second);
        }
        return validNumber(s);
    }
    private boolean validNumber(String s){
        if(s.indexOf('.')>=0){
            int idxP = s.indexOf('.');
            String first = s.substring(0,idxP);
            String second = s.substring(idxP+1);
            if(first.length()>0&&second.length()>0){
                return validPureNumber(first)&&validPureNumber(second);
            }else if(second.length()>0){
                return validPureNumber(second);
            }else{
                return validPureNumber(first);
            }
        }
        return validPureNumber(s);
    }
    private boolean validPureNumber(String s){
        if(s.length()==0) return false;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)<'0'||s.charAt(i)>'9')return false;
        }
        return true;
    }



}
