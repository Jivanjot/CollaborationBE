package com.collaboration.dao;

import com.collaboration.domain.ProfilePicture;

public interface ProfilePictureDao {
	
	public void save(ProfilePicture profilePicture);
	public ProfilePicture getProfilePicture(String loginName);

}
