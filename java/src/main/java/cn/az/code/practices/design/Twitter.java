package cn.az.code.practices.design;

import java.util.*;

/**
 * little-code
 *
 * @author azusachino
 * @since 22/9/2020 21:32
 */
public class Twitter {

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);

        twitter.getNewsFeed(1);

        // return [5]，因为自己是关注自己的
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);

        // 用户2发送了一个新推文 (id = 6)
        twitter.getNewsFeed(1);

        // 解释:用户 1 关注了自己和用户 2，所以返回他们的最近推文 // 而且 6 必须在 5 之前，因为 6 是最近发送的
        twitter.unfollow(1, 2);
        System.out.println(twitter.getNewsFeed(1));
    }

    private static int timestamp = 0;
    private final Map<Integer, User> userMap = new HashMap<>();

    /**
     * Initialize your data structure here.
     */
    public Twitter() {

    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        // 若 userId 不存在，则新建
        if (!userMap.containsKey(userId)) {
            userMap.put(userId, new User(userId));
        }
        User u = userMap.get(userId);
        u.post(tweetId);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if (!userMap.containsKey(userId)) {
            return res;
        }
        // 关注列表的用户 Id
        Set<Integer> users = userMap.get(userId).followed;
        // 自动通过 time 属性从大到小排序，容量为 users 的大小
        PriorityQueue<Tweet> pq = new PriorityQueue<>(users.size(), (a, b) -> (b.time - a.time));
        // 先将所有链表头节点插入优先级队列
        for (int id : users) {
            Tweet twt = userMap.get(id).head;
            if (twt == null) {
                continue;
            }
            pq.add(twt);
        }
        while (!pq.isEmpty()) {
            // 最多返回 10 条就够了
            if (res.size() == 10) {
                break;
            }
            // 弹出 time 值最大的(最近发表的)
            Tweet twt = pq.poll();
            res.add(twt.id);
            // 将下一篇 Tweet 插入进行排序
            if (twt.next != null) {
                pq.add(twt.next);
            }
        }
        return res;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        // 若 follower 不存在，则新建
        if (!userMap.containsKey(followerId)) {
            User u = new User(followerId);
            userMap.put(followerId, u);
        }
        // 若 followee 不存在，则新建
        if (!userMap.containsKey(followeeId)) {
            User u = new User(followeeId);
            userMap.put(followeeId, u);
        }
        userMap.get(followerId).follow(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {

        if (userMap.containsKey(followerId)) {
            User user = userMap.get(followerId);
            user.unfollow(followeeId);
        }
    }

    public static class Tweet {
        private final int id;
        private final int time;
        private Tweet next;

        public Tweet(int id, int time) {
            this.id = id;
            this.time = time;
            this.next = null;
        }
    }

    public static class User {
        private final int id;
        public Set<Integer> followed;
        public Tweet head;


        public User(int userId) {
            this.id = userId;
            this.head = null;
            follow(userId);
        }

        private void follow(int userId) {
            followed.add(userId);
        }

        private void unfollow(int userId) {
            if (userId != this.id) {
                followed.remove(userId);
            }
        }

        public void post(int tweetId) {
            Tweet twt = new Tweet(tweetId, timestamp);
            timestamp++;
            // 将新建的推文插入链表头
            // 越靠前的推文 time 值越大
            twt.next = head;
            head = twt;
        }
    }
}
