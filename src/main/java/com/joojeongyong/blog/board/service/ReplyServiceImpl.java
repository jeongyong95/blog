package com.joojeongyong.blog.board.service;

import com.joojeongyong.blog.board.domain.Post;
import com.joojeongyong.blog.board.domain.Reply;
import com.joojeongyong.blog.board.repository.ReplyDTO;
import com.joojeongyong.blog.board.repository.ReplyRepository;
import com.joojeongyong.blog.user.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Transactional
@Service
public class ReplyServiceImpl implements ReplyService {

    @Resource
    private ReplyRepository replyRepo;

    @Override
    public void registerReply(ReplyDTO.ReplyRegisterDTO replyRegisterDTO) {
        replyRepo.save(replyRegisterDTO.toEntity());
    }

    @Override
    public Page<Reply> getReplyPageByPost(Pageable pageable, Post post) {
        return replyRepo.findByPost(pageable, post);
    }

    @Override
    public Page<Reply> getReplyPageByUser(Pageable pageable, User user) {
        return replyRepo.findByUser(pageable, user);
    }

    @Override
    public void deleteReply(Long replyId) {
        replyRepo.deleteById(replyId);
    }
}
