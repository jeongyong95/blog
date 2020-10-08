package com.joojeongyong.blog.board.service;

import com.joojeongyong.blog.board.domain.Post;
import com.joojeongyong.blog.board.domain.Reply;
import com.joojeongyong.blog.board.repository.ReplyDTO;
import com.joojeongyong.blog.user.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReplyService {

    //    Create
    void registerReply(ReplyDTO.ReplyRegisterDTO replyRegisterDTO);

    //    Read
    Page<Reply> getReplyPageByPost(Pageable pageable, Post post);

    Page<Reply> getReplyPageByUser(Pageable pageable, User user);

//    Update

//    Delete
    void deleteReply(Long replyId);

}
