package com.mum.discussionforum.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mum.discussionforum.dao.DiscussionFormDao;
import com.mum.discussionforum.domain.Comment;
import com.mum.discussionforum.domain.Post;

@Repository
public class DiscussionFormDaoImpl implements DiscussionFormDao {

	@Autowired
	public SessionFactory sessionFactory;

	@Override
	public void postQuestion(Post post) {
		sessionFactory.getCurrentSession().saveOrUpdate(post);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Post> getQuestions() {
		return sessionFactory.getCurrentSession().createQuery("from Post").list();
	}

	@Override
	public Post getPost(int postId) {
		return (Post) sessionFactory.getCurrentSession().get(Post.class, postId);
	}

	@Override
	public void postComment(Comment comment) {
		sessionFactory.getCurrentSession().saveOrUpdate(comment);
	}
}
