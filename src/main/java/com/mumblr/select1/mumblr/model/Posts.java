package com.mumblr.select1.mumblr.model;

public class Posts {
	
	private String id;
	private String postDate;
//	private String postTime;
	private String content;
	private String poster;
	private String posterID;
	private String postType;
	private int likes;
	private Comments[] comment;
	
	public Posts(){
		
	}
	
	public Posts(String id, String posterID, String postDate, String content, String poster, int likes, String posterType){
		this.id = id;
		this.posterID = posterID;
		this.postDate = postDate;
//		this.postTime = postTime;
		this.content = content;
		this.poster = poster;
		this.postType = postType;
		this.likes = likes;
	}
	
	@Override
    public String toString(){
        return String.format(
    		"Posts[id=%s, posterID=%s, postDate='%s', content='%s', poster='%s', postType='%s', likes='%s',"
    		+ " comment='%s']", id, posterID, postDate, content, poster, likes, comment);
    }

	public String getPosterID() {
		return posterID;
	}

	public void setPosterID(String posterID) {
		this.posterID = posterID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPostDate() {
		return postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public Comments[] getComment() {
		return comment;
	}

	public void setComment(Comments[] comment) {
		this.comment = comment;
	}

//	public String getPostTime() {
//		return postTime;
//	}
//
//	public void setPostTime(String postTime) {
//		this.postTime = postTime;
//	}

	public String getPostType() {
		return postType;
	}

	public void setPostType(String postType) {
		this.postType = postType;
	}

//	public String getLikes() {
//		return likes;
//	}
//
//	public void setLikes(String likes) {
//		this.likes = likes;
//	}
}
