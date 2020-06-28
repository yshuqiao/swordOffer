//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/19.%20%E6%AD%A3%E5%88%99%E8%A1%A8%E8%BE%BE%E5%BC%8F%E5%8C%B9%E9%85%8D.md
//剑指题19. 正则表达式匹配
//请实现一个函数用来匹配包括 '.' 和 '*' 的正则表达式。模式中的字符 '.' 表示任意一个字符，而 '*' 表示它前面的字符可以出现任意次（包含 0 次）。
//在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串 "aaa" 与模式 "a.a" 和 "ab*ac*a" 匹配，但是与 "aa.a" 和 "ab*a" 均不匹配。
//思路：应该注意到，'.' 是用来当做一个任意字符，而 '*' 是用来重复前面的字符。这两个的作用不同，不能把 '.' 的作用和 '*' 进行类比，从而把它当成重复前面字符一次。
//动态规划，时空复杂度都是O(m*n)
//"aab"和"c*a*b"是true
// "aa"和".*"是true，这里.代表a
//"ab"和".*"也是true，这里.代表b

public class matchRegular {
    public boolean match(char[] str,char[] pattern){
        int m=str.length,n=pattern.length;
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for(int i=1;i<=n;i++)
            if(pattern[i-1]=='*')
                dp[0][i]=dp[0][i-2];
            //开头处理，像"aab","c*aab"这种情况

        for(int i=1;i<=m;i++)
            for (int j=1;j<=n;j++)
                if(str[i-1]==pattern[j-1]||pattern[j-1]=='.')
                    dp[i][j]=dp[i-1][j-1];
                else if (pattern[j-1]=='*')
                    if (pattern[j-2]==str[i-1]||pattern[j-2]=='.'){
                        //|表示或
                        dp[i][j] |= dp[i][j-1]; //a* counts as single a 比如"aa"和"a*"
                        dp[i][j] |= dp[i-1][j]; // a* counts as multiple a 比如"aaa"和"a*"
                        dp[i][j] |= dp[i][j-2]; //a* counts as empty  比如"a"和"a*"
                    }else
                        dp[i][j] = dp[i][j-2]; //a* only counts as empty
                        // 即当pattern[j-2]！=str[i-1]&&pattern[j-2]！='.',
                        // 比如"aa"和"ab*",或者说像"baab","bc*aab"
        return dp[m][n];
    }

    public boolean isMatch(String s,String p){
        if(s==null||p==null)return false;
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true; //动态规划初始化
        for(int i=0;i<p.length();i++){
            if (p.charAt(i)=='*'&&dp[0][i-1]){
                dp[0][i+1]=true; //开头处理，像"aab","c*aab"这种情况
            }
        }
        for(int i=0;i<s.length();i++){
            for(int j=0;j<p.length();j++){
                if(p.charAt(j)==s.charAt(i)||p.charAt(j)=='.'){
                    dp[i+1][j+1]=dp[i][j];
                }
                if(p.charAt(j)=='*'){
                    if (p.charAt(j-1)!=s.charAt(i)&&p.charAt(j-1)!='.'){
                        dp[i+1][j+1]=dp[i+1][j-1];
                    }else{
                        dp[i+1][j+1]=(dp[i+1][j]||dp[i][j+1]||dp[i+1][j-1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        matchRegular tomatch = new matchRegular();
        char[] str = {'a','a','a'};
        char[] pattern = {'a','b','*','a','c','*','a'};
        boolean matchornot = tomatch.match(str,pattern);
        System.out.println(matchornot);

        String s = "aab",p = "c*a*b";
        boolean matchornot2 =  tomatch.isMatch(s,p);
        System.out.println(matchornot2);
    }


}
