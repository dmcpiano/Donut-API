package co.grandcircus.DonutAPI.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


public class ResultsResponse {

	@JsonProperty("results")
	private List<Results> results;

	public List<Results> getResults() {
		return results;
	}

	public void setResults(List<Results> results) {
		this.results = results;
	}
}
