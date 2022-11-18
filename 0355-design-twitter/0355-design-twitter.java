class Twitter {
    
    private int timeStamp = 0;
    private Map<Integer, User> userMap; //userid -> user
    
    // Create Tweet class
    private class Tweet {
        int id;
        int time;
        Tweet next;
        Tweet(int id) {
            this.id = id;
            this.time = timeStamp++;
            this.next = null;
        }
    }
    // Create User class
    public class User {
        int id;
        Set<Integer> followees;
        Tweet tweet_head;
        public User(int id) {
            this.id = id;
            followees = new HashSet<>();
            followees.add(id); //first follow itself
            tweet_head = null;
        }
        public void post(int id) {
            //added the new tweet to the front of the current head
            Tweet t = new Tweet(id);
            t.next = tweet_head;
            tweet_head = t;
        }
        public void follow(int id) {
            followees.add(id);
        }
        public void unfollow(int id) {
            followees.remove(id);
        }
    }

    
    public Twitter() {
        userMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            userMap.put(userId, new User(userId));
        }
        userMap.get(userId).post(tweetId);  
    }
    
    //Create a max heap, add all users tweet_head to the heap according to their time
    //Eeach time pop out the max tweet_head and add its next back to the heap unitl we get 10 most recent tweets
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new LinkedList<>();
        if (!userMap.containsKey(userId)) return res;
        
        Set<Integer> users = userMap.get(userId).followees;
        PriorityQueue<Tweet> heap = new PriorityQueue<>(users.size(), (a, b) -> (b.time - a.time));
        for (int user : users) {
            Tweet t = userMap.get(user).tweet_head;
            if (t != null) 
                heap.add(t);
        }
        int n = 0;
        while (!heap.isEmpty() && n < 10) {
            Tweet t = heap.poll();
            res.add(t.id);
            if (t.next != null)
                heap.add(t.next);
            n++;
        }
        
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            userMap.put(followerId, new User(followerId));
        }
        if (!userMap.containsKey(followeeId)) {
            userMap.put(followeeId, new User(followeeId));
        }
        userMap.get(followerId).follow(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId) || !userMap.containsKey(followeeId) || followerId == followeeId)
            return;
        userMap.get(followerId).unfollow(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */