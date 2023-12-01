package com.bdwise.prometheus.client.converter.series;

import java.util.ArrayList;
import java.util.List;

import com.bdwise.prometheus.client.converter.Result;

public class DefaultSeriesResult extends Result<SeriesResultItem>{
	final List<SeriesResultItem> result = new ArrayList<>();
	public void addData(SeriesResultItem data) {
		result.add(data);
	}
	
	@Override
	public List<SeriesResultItem> getResult() {
		return result;
	}

	@Override
	public String toString() {
		return "SeriesResultItem [result=" + result + "]";
	}	

}
