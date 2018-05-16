package com.mumblr.select1.mumblr.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.data.annotation.Id;

public class Posts implements Comparable<Posts>{
	
	@Id
	private String id;
	private String postDate;
	private String content;
	private String poster;
	private String posterID;
	private Comments[] comment;
	
	public Posts(){
		
	}
	
	public Posts(String id, String posterID, String postDate, String content, String poster){
		this.id = id;
		this.posterID = posterID;
		this.postDate = postDate;
		this.content = content;
		this.poster = poster;
		
	}
	
	@Override
    public String toString(){
        return String.format(
    		"Posts[id=%s, posterID=%s, postDate='%s', content='%s', poster='%s',"
    		+ " comment='%s']", id, posterID, postDate, content, poster,  comment);
    }
	
	@Override
	  public int compareTo(Posts o) {
		String string = getPostDate();
		String stringTwo = o.getPostDate();
		DateFormat format = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z");
		Date date = null;
		Date date1 = null;
		try {
			date = format.parse(string);
			date1 = format.parse(stringTwo);
			return date.compareTo(date1);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		return date.compareTo(date1);
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

	public Comments[] getComment() {
		return comment;
	}

	public void setComment(Comments[] comment) {
		this.comment = comment;
	}
}
