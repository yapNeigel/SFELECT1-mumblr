package com.mumblr.select1.mumblr.model;

public class Posts {
	
	private String id;
	private String postDate;
	private String postTime;
	private String content;
	private String poster;
	private int likes;
	private Comments[] comment;
	
	Posts(){
		
	}
	
	@Override
    public String toString(){
        return String.format(
    		"Posts[id=%s, postDate='%s', postTime='%s', content='%s', poster='%s', likes='%s',"
    		+ " comment='%s']", id, postDate, postTime, content, poster, likes, comment);
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

	public String getPostTime() {
		return postTime;
	}

	public void setPostTime(String postTime) {
		this.postTime = postTime;
	}

//	public String getLikes() {
//		return likes;
//	}
//
//	public void setLikes(String likes) {
//		this.likes = likes;
//	}
}
