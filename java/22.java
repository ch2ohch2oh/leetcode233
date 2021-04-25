/**
 * id: 22 generated parentheses
 * tags: recursion, dp
 * date: 2021-04-25
 * note: could also use recursion
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<List<String>> paren = new ArrayList<>();
        paren.add(Arrays.asList(""));
        paren.add(Arrays.asList("()"));
        for(int i=2; i<=n; i++) {
            paren.add(new ArrayList<String>());
            for(int j=0; j<i; j++) {
                for(int k1=0; k1<paren.get(j).size(); k1++) {
                    for(int k2=0; k2<paren.get(i - 1 - j).size(); k2++) {
                        paren.get(i).add("(" + paren.get(j).get(k1) + ")" + paren.get(i-1-j).get(k2));
                    }
                }
            }
        }
        return paren.get(n);
    }
}
