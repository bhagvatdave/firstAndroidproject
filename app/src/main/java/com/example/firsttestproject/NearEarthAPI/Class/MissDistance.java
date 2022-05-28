package com.example.firsttestproject.NearEarthAPI.Class;

import com.google.gson.annotations.SerializedName;

public class MissDistance{

	@SerializedName("astronomical")
	private String astronomical;

	@SerializedName("kilometers")
	private String kilometers;

	@SerializedName("lunar")
	private String lunar;

	@SerializedName("miles")
	private String miles;

	public String getAstronomical(){
		return astronomical;
	}

	public String getKilometers(){
		return kilometers;
	}

	public String getLunar(){
		return lunar;
	}

	public String getMiles(){
		return miles;
	}

	@Override
	public String toString() {
		return "MissDistance{" +
				"astronomical='" + astronomical + '\'' +
				", kilometers='" + kilometers + '\'' +
				", lunar='" + lunar + '\'' +
				", miles='" + miles + '\'' +
				'}';
	}
}