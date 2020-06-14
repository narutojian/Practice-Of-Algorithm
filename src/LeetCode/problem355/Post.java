package LeetCode.problem355;

public class Post implements Comparable<Post>{
    private int tweetId;
    private int date;

    public Post(int tweetId, int date) {
        this.tweetId = tweetId;
        this.date = date;
    }

    public int getTweetId() {
        return tweetId;
    }

    public void setTweetId(int tweetId) {
        this.tweetId = tweetId;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    @Override
    public int compareTo(Post o) {
        return o.date - this.date;
    }
}
