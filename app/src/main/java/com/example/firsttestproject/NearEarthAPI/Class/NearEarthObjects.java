package com.example.firsttestproject.NearEarthAPI.Class;

import java.util.List;
import com.example.firsttestproject.NearEarthAPI.Class.Nasa;
import com.google.gson.annotations.SerializedName;

public class NearEarthObjects{

	String nasadate = Nasa.getDataDate();

	@SerializedName("")
	private List<DateViseList> DateViseList;


	public List<DateViseList> getDateViseList(){
		return DateViseList;
	}

	@Override
	public String toString() {
		return "NearEarthObjects{" +
				", jsonMember20220524=" + DateViseList +
				'}';
	}
}