package com.sp.entity;
public class Tb_taoti {
	int id;
	int lessonId;
	String name;
	String joinTime;
	Tb_lesson les;
	public Tb_lesson getLes() {
		return les;
	}
	public void setLes(Tb_lesson les) {
		this.les = les;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLessonId() {
		return lessonId;
	}
	public void setLessonId(int lessonId) {
		this.lessonId = lessonId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJoinTime() {
		return joinTime;
	}
	public void setJoinTime(String joinTime) {
		this.joinTime = joinTime;
	}
	
}	
