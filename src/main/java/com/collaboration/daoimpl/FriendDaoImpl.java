package com.collaboration.daoimpl;

import java.util.List;
import java.util.Random;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collaboration.dao.FriendDao;
import com.collaboration.domain.Friend;
import com.collaboration.domain.User;

@Transactional
@Repository(value = "friendDao")
public class FriendDaoImpl implements FriendDao{

	Random rand=new Random();
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	FriendDao friendDao;
	@Autowired
	Friend friend;
	
	public List<Friend> showFriendList(String loginName) {
	return sessionFactory.getCurrentSession().createQuery("from Friend where (loginName='"+loginName+"' or friendLoginName='"+loginName+"') and status='A'").list();
		
	}

	public List<Friend> showPendingFriendRequest(String loginName) {
		
		return sessionFactory.getCurrentSession().createQuery("from Friend where (loginName='"+loginName+"' or friendLoginName='"+loginName+"') and status='P'").list();
	}

	public List<User> showSuggestedFriend(String loginName) {
		
	return sessionFactory.getCurrentSession().createQuery("from User where loginName not in(select friendLoginName from Friend where loginName='"+loginName+"') and loginName!='"+loginName+"'").list();	
	}

	public boolean sendFriendRequest(Friend friend) {
        friend.setFriendId(rand.nextInt(50)+1);
		friend.setStatus("P");
		try {
		sessionFactory.getCurrentSession().save(friend);
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean acceptFriendRequest(int friendId) {
		try {
		Friend friend=sessionFactory.getCurrentSession().get(Friend.class,friendId);
		friend.setStatus("A");
		sessionFactory.getCurrentSession().update(friend);
		return true;
		}
catch(Exception e)
		{
	return false;
		}
		}

	public boolean deleteFriendRequest(int friendId) {
		
		try
		{
			Friend friend=sessionFactory.getCurrentSession().get(Friend.class,friendId);
			sessionFactory.getCurrentSession().delete(friend);
		return true;
		
		}
		catch(Exception e)
		{
			return false;
		}
		
	}

}
