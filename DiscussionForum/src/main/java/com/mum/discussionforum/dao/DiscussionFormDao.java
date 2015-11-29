package com.mum.discussionforum.dao;

import java.util.List;

import com.mum.discussionforum.domain.Comment;
import com.mum.discussionforum.domain.Post;

public interface DiscussionFormDao {
	
	public void postQuestion(Post post);

	public List<Post> getQuestions();
	
	public Post getPost(int postId);
	
	public void postComment(Comment comment);
}
