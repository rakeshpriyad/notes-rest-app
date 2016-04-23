package com.gotprint.domain;

import java.util.Date;

/**
 * 
 * @author rakeshku
 *
 */
public class Note {
	
	private Integer id;
	
	
	public Note() {
	}
	

	public Note(Integer id,String title, String note) {
		super();
		this.id=id;
		this.title = title;
		this.note = note;
	}
	
	public Note(String title, String note, Date createTime, Date lastUpdateTime) {
		super();
		this.title = title;
		this.note = note;
		this.createTime = createTime;
		this.lastUpdateTime = lastUpdateTime;
	}


	private String title;
	private String note;
	private Date createTime;
	private Date lastUpdateTime;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

}
