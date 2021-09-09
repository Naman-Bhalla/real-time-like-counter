package dev.naman.realtimeclap.controller;

import dev.naman.realtimeclap.model.LikeBroadcast;
import dev.naman.realtimeclap.model.LikeMessage;
import dev.naman.realtimeclap.service.ILikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class LikeController {
    private ILikeService likeService;

    @Autowired
    public LikeController(ILikeService likeService) {
        this.likeService = likeService;
    }

    @MessageMapping("/like")
    @SendTo("/topic/likes")
    public LikeBroadcast like(LikeMessage message) {
        return likeService.broadcastLike(message);
    }
}
