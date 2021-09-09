package dev.naman.realtimeclap.service;

import dev.naman.realtimeclap.model.LikeBroadcast;
import dev.naman.realtimeclap.model.LikeMessage;
import dev.naman.realtimeclap.repository.ILikeRepository;
import dev.naman.realtimeclap.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeService implements ILikeService {
    private final ILikeRepository likeRepository;

    @Autowired
    public LikeService(ILikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    public LikeBroadcast broadcastLike(LikeMessage like) {
        LikeBroadcast broadcast = new LikeBroadcast();
        LikeMessage latestLike = likeRepository.addLike(like);
        int totalLikesCount = likeRepository.getLikesCount();
        broadcast.setCurrentLikeCount(totalLikesCount);
        broadcast.setLatestLike(latestLike);
        return broadcast;
    }
}
