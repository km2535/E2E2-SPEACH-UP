package com.speech.up.board.service.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.speech.up.board.entity.BoardEntity;

import lombok.Getter;
import lombok.ToString;

public class BoardGetDto {

	@Getter
	@ToString
	public static class Response{
		private final Long boardId;
		private final String title;
		private final String content;
		private final LocalDateTime createdAt;
		private final LocalDateTime modifiedAt;

		Response(BoardEntity boardEntity) {
			this.boardId = boardEntity.getBoardId();
			this.title = boardEntity.getTitle();
			this.content = boardEntity.getContent();
			this.createdAt = boardEntity.getCreatedAt();
			this.modifiedAt = boardEntity.getModifiedAt();
		}

		public static Response toResponse(BoardEntity boardEntity) {
			return new Response(boardEntity);
		}

		public static List<BoardGetDto.Response> of(List<BoardEntity> boardEntities) {
			return boardEntities
				.stream()
				.map(Response::toResponse)
				.collect(Collectors.toList());
		}
	}
}
