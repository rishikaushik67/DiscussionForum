package com.mum.discussionforum.servicimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mum.discussionforum.dao.DiscussionFormDao;
import com.mum.discussionforum.domain.Comment;
import com.mum.discussionforum.domain.Post;
import com.mum.discussionforum.service.DiscussionFormService;

@Service
@Transactional
public class DiscussionFormServiceImpl implements DiscussionFormService {

	@Autowired
	DiscussionFormDao discussionFormDao;

	@Override
	public void postQuestion(Post post) {
		discussionFormDao.postQuestion(post);
		
	}

	@Override
	public List<Post> getAllQuestions() {
		return discussionFormDao.getQuestions();
	}

	@Override
	public Post getPost(int postId) {
		return discussionFormDao.getPost(postId);
	}

	@Override
	public void postComment(Comment comment) {
		discussionFormDao.postComment(comment);
	}
	
}
