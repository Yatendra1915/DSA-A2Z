class Twitter {
    private int timeStamp=0;
    HashMap<Integer, List<Tweet>> tweetMap = new HashMap<>();
    HashMap<Integer, HashSet<Integer>> followeeMap = new HashMap<>();
    PriorityQueue<Tweet> queue;

    class Tweet{
        public int tweetId;
        public int time;
        public Tweet(){}

        public Tweet(int tweetId){
            this.tweetId=tweetId;
            time = timeStamp++;
        }
}

    public void postTweet(int userId, int tweetId){
        if(!tweetMap.containsKey(userId)){
            tweetMap.put(userId, new ArrayList<>());
        }
        tweetMap.get(userId).add(new Tweet(tweetId));

    }
    
    public List<Integer> getNewsFeed(int userId) {
        queue = new PriorityQueue<>((a,b) -> b.time-a.time);
        if(tweetMap.containsKey(userId))
            queue.addAll(tweetMap.get(userId));
        if(followeeMap.containsKey(userId)){
            for(Integer followerId : followeeMap.get(userId)){
                if(tweetMap.containsKey(followerId))
                    queue.addAll(tweetMap.get(followerId));
            }
        }
        List<Integer> result = new ArrayList<>();
        int i=0;
        while(!queue.isEmpty() && i<10){
            result.add(queue.poll().tweetId);
            i++;
        }
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!followeeMap.containsKey(followerId))
            followeeMap.put(followerId, new HashSet<>());
        followeeMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!followeeMap.containsKey(followerId))
            return;
        if(followeeMap.get(followerId).contains(followeeId)){
            if(followeeMap.get(followerId).size()==1)
                followeeMap.put(followerId, new HashSet<>());
            else
                followeeMap.get(followerId).remove(followeeId);
        }
    }
}
