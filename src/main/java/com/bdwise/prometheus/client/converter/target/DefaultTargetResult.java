package com.bdwise.prometheus.client.converter.target;

import java.util.ArrayList;
import java.util.List;

import com.bdwise.prometheus.client.converter.Result;

public class DefaultTargetResult extends Result<TargetResultItem>{
	final List<TargetResultItem> activeTargets = new ArrayList<>();
	final List<TargetResultItem> droppedTargets = new ArrayList<>();
	public void addActiveTarget(TargetResultItem data) {
		activeTargets.add(data);
	}
	
	public void addDroppedTarget(TargetResultItem data) {
		droppedTargets.add(data);
	}
	
	@Override
	public List<TargetResultItem> getResult() {
		return activeTargets;
	}

	@Override
	public String toString() {
		return "TargetResultItem [activeTargets=" + activeTargets + ",droppedTargets="+droppedTargets+"]";
	}	

}