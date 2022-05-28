package com.example.firsttestproject.NearEarthAPI.Class;

import com.google.gson.annotations.SerializedName;

public class Nasa{

	private static String DataDate;
	@SerializedName("near_earth_objects")
	private NearEarthObjects nearEarthObjects;

	@SerializedName("element_count")
	private int elementCount;

	@SerializedName("links")
	private Links links;


	public NearEarthObjects getNearEarthObjects(){
		return nearEarthObjects;
	}

	public int getElementCount(){
		return elementCount;
	}

	public Links getLinks(){ return links; }

	public static String getDataDate() { return DataDate; }

	public void setDataDate(String dataDate) { DataDate = dataDate; }

	@Override
	public String toString() {
		return "Nasa{" +
				"nearEarthObjects=" + nearEarthObjects +
				", elementCount=" + elementCount +
				", links=" + links +
				'}';
	}
}