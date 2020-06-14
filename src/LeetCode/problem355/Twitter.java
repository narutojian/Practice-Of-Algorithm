package LeetCode.problem355;

import java.util.*;

public class Twitter {
    private Map<Integer,User> context;
    private int time;
    /** Initialize your data structure here. */
    public Twitter() {
        context = new HashMap<>();
        time = Integer.MIN_VALUE;
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (context.containsKey(userId)) {
            context.get(userId).addPost(tweetId,time++);
        }
        else {
            User user = new User(userId);
            user.addPost(tweetId,time++);
            context.put(userId,user);
        }
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        if (!context.containsKey(userId)) return new ArrayList<>();
        PriorityQueue<Post> queue = new PriorityQueue<>();
        queue.addAll(context.get(userId).getPostList());

        for (int id :
                context.get(userId).getFolloweeIdList()) {
            if (id == userId) continue;
            queue.addAll(context.get(id).getPostList());
        }

        List<Integer> ans = new ArrayList<>();
        int times = 10;
        while (!queue.isEmpty() && times > 0) {
            ans.add(queue.poll().getTweetId());
            times--;
        }
        return ans;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (context.containsKey(followerId)) {
            context.get(followerId).addFolloweeId(followeeId);
        }
        else {
            User user = new User(followerId);
            user.addFolloweeId(followeeId);
            context.put(followerId,user);
            if (!context.containsKey(followeeId)) {
                context.put(followeeId,new User(followeeId));
            }
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (context.containsKey(followerId)) {
            context.get(followerId).removeFolloweeId(followeeId);
        }
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();

//        twitter.postTweet(1,1);
//        twitter.getNewsFeed(1);
//        twitter.follow(2,1);
//        twitter.getNewsFeed(2);

        twitter.follow(1,5);
        twitter.getNewsFeed(1);
    }
}
