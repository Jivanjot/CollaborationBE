package com.collaboration.dao;

import java.util.List;

import com.collaboration.domain.Friend;
import com.collaboration.domain.User;

public interface FriendDao {
	
	public List<Friend> showFriendList(String loginName);
	public List<Friend> showPendingFriendRequest(String loginName);
	public List<User> showSuggestedFriend(String loginName);
	
	public boolean sendFriendRequest(Friend friend);
	public boolean acceptFriendRequest(int friendId);
	public boolean deleteFriendRequest(int friendId);

}
