class AuthenticationManager {
    Map<String, Integer> map;
    int timeToLive;

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        map = new HashMap<>();
    }
    
    public void generate(String tokenId, int currentTime) {
        map.put(tokenId, currentTime + timeToLive);
    }
    
    public void renew(String tokenId, int currentTime) {
        if(map.containsKey(tokenId) && map.get(tokenId) > currentTime) {
            map.put(tokenId, currentTime + timeToLive);
        }
    }
    
    public int countUnexpiredTokens(int currentTime) {
        int count = 0;
        Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();
            if(entry.getValue() <= currentTime) {
                it.remove();
            }
        }
        return map.size();
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */