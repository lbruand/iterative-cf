package com.github.pmerienne.trident.cf.model;

import java.io.Serializable;

public class WeightedRating implements Serializable {

	private static final long serialVersionUID = -5258898356254433548L;

	public final double normalizingFactor;
	public final double weightedSum;

	public WeightedRating() {
		this.normalizingFactor = 0.0;
		this.weightedSum = 0.0;
	}

	public WeightedRating(double normalizingFactor, double weightedSum) {
		this.normalizingFactor = normalizingFactor;
		this.weightedSum = weightedSum;
	}

	public WeightedRating addRatting(double rating, double similarity) {
		return new WeightedRating(this.normalizingFactor + Math.abs(similarity), this.weightedSum + similarity * rating);
	}

	public double getWeightedRating() {
		return (1.0 / this.normalizingFactor) * this.weightedSum;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(normalizingFactor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(weightedSum);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WeightedRating other = (WeightedRating) obj;
		if (Double.doubleToLongBits(normalizingFactor) != Double.doubleToLongBits(other.normalizingFactor))
			return false;
		if (Double.doubleToLongBits(weightedSum) != Double.doubleToLongBits(other.weightedSum))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "WeightedRating [normalizingFactor=" + normalizingFactor + ", weightedSum=" + weightedSum + ", weightedRating=" + getWeightedRating() + "]";
	}

}