package com.bpd.bean;

public class Type {
     
	private int tid;
	private String tname;
	public Type() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Type(int tid, String tname) {
		super();
		this.tid = tid;
		this.tname = tname;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	
}
