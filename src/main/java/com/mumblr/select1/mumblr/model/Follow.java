package com.mumblr.select1.mumblr.model;

import org.springframework.data.annotation.Id;

public class Follow {

	@Id
	private String id;
	private String userID;
	private String followersID;
	
	public Follow(){
		
	}
	
	public Follow(String id, String userID, String followersID){
		
	}
	
	@Override
    public String toString(){
        return String.format(
                "Accounts[id=%s, userID='%s', followersID='%s']",
                id, userID, followersID);
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getFollowersID() {
		return followersID;
	}

	public void setFollowersID(String followersID) {
		this.followersID = followersID;
	}
	
	
}

