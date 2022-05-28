package com.example.firsttestproject.NearEarthAPI.Class;

import com.google.gson.annotations.SerializedName;

public class CloseApproachDataItem{

	@SerializedName("relative_velocity")
	private RelativeVelocity relativeVelocity;

	@SerializedName("orbiting_body")
	private String orbitingBody;

	@SerializedName("close_approach_date")
	private String closeApproachDate;

	@SerializedName("epoch_date_close_approach")
	private long epochDateCloseApproach;

	@SerializedName("close_approach_date_full")
	private String closeApproachDateFull;

	@SerializedName("miss_distance")
	private MissDistance missDistance;

	public RelativeVelocity getRelativeVelocity(){
		return relativeVelocity;
	}

	public String getOrbitingBody(){
		return orbitingBody;
	}

	public String getCloseApproachDate(){
		return closeApproachDate;
	}

	public long getEpochDateCloseApproach(){
		return epochDateCloseApproach;
	}

	public String getCloseApproachDateFull(){
		return closeApproachDateFull;
	}

	public MissDistance getMissDistance(){
		return missDistance;
	}

	@Override
	public String toString() {
		return "CloseApproachDataItem{" +
				"relativeVelocity=" + relativeVelocity +
				", orbitingBody='" + orbitingBody + '\'' +
				", closeApproachDate='" + closeApproachDate + '\'' +
				", epochDateCloseApproach=" + epochDateCloseApproach +
				", closeApproachDateFull='" + closeApproachDateFull + '\'' +
				", missDistance=" + missDistance +
				'}';
	}
}