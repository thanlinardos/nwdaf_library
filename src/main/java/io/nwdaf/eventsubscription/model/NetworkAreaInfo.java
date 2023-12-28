package io.nwdaf.eventsubscription.model;

import java.util.*;
import java.util.regex.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.nwdaf.eventsubscription.utilities.ParserUtil;
import io.nwdaf.eventsubscription.utilities.Regex;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Describes a network area information in which the NF service consumer
 * requests the number of UEs.
 */
@Schema(description = "Describes a network area information in which the NF service consumer requests the number of UEs. ")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-06-10T19:22:40.843464800+03:00[Europe/Athens]")

public class NetworkAreaInfo {

	@JsonProperty("id")
	@Valid
	private UUID id = null;

	@JsonProperty("ecgis")
	@Valid
	private List<Ecgi> ecgis = null;

	@JsonProperty("ncgis")
	@Valid
	private List<Ncgi> ncgis = null;

	@JsonProperty("gRanNodeIds")
	@Valid
	private List<GlobalRanNodeId> gRanNodeIds = null;

	@JsonProperty("tais")
	@Valid
	private List<Tai> tais = null;

	@JsonProperty("containedAreaIds")
	@Valid
	private List<UUID> containedAreaIds = null;

	public NetworkAreaInfo id(UUID id) {
		this.id = id;
		return this;
	}

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public NetworkAreaInfo ecgis(List<Ecgi> ecgis) {
		this.ecgis = ecgis;
		return this;
	}

	public NetworkAreaInfo addEcgisItem(Ecgi ecgisItem) {
		if (this.ecgis == null) {
			this.ecgis = new ArrayList<Ecgi>();
		}
		this.ecgis.add(ecgisItem);
		return this;
	}

	/**
	 * Contains a list of E-UTRA cell identities.
	 * 
	 * @return ecgis
	 **/
	@Schema(description = "Contains a list of E-UTRA cell identities.")
	@Valid
	@Size(min = 1)
	public List<Ecgi> getEcgis() {
		return ecgis;
	}

	public void setEcgis(List<Ecgi> ecgis) {
		this.ecgis = ecgis;
	}

	public NetworkAreaInfo ncgis(List<Ncgi> ncgis) {
		this.ncgis = ncgis;
		return this;
	}

	public NetworkAreaInfo addNcgisItem(Ncgi ncgisItem) {
		if (this.ncgis == null) {
			this.ncgis = new ArrayList<Ncgi>();
		}
		this.ncgis.add(ncgisItem);
		return this;
	}

	/**
	 * Contains a list of NR cell identities.
	 * 
	 * @return ncgis
	 **/
	@Schema(description = "Contains a list of NR cell identities.")
	@Valid
	@Size(min = 1)
	public List<Ncgi> getNcgis() {
		return ncgis;
	}

	public void setNcgis(List<Ncgi> ncgis) {
		this.ncgis = ncgis;
	}

	public NetworkAreaInfo gRanNodeIds(List<GlobalRanNodeId> gRanNodeIds) {
		this.gRanNodeIds = gRanNodeIds;
		return this;
	}

	public NetworkAreaInfo addGRanNodeIdsItem(GlobalRanNodeId gRanNodeIdsItem) {
		if (this.gRanNodeIds == null) {
			this.gRanNodeIds = new ArrayList<GlobalRanNodeId>();
		}
		this.gRanNodeIds.add(gRanNodeIdsItem);
		return this;
	}

	/**
	 * Contains a list of NG RAN nodes.
	 * 
	 * @return gRanNodeIds
	 **/
	@Schema(description = "Contains a list of NG RAN nodes.")
	@Valid
	@Size(min = 1)
	public List<GlobalRanNodeId> getGRanNodeIds() {
		return gRanNodeIds;
	}

	public void setGRanNodeIds(List<GlobalRanNodeId> gRanNodeIds) {
		this.gRanNodeIds = gRanNodeIds;
	}

	public NetworkAreaInfo tais(List<Tai> tais) {
		this.tais = tais;
		return this;
	}

	public NetworkAreaInfo addTaisItem(Tai taisItem) {
		if (this.tais == null) {
			this.tais = new ArrayList<Tai>();
		}
		this.tais.add(taisItem);
		return this;
	}

	/**
	 * Contains a list of tracking area identities.
	 * 
	 * @return tais
	 **/
	@Schema(description = "Contains a list of tracking area identities.")
	@Valid
	@Size(min = 1)
	public List<Tai> getTais() {
		return tais;
	}

	public void setTais(List<Tai> tais) {
		this.tais = tais;
	}

	public NetworkAreaInfo containedAreaIds(List<UUID> containedAreaIds) {
		this.containedAreaIds = containedAreaIds;
		return this;
	}

	public NetworkAreaInfo addContainedAreaIdsItem(UUID containedAreaIdsItem) {
		if (this.containedAreaIds == null) {
			this.containedAreaIds = new ArrayList<UUID>();
		}
		this.containedAreaIds.add(containedAreaIdsItem);
		return this;
	}

	/**
	 * Contains a list of aois inside of this aoi.
	 * 
	 * @return containedAreaIds
	 **/
	@Schema(description = "Contains a list of aois inside of this aoi.")
	@Valid
	@Size(min = 1)
	public List<UUID> getContainedAreaIds() {
		return containedAreaIds;
	}

	public void setContainedAreaIds(List<UUID> containedAreaIds) {
		this.containedAreaIds = containedAreaIds;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		NetworkAreaInfo networkAreaInfo = (NetworkAreaInfo) o;
		return Objects.equals(this.ecgis, networkAreaInfo.ecgis) &&
				Objects.equals(this.ncgis, networkAreaInfo.ncgis) &&
				Objects.equals(this.gRanNodeIds, networkAreaInfo.gRanNodeIds) &&
				Objects.equals(this.tais, networkAreaInfo.tais);
	}

	@Override
	public int hashCode() {
		return Objects.hash(ecgis, ncgis, gRanNodeIds, tais);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class NetworkAreaInfo {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    ecgis: ").append(toIndentedString(ecgis)).append("\n");
		sb.append("    ncgis: ").append(toIndentedString(ncgis)).append("\n");
		sb.append("    gRanNodeIds: ").append(toIndentedString(gRanNodeIds)).append("\n");
		sb.append("    tais: ").append(toIndentedString(tais)).append("\n");
		sb.append("    containedAreaIds: ").append(toIndentedString(containedAreaIds)).append("\n");
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

	// checks if given networkarea is contained within this object by checking each
	// registered cell object
	public boolean containsArea(NetworkAreaInfo area) {
		if (area.getEcgis() != null) {
			if (this.ecgis != null) {
				for (int i = 0; i < area.getEcgis().size(); i++) {
					if (area.getEcgis().get(i) != null && !this.getEcgis().contains(area.getEcgis().get(i))) {
						return false;
					}
				}
			} else {
				if (area.getEcgis().size() > 0) {
					for (int i = 0; i < area.getEcgis().size(); i++) {
						if (area.getEcgis().get(i) != null) {
							return false;
						}
					}
				}
			}
		}
		if (area.getGRanNodeIds() != null) {
			if (this.gRanNodeIds != null) {
				for (int i = 0; i < area.getGRanNodeIds().size(); i++) {
					if (area.getGRanNodeIds().get(i) != null
							&& !this.getGRanNodeIds().contains(area.getGRanNodeIds().get(i))) {
						return false;
					}
				}
			} else {
				if (area.getGRanNodeIds().size() > 0) {
					for (int i = 0; i < area.getGRanNodeIds().size(); i++) {
						if (area.getGRanNodeIds().get(i) != null) {
							return false;
						}
					}
				}
			}
		}
		if (area.getNcgis() != null) {
			if (this.ncgis != null) {
				for (int i = 0; i < area.getNcgis().size(); i++) {
					if (area.getNcgis().get(i) != null && !this.getNcgis().contains(area.getNcgis().get(i))) {
						return false;
					}
				}
			} else {
				if (area.getNcgis().size() > 0) {
					for (int i = 0; i < area.getNcgis().size(); i++) {
						if (area.getNcgis().get(i) != null) {
							return false;
						}
					}
				}
			}
		}
		if (area.getTais() != null) {
			if (this.tais != null) {
				for (int i = 0; i < area.getTais().size(); i++) {
					if (area.getTais().get(i) != null && !this.getTais().contains(area.getTais().get(i))) {
						return false;
					}
				}
			} else {
				if (area.getTais().size() > 0) {
					for (int i = 0; i < area.getTais().size(); i++) {
						if (area.getTais().get(i) != null) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}

	public boolean hasPlmnId(PlmnId plmnId) {
		if (this.ncgis != null && this.ncgis.size() != 0) {
			for (int i = 0; i < this.ncgis.size(); i++) {
				if (this.ncgis.get(i).getPlmnId().equals(plmnId)) {
					return true;
				}
			}
		}
		if (this.ecgis.size() != 0) {
			for (int i = 0; i < this.ecgis.size(); i++) {
				if (this.ecgis.get(i).getPlmnId().equals(plmnId)) {
					return true;
				}
			}
		}
		if (this.gRanNodeIds.size() != 0) {
			for (int i = 0; i < this.gRanNodeIds.size(); i++) {
				if (this.gRanNodeIds.get(i).getPlmnId().equals(plmnId)) {
					return true;
				}
			}
		}
		if (this.tais.size() != 0) {
			for (int i = 0; i < this.tais.size(); i++) {
				if (this.tais.get(i).getPlmnId().equals(plmnId)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean containsUserLocation(UserLocation userLocation) {
		if (userLocation.getEutraLocation() != null) {
			EutraLocation eutraLocation = userLocation.getEutraLocation();
			if (eutraLocation.getEcgi() != null) {
				if (this.ecgis == null || this.ecgis.size() == 0 || !this.ecgis.contains(eutraLocation.getEcgi())) {
					return false;
				}
			}
			if (eutraLocation.getGlobalENbId() != null && eutraLocation.getGlobalENbId().getENbId() != null
					&& Pattern.matches(Regex.eNbId, eutraLocation.getGlobalENbId().getENbId())) {
				if (this.gRanNodeIds == null || this.gRanNodeIds.size() == 0
						|| !this.gRanNodeIds.contains(eutraLocation.getGlobalENbId())) {
					return false;
				}
			}
			if (eutraLocation.getGlobalNgenbId() != null && eutraLocation.getGlobalNgenbId().getNgeNbId() != null
					&& Pattern.matches(Regex.ngeNbId, eutraLocation.getGlobalNgenbId().getNgeNbId())) {
				if (this.gRanNodeIds == null || this.gRanNodeIds.size() == 0
						|| !this.gRanNodeIds.contains(eutraLocation.getGlobalNgenbId())) {
					return false;
				}
			}
			if (eutraLocation.getTai() != null) {
				if (this.tais == null || this.tais.size() == 0 || !this.tais.contains(eutraLocation.getTai())) {
					return false;
				}
			}
		}
		if (userLocation.getN3gaLocation() != null) {
			N3gaLocation n3gaLocation = userLocation.getN3gaLocation();
			if (n3gaLocation.getN3gppTai() != null) {
				if (this.tais == null || this.tais.size() == 0 || !this.tais.contains(n3gaLocation.getN3gppTai())) {
					return false;
				}
			}
			if (n3gaLocation.getN3IwfId() != null && Pattern.matches(Regex.n3IwfId, n3gaLocation.getN3IwfId())) {
				if (this.gRanNodeIds == null || this.gRanNodeIds.size() == 0) {
					return false;
				}
				boolean found = false;
				for (int i = 0; i < this.gRanNodeIds.size(); i++) {
					if (this.gRanNodeIds.get(i).getN3IwfId().equals(n3gaLocation.getN3IwfId())) {
						found = true;
					}
				}
				if (!found) {
					return false;
				}
			}
		}
		if (userLocation.getNrLocation() != null) {
			NrLocation nrLocation = userLocation.getNrLocation();
			if (nrLocation.getNcgi() != null) {
				if (this.ncgis == null || this.ncgis.size() == 0 || !this.ncgis.contains(nrLocation.getNcgi())) {
					return false;
				}
			}
			if (nrLocation.getTai() != null) {
				if (this.tais == null || this.tais.size() == 0 || !this.tais.contains(nrLocation.getTai())) {
					return false;
				}
			}
		}
		if (userLocation.getGeraLocation() != null) {
			GeraLocation geraLocation = userLocation.getGeraLocation();
			if (geraLocation.getCgi() != null && !this.hasPlmnId(geraLocation.getCgi().getPlmnId())) {
				return false;
			}
			if (geraLocation.getRai() != null && !this.hasPlmnId(geraLocation.getRai().getPlmnId())) {
				return false;
			}
			if (geraLocation.getLai() != null && !this.hasPlmnId(geraLocation.getLai().getPlmnId())) {
				return false;
			}
		}
		if (userLocation.getUtraLocation() != null) {
			UtraLocation utraLocation = userLocation.getUtraLocation();
			if (utraLocation.getCgi() != null && !this.hasPlmnId(utraLocation.getCgi().getPlmnId())) {
				return false;
			}
			if (utraLocation.getRai() != null && !this.hasPlmnId(utraLocation.getRai().getPlmnId())) {
				return false;
			}
			if (utraLocation.getLai() != null && !this.hasPlmnId(utraLocation.getLai().getPlmnId())) {
				return false;
			}
			if (utraLocation.getLai() != null && !this.hasPlmnId(utraLocation.getLai().getPlmnId())) {
				return false;
			}
			if (utraLocation.getSai() != null && !this.hasPlmnId(utraLocation.getSai().getPlmnId())) {
				return false;
			}
		}
		return true;
	}

	public Map<String, Object> toMap() {
		Map<String, Object> map = new HashMap<>();
		map.put("containedAreaIds",this.containedAreaIds);
		map.put("id",ParserUtil.safeParseString(this.id));
		List<Map<String, Object>> tais = new ArrayList<>();
		if (this.tais != null) {
			for (int i = 0; i < this.tais.size(); i++) {
				if (this.tais.get(i) != null) {
					tais.add(this.tais.get(i).toMap());
				}
			}
		}
		map.put("tais", tais);
		List<Map<String, Object>> ncgis = new ArrayList<>();
		if (this.ncgis != null) {
			for (int i = 0; i < this.ncgis.size(); i++) {
				if (this.ncgis.get(i) != null) {
					ncgis.add(this.ncgis.get(i).toMap());
				}
			}
		}
		map.put("ncgis", ncgis);
		List<Map<String, Object>> ecgis = new ArrayList<>();
		if (this.ecgis != null) {
			for (int i = 0; i < this.ecgis.size(); i++) {
				if (this.ecgis.get(i) != null) {
					ecgis.add(this.ecgis.get(i).toMap());
				}
			}
		}
		map.put("ecgis", ecgis);
		List<Map<String, Object>> gRanNodeIds = new ArrayList<>();
		if (this.gRanNodeIds != null) {
			for (int i = 0; i < this.gRanNodeIds.size(); i++) {
				if (this.gRanNodeIds.get(i) != null) {
					gRanNodeIds.add(this.gRanNodeIds.get(i).toMap());
				}
			}
		}
		map.put("gRanNodeIds", gRanNodeIds);
		return map;
	}

	public static NetworkAreaInfo fromMap(Map<String, Object> map) {
		if (map == null) {
			return null;
		}
		NetworkAreaInfo result = new NetworkAreaInfo();
		result.setId(ParserUtil.safeParseUUID((String) map.get("id")));
		result.setContainedAreaIds((List<UUID>) map.get("containedAreaIds"));
		List<Map<String, Object>> ecgis = (List<Map<String, Object>>) map.get("ecgis");
		for (Map<String, Object> ecgi : ecgis) {
			result.addEcgisItem(Ecgi.fromMap(ecgi));
		}
		List<Map<String, Object>> ncgis = (List<Map<String, Object>>) map.get("ncgis");
		for (Map<String, Object> ncgi : ncgis) {
			result.addNcgisItem(Ncgi.fromMap(ncgi));
		}
		List<Map<String, Object>> tais = (List<Map<String, Object>>) map.get("tais");
		for (Map<String, Object> tai : tais) {
			result.addTaisItem(Tai.fromMap(tai));
		}
		List<Map<String, Object>> gRanNodeIds = (List<Map<String, Object>>) map.get("gRanNodeIds");
		for (Map<String, Object> gRanNodeId : gRanNodeIds) {
			result.addGRanNodeIdsItem(GlobalRanNodeId.fromMap(gRanNodeId));
		}
		return result;
	}
}
