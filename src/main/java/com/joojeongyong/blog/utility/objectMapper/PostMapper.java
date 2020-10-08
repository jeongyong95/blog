package com.joojeongyong.blog.utility.objectMapper;

import com.joojeongyong.blog.board.domain.Post;
import com.joojeongyong.blog.board.repository.PostDTO;
import com.joojeongyong.blog.user.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {

    @Mappings({
            @Mapping(source = "user.username", target = "username"),
            @Mapping(source = "post.createdAt", target = "createdAt"),
            @Mapping(source = "post.updatedAt", target = "updatedAt"),
    })
    PostDTO.PostDisplayDTO toPostDisplayDTO(Post post, User user);

    List<PostDTO.PostDisplayDTO> toDisplayDTOList(List<Post> postList);
}
