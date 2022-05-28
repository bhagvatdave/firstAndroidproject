package com.example.firsttestproject.NearEarthAPI.Class;

import com.google.gson.annotations.SerializedName;

public class Links{

	@SerializedName("next")
	private String next;

	@SerializedName("prev")
	private String prev;

	@SerializedName("self")
	private String self;

	public String getNext(){
		return next;
	}

	public String getPrev(){
		return prev;
	}

	public String getSelf(){
		return self;
	}

	@Override
	public String toString() {
		return "Links{" +
				"next='" + next + '\'' +
				", prev='" + prev + '\'' +
				", self='" + self + '\'' +
				'}';
	}
}