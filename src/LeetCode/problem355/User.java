package LeetCode.problem355;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int userId;
    private List<Integer> followeeIdList;
    private List<Post> postList;

    public User(int userId) {
        this.userId = userId;
        followeeIdList = new ArrayList<>();
        postList = new ArrayList<>();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Integer> getFolloweeIdList() {
        return followeeIdList;
    }


    public List<Post> getPostList() {
        return postList;
    }

    public boolean addFolloweeId(int id) {
        if (followeeIdList.contains(id)) return false;
        return followeeIdList.add(id);
    }

    public boolean removeFolloweeId(Integer id) {
        return followeeIdList.remove(id);
    }

    public boolean addPost(int id, int date) {
        Post post = new Post(id,date);
        return postList.add(post);
    }
}
