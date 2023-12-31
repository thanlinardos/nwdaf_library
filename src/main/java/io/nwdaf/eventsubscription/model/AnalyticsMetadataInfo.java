package io.nwdaf.eventsubscription.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Contains analytics metadata information required for analytics aggregation.
 */
@Schema(description = "Contains analytics metadata information required for analytics aggregation.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-06-10T19:22:40.843464800+03:00[Europe/Athens]")

public class AnalyticsMetadataInfo {
	@JsonProperty("numSamples")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer numSamples = null;

	@JsonProperty("dataWindow")
	private TimeWindow dataWindow = null;

	@JsonProperty("dataStatProps")
	@Valid
	private List<DatasetStatisticalProperty> dataStatProps = null;

	@JsonProperty("strategy")
	private OutputStrategy strategy = null;

	@JsonProperty("accuracy")
	private Accuracy accuracy = null;

	public AnalyticsMetadataInfo numSamples(Integer numSamples) {
		this.numSamples = numSamples;
		return this;
	}

	/**
	 * Unsigned Integer, i.e. only value 0 and integers above 0 are permissible.
	 * minimum: 0
	 * 
	 * @return numSamples
	 **/
	@Schema(description = "Unsigned Integer, i.e. only value 0 and integers above 0 are permissible.")

	@Min(0)
	public Integer getNumSamples() {
		return numSamples;
	}

	public void setNumSamples(Integer numSamples) {
		this.numSamples = numSamples;
	}

	public AnalyticsMetadataInfo dataWindow(TimeWindow dataWindow) {
		this.dataWindow = dataWindow;
		return this;
	}

	/**
	 * Get dataWindow
	 * 
	 * @return dataWindow
	 **/
	@Schema(description = "")

	@Valid
	public TimeWindow getDataWindow() {
		return dataWindow;
	}

	public void setDataWindow(TimeWindow dataWindow) {
		this.dataWindow = dataWindow;
	}

	public AnalyticsMetadataInfo dataStatProps(List<DatasetStatisticalProperty> dataStatProps) {
		this.dataStatProps = dataStatProps;
		return this;
	}

	public AnalyticsMetadataInfo addDataStatPropsItem(DatasetStatisticalProperty dataStatPropsItem) {
		if (this.dataStatProps == null) {
			this.dataStatProps = new ArrayList<DatasetStatisticalProperty>();
		}
		this.dataStatProps.add(dataStatPropsItem);
		return this;
	}

	/**
	 * Get dataStatProps
	 * 
	 * @return dataStatProps
	 **/
	@Schema(description = "")
	@Valid
	@Size(min = 1)
	public List<DatasetStatisticalProperty> getDataStatProps() {
		return dataStatProps;
	}

	public void setDataStatProps(List<DatasetStatisticalProperty> dataStatProps) {
		this.dataStatProps = dataStatProps;
	}

	public AnalyticsMetadataInfo strategy(OutputStrategy strategy) {
		this.strategy = strategy;
		return this;
	}

	/**
	 * Get strategy
	 * 
	 * @return strategy
	 **/
	@Schema(description = "")

	@Valid
	public OutputStrategy getStrategy() {
		return strategy;
	}

	public void setStrategy(OutputStrategy strategy) {
		this.strategy = strategy;
	}

	public AnalyticsMetadataInfo accuracy(Accuracy accuracy) {
		this.accuracy = accuracy;
		return this;
	}

	/**
	 * Get accuracy
	 * 
	 * @return accuracy
	 **/
	@Schema(description = "")

	@Valid
	public Accuracy getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(Accuracy accuracy) {
		this.accuracy = accuracy;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		AnalyticsMetadataInfo analyticsMetadataInfo = (AnalyticsMetadataInfo) o;
		return Objects.equals(this.numSamples, analyticsMetadataInfo.numSamples) &&
				Objects.equals(this.dataWindow, analyticsMetadataInfo.dataWindow) &&
				Objects.equals(this.dataStatProps, analyticsMetadataInfo.dataStatProps) &&
				Objects.equals(this.strategy, analyticsMetadataInfo.strategy) &&
				Objects.equals(this.accuracy, analyticsMetadataInfo.accuracy);
	}

	@Override
	public int hashCode() {
		return Objects.hash(numSamples, dataWindow, dataStatProps, strategy, accuracy);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class AnalyticsMetadataInfo {\n");

		sb.append("    numSamples: ").append(toIndentedString(numSamples)).append("\n");
		sb.append("    dataWindow: ").append(toIndentedString(dataWindow)).append("\n");
		sb.append("    dataStatProps: ").append(toIndentedString(dataStatProps)).append("\n");
		sb.append("    strategy: ").append(toIndentedString(strategy)).append("\n");
		sb.append("    accuracy: ").append(toIndentedString(accuracy)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
