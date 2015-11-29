package com.mum.discussionforum.service;

import java.util.List;

import com.mum.discussionforum.domain.Comment;
import com.mum.discussionforum.domain.Post;

public interface DiscussionFormService {
	
	public void postQuestion(Post post);

	public List<Post> getAllQuestions();
	
	public Post getPost(int postId);
	
	public void postComment(Comment comment);
}
