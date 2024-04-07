class AuthenticationManager {
    //use a hashmap tp store the session
    Map<String, Integer> map;
    int timeToLive;
    public AuthenticationManager(int timeToLive) {
        map = new HashMap<>();
        this.timeToLive = timeToLive;
    }
    
    public void generate(String tokenId, int currentTime) {
        map.put(tokenId, currentTime + timeToLive);
    }
    
    public void renew(String tokenId, int currentTime) {
        if (!map.containsKey(tokenId) || map.get(tokenId) <= currentTime) return;
        map.put(tokenId, currentTime + timeToLive);
    }
    
    public int countUnexpiredTokens(int currentTime) {
        int count = 0;
        for (String tokenId : map.keySet()) {
            if (map.get(tokenId) > currentTime) count++;
        }
        return count; 
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */