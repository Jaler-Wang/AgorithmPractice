package useful.leetcode.amazon;

import java.util.*;

/**
 * Created by Administrator on 2017/3/13 0013.
 * Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:

 postTweet(userId, tweetId): Compose a new tweet.
 getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
 follow(followerId, followeeId): Follower follows a followee.
 unfollow(followerId, followeeId): Follower unfollows a followee.

 */
public class Twitter {
    private Map<Integer, Map<Integer, Long>> user = new HashMap<Integer, Map<Integer, Long>>();
    private Map<Integer, List<Integer>> follow = new HashMap<Integer, List<Integer>>();

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(user.get(userId) == null){
            Map<Integer, Long> msg = new LinkedHashMap<Integer, Long>();
            msg.put(tweetId, System.currentTimeMillis());
            user.put(userId, msg);
        }
        else{
            user.get(userId).put(tweetId, System.currentTimeMillis());
        }
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {

    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(follow.get(followerId) == null){
            List<Integer> followees = new ArrayList<Integer>();
            followees.add(followeeId);
            follow.put(followerId, followees);
        }
        else{
            follow.get(followerId).add(followeeId);
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        List<Integer> followList = follow.get(followerId);
        if(followList == null) return;
        followList.remove(followeeId);
    }
}
