package com.bdwise.prometheus.client.converter.label;

import java.util.ArrayList;
import java.util.List;

import com.bdwise.prometheus.client.converter.Result;

public class DefaultLabelResult extends Result<String>{
	final List<String> result = new ArrayList<>();
	public void addData(String data) {
		result.add(data);
	}
	
	@Override
	public List<String> getResult() {
		return result;
	}

	@Override
	public String toString() {
		return "DefaultLabelResult [result=" + result + "]";
	}	

}
