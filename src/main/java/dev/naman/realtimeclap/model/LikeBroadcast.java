package dev.naman.realtimeclap.model;

public class LikeBroadcast {
    private int currentLikeCount;
    private LikeMessage latestLike;

    public int getCurrentLikeCount() {
        return currentLikeCount;
    }

    public void setCurrentLikeCount(int currentLikeCount) {
        this.currentLikeCount = currentLikeCount;
    }

    public LikeMessage getLatestLike() {
        return latestLike;
    }

    public void setLatestLike(LikeMessage latestLike) {
        this.latestLike = latestLike;
    }
}
