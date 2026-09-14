class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s1.length()>s2.length()) return false;

        int freq[]=new int[26];

        for(int i=0;i<s1.length();i++)
        {
            freq[s1.charAt(i)-'a']++;
            freq[s2.charAt(i)-'a']--;
        }

        int l=0;
        int r=s1.length()-1;

        while(r<s2.length())
        {
            boolean isValid=true;
            for(int i=0;i<26;i++)
            {
                if(freq[i]!=0)
                    isValid=false;
            }

            if(isValid)
                return true;
            
            freq[s2.charAt(l)-'a']++;
            l++;

            r++;
            if(r<s2.length())
                freq[s2.charAt(r)-'a']--;
        }
    return false;
    }
}