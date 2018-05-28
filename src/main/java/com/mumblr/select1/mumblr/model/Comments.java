package com.mumblr.select1.mumblr.model;

import org.springframework.data.annotation.Id;

public class Comments {
	
	@Id
	private String id;
	private String postId;
	private String commenterName;
	private String commenterId;
	private String commentDate;
	private String commentContent;
	
	public Comments(){
		
	}
	
	public Comments(String postId, String commenterName, String commenterId, String commentDate, String commentContent){
		this.postId = postId;
		this.commenterName = commenterName;	
		this.commenterId = commenterId;
		this.commentDate = commentDate;
		this.commentContent = commentContent;
	}
	
	@Override
    public String toString(){
        return String.format(
                "Comments[id=%s, postId='%s', commenterName='%s',commenterId='%s', commentDate='%s', commentContent='%s']",
                id, postId, commenterName, commenterId, commentDate, commentContent);
    }
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
	
	public String getCommenterName() {
		return commenterName;
	}
	public void setCommenterName(String commenterName) {
		this.commenterName = commenterName;
	}
	public String getCommenterId() {
		return commenterId;
	}
	public void setCommenterId(String commenterId) {
		this.commenterId = commenterId;
	}
	public String getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	
	
}
