package dev.naman.realtimeclap.repository;

import dev.naman.realtimeclap.model.LikeMessage;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LikeRepository implements ILikeRepository {
    List<LikeMessage> likes = new ArrayList<>();

    public LikeMessage addLike(LikeMessage like) {
        likes.add(like);
        return like;
    }

    public int getLikesCount() {
        return likes.size();
    }
}
