class Solution
{
    
    public int helper(String S, int i, int j, int len){
        if(i <0 || j >= S.length())
            return len;
        int len1 = 0;
        int len2 = 0;
        int len3 = 0;
        Character c = S.charAt(i);
        if(c.equals(S.charAt(j))){
            len+=2;
            len1 = helper(S, i-1, j+1, len);
        }
        else{
            len2 = helper(S, i, j+1, len);
            len3 = helper(S, i-1, j, len);
        }
        return Math.max(len3, Math.max(len1, len2));
        
    }
     public int lps(String S)
     {
        //code here
        int max_len = 1;
        
        int l = S.length();
        //For odd numbered palindromes
        for(int i = 1;i<l-1;i++){
            int len = 1;
            int left = i-1;
            int right = i+1;
            // while(left >= 0 && right < l){
            //     Character left_char = S.charAt(left);
            //     if(left_char.equals(S.charAt(right)))
            //         len+=2;
            //     else
            //         break;
            //     left--;
            //     right++;
            // }
            // max_len = Math.max(max_len, len);
            len = helper(S, left, right, 1);
            max_len = Math.max(max_len, len);
        }
        //For even numbered palindromes
        for(int i=0;i<l-1;i++){
            Character c = S.charAt(i);
            int len = 0;
            if(c.equals(S.charAt(i+1))){
                len = 2;
                int left = i-1;
                int right = i+2;
                // while(left >= 0 && right < l){
                //     Character left_char = S.charAt(left);
                //     if(left_char.equals(S.charAt(right)))
                //         len+=2;
                //     else
                //         break;
                // left--;
                // right++;
                // }
                len = helper(S, left, right, 2);
            }
            max_len = Math.max(max_len, len);
        }
        return max_len;
     }
}
