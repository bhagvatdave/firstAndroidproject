package com.example.firsttestproject.NearEarthAPI.Class;

import com.google.gson.annotations.SerializedName;

public class Kilometers{

	@SerializedName("estimated_diameter_max")
	private double estimatedDiameterMax;

	@SerializedName("estimated_diameter_min")
	private double estimatedDiameterMin;

	public double getEstimatedDiameterMax(){
		return estimatedDiameterMax;
	}

	public double getEstimatedDiameterMin(){
		return estimatedDiameterMin;
	}

	@Override
	public String toString() {
		return "Kilometers{" +
				"estimatedDiameterMax=" + estimatedDiameterMax +
				", estimatedDiameterMin=" + estimatedDiameterMin +
				'}';
	}
}