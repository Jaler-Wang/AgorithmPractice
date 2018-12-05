package leetcode;

public class RegularExpression {
    public boolean matchString(String input, String rexp){

        return isMatch(input, rexp);
    }

    private boolean isMatch(String input, String rexp) {
        if(input == null || rexp == null) return false;
        boolean[][] dp = new boolean[input.length() + 1][rexp.length() + 1];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                dp[i][j] = false;
            }
        }
        dp[0][0] = true;
        for(int i = 1; i <= rexp.length(); i++){
            if(rexp.charAt(i - 1) == '*' && dp[0][i-1]){
                dp[0][i] = dp[0][i - 1];
            }
        }
        for(int i = 0; i < input.length(); i++){
            for(int j = 0; j < rexp.length(); j++){
                if(rexp.charAt(j) == '.'){
                    dp[i+1][j+1] = dp[i][j];
                }
                if(rexp.charAt(j) == input.charAt(i)){
                    dp[i+1][j+1] = dp[i][j];
                }
                if(rexp.charAt(j) == '*'){
                    if (rexp.charAt(j-1) != input.charAt(i) && rexp.charAt(j-1) != '.') {
                        dp[i+1][j+1] = dp[i+1][j-1];
                    } else {
                        dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                    }
                }
            }
        }
        return dp[input.length()][rexp.length()];
    }
}
