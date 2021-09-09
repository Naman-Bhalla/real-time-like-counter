package dev.naman.realtimeclap.repository;

import dev.naman.realtimeclap.model.LikeMessage;
import org.springframework.stereotype.Repository;

@Repository
public interface ILikeRepository {
    LikeMessage addLike(LikeMessage like);
    int getLikesCount();
}
