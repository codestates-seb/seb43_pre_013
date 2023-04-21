package com.codestates.stackoverflow.comment.mapper;


import com.codestates.stackoverflow.comment.dto.CommentDto;
import com.codestates.stackoverflow.comment.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


import java.util.List;


@Mapper(componentModel = "spring")
public interface CommentMapper {
    Comment commentPostDtoToComment(CommentDto.Post commentDtoPost);
    Comment commentPatchDtoToComment(CommentDto.Patch commentDtoPatch);
    CommentDto.Response commentToResponseDto(Comment comment);
    List<CommentDto.Response> commentsToResponseDtos(List<Comment> allComments);
}
