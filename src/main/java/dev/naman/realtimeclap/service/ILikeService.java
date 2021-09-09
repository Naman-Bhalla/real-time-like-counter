package dev.naman.realtimeclap.service;

import dev.naman.realtimeclap.model.LikeBroadcast;
import dev.naman.realtimeclap.model.LikeMessage;
import org.springframework.stereotype.Service;

@Service
public interface ILikeService {
    LikeBroadcast broadcastLike(LikeMessage like);
}
