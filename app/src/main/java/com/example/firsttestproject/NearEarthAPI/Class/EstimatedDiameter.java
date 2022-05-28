package com.example.firsttestproject.NearEarthAPI.Class;

import com.google.gson.annotations.SerializedName;

public class EstimatedDiameter{

	@SerializedName("feet")
	private Feet feet;

	@SerializedName("kilometers")
	private Kilometers kilometers;

	@SerializedName("meters")
	private Meters meters;

	@SerializedName("miles")
	private Miles miles;

	public Feet getFeet(){
		return feet;
	}

	public Kilometers getKilometers(){
		return kilometers;
	}

	public Meters getMeters(){
		return meters;
	}

	public Miles getMiles(){
		return miles;
	}

	@Override
	public String toString() {
		return "EstimatedDiameter{" +
				"feet=" + feet +
				", kilometers=" + kilometers +
				", meters=" + meters +
				", miles=" + miles +
				'}';
	}
}