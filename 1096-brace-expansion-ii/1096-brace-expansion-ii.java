class Solution {
    public List<String> join(List<String> expression1, List<String> expression2) {
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();
        
        for (String s1 : expression1) {
            sb.setLength(0);
            sb.append(s1);
            for (String s2 : expression2) {
                sb.setLength(s1.length());
                sb.append(s2);
                res.add(sb.toString());
            }
        }
        return res;
    }
    
    public List<String> concat(List<String> expression1, List<String> expression2) {
        List<String> res = new ArrayList<>();
        res.addAll(expression1);
        res.addAll(expression2);
        return res;
    }
    
    public Integer concatSubExpressions(String s) {
        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ',' && count == 0) {
                return i;
            } else if (c == '{') {
                count++;
            } else if (c == '}') {
                count--;
            }
        }
        return null;
    }
    
    public Integer joinSubExpressions(String s) {
        int openI = -1, count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{') {
                if (openI == -1) {
                    openI = i;
                }
                count++;
            } else if (c == '}') {
                count--;
                if (count <= 0) {
                    if (i == s.length() - 1) {
                        if (openI == 0) {
                            return -1;
                        } 
                        return openI;
                    }
                    return i + 1;
                }
            }
        }
        return null;
    }
    
    public List<String> expand(String s) {
        if (s.equals("")) return Arrays.asList(new String[]{""});
        
        Integer concatIndex = concatSubExpressions(s);
        if (concatIndex != null) {
            return concat(expand(s.substring(0, concatIndex)), expand(s.substring(concatIndex + 1, s.length())));
        }
        
        Integer joinIndex = joinSubExpressions(s);
        if (joinIndex != null) {
            if (joinIndex == -1) {
                return expand(s.substring(1, s.length() - 1));
            } else {
                return join(expand(s.substring(0, joinIndex)), expand(s.substring(joinIndex, s.length())));
            }
        }
        
        return Arrays.asList(s.split(","));
    }
    
    public List<String> braceExpansionII(String expression) {
        TreeSet<String> set = new TreeSet<>(expand(expression));
        
        List<String> res = new ArrayList<>();
        
        for (String s : set) {
            if (s.equals("")) continue;
            res.add(s);
        }
        return res;
    }
}