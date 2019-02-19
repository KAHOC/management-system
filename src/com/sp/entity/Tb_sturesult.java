package com.sp.entity;

public class Tb_sturesult {
	int id;
	String stuId;
	int whichLesson;
	int resSingle;
	int resMore;
	int resTotal;
	String joinTime;
	Tb_lesson lson;
	public Tb_lesson getLson() {
		return lson;
	}
	public void setLson(Tb_lesson lson) {
		this.lson = lson;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	public int getWhichLesson() {
		return whichLesson;
	}
	public void setWhichLesson(int whichLesson) {
		this.whichLesson = whichLesson;
	}
	public int getResSingle() {
		return resSingle;
	}
	public void setResSingle(int resSingle) {
		this.resSingle = resSingle;
	}
	public int getResMore() {
		return resMore;
	}
	public void setResMore(int resMore) {
		this.resMore = resMore;
	}
	public int getResTotal() {
		return resTotal;
	}
	public void setResTotal(int resTotal) {
		this.resTotal = resTotal;
	}
	public String getJoinTime() {
		return joinTime;
	}
	public void setJoinTime(String joinTime) {
		this.joinTime = joinTime;
	}

}
