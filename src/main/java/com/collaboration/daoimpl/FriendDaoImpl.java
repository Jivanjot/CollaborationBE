package com.collaboration.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.collaboration.dao.FriendDao;
import com.collaboration.domain.Friend;
import com.collaboration.domain.User;

@Transactional
@Repository(value = "friendDao")
public class FriendDaoImpl implements FriendDao {

	private SessionFactory sessionFactory;

	public List<Friend> showFriendList(String loginName) {
		List<Friend> friends = sessionFactory.getCurrentSession().createQuery("from c_friend where loginName='"
				+ loginName + "' or friendLoginName='" + loginName + "' and status='A'").list();

		return friends;

	}

	public List<Friend> showPendingFriendRequest(String loginName) {

		return sessionFactory.getCurrentSession().createQuery("from c_friend where loginName='" + loginName
				+ "' or friendLoginName='" + loginName + "' and status='P'").list();

	}

	public List<User> showSuggestedFriend(String loginName) {
		return sessionFactory.getCurrentSession().createQuery(
				"select loginName from c_user where loginName not in(select friendLoginName from c_friend where loginName='"
						+ loginName + "') and loginName!='" + loginName + "'")
				.list();

	}

	public boolean sendFriendRequest(Friend friend) {

		try {
			friend.setStatus("P");
			sessionFactory.getCurrentSession().save(friend);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	public boolean acceptFriendRequest(int friendId) {

		try {
			Friend friend = sessionFactory.getCurrentSession().get(Friend.class, friendId);
			friend.setStatus("A");
			sessionFactory.getCurrentSession().update(friend);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean deleteFriendRequest(int friendId) {

		try {
			Friend friend = sessionFactory.getCurrentSession().get(Friend.class, friendId);
			sessionFactory.getCurrentSession().delete(friend);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
