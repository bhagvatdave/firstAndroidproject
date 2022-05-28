package com.example.firsttestproject.NearEarthAPI.Class;

import com.google.gson.annotations.SerializedName;

public class RelativeVelocity{

	@SerializedName("kilometers_per_hour")
	private String kilometersPerHour;

	@SerializedName("kilometers_per_second")
	private String kilometersPerSecond;

	@SerializedName("miles_per_hour")
	private String milesPerHour;

	public String getKilometersPerHour(){
		return kilometersPerHour;
	}

	public String getKilometersPerSecond(){
		return kilometersPerSecond;
	}

	public String getMilesPerHour(){
		return milesPerHour;
	}

	@Override
	public String toString() {
		return "RelativeVelocity{" +
				"kilometersPerHour='" + kilometersPerHour + '\'' +
				", kilometersPerSecond='" + kilometersPerSecond + '\'' +
				", milesPerHour='" + milesPerHour + '\'' +
				'}';
	}
}