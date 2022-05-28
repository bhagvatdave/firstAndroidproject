package com.example.firsttestproject.NearEarthAPI.Class;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class DateViseList {

	@SerializedName("estimated_diameter")
	private EstimatedDiameter estimatedDiameter;

	@SerializedName("neo_reference_id")
	private String neoReferenceId;

	@SerializedName("nasa_jpl_url")
	private String nasaJplUrl;

	@SerializedName("is_potentially_hazardous_asteroid")
	private boolean isPotentiallyHazardousAsteroid;

	@SerializedName("is_sentry_object")
	private boolean isSentryObject;

	@SerializedName("name")
	private String name;

	@SerializedName("absolute_magnitude_h")
	private double absoluteMagnitudeH;

	@SerializedName("links")
	private Links links;

	@SerializedName("id")
	private String id;

	@SerializedName("close_approach_data")
	private List<CloseApproachDataItem> closeApproachData;

	public EstimatedDiameter getEstimatedDiameter(){
		return estimatedDiameter;
	}

	public String getNeoReferenceId(){
		return neoReferenceId;
	}

	public String getNasaJplUrl(){
		return nasaJplUrl;
	}

	public boolean isIsPotentiallyHazardousAsteroid(){
		return isPotentiallyHazardousAsteroid;
	}

	public boolean isIsSentryObject(){
		return isSentryObject;
	}

	public String getName(){
		return name;
	}

	public double getAbsoluteMagnitudeH(){
		return absoluteMagnitudeH;
	}

	public Links getLinks(){
		return links;
	}

	public String getId(){
		return id;
	}

	public List<CloseApproachDataItem> getCloseApproachData(){
		return closeApproachData;
	}

	@Override
	public String toString() {
		return "DateViseList{" +
				"estimatedDiameter=" + estimatedDiameter +
				", neoReferenceId='" + neoReferenceId + '\'' +
				", nasaJplUrl='" + nasaJplUrl + '\'' +
				", isPotentiallyHazardousAsteroid=" + isPotentiallyHazardousAsteroid +
				", isSentryObject=" + isSentryObject +
				", name='" + name + '\'' +
				", absoluteMagnitudeH=" + absoluteMagnitudeH +
				", links=" + links +
				", id='" + id + '\'' +
				", closeApproachData=" + closeApproachData +
				'}';
	}
}