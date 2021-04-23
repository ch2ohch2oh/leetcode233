/**
 * id: 811 subdomain visits
 * tags: hashmap
 * date: 2021-04-22
 */
class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> countMap = new HashMap<>();
        
        for(String cpdomain : cpdomains) {
            String [] parts = cpdomain.split(" ");
            int count = Integer.parseInt(parts[0]);
            String domain = parts[1];
            countMap.put(domain, count + (countMap.containsKey(domain) ? countMap.get(domain) : 0));
            int start = 0;
            start = domain.indexOf(".");
            while(start > 0) {
                String subdomain = domain.substring(start + 1);
                countMap.put(subdomain, count + (countMap.containsKey(subdomain) ? countMap.get(subdomain) : 0));
                start = domain.indexOf(".", start + 1);

            }
        }
        // Output
        List<String> res = new ArrayList<String>();
        for(Map.Entry<String, Integer> entry : countMap.entrySet()) {
            res.add(entry.getValue() + " " + entry.getKey());
        }
        return res;
    }
}