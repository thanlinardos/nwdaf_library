package io.nwdaf.eventsubscription.model;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Indicates a Civic address.
 */
@Schema(description = "Indicates a Civic address.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-06-10T19:22:40.843464800+03:00[Europe/Athens]")

public class CivicAddress {
	@JsonProperty("country")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String country = null;

	@JsonProperty("A1")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String a1 = null;

	@JsonProperty("A2")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String a2 = null;

	@JsonProperty("A3")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String a3 = null;

	@JsonProperty("A4")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String a4 = null;

	@JsonProperty("A5")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String a5 = null;

	@JsonProperty("A6")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String a6 = null;

	@JsonProperty("PRD")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String PRD = null;

	@JsonProperty("POD")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String POD = null;

	@JsonProperty("STS")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String STS = null;

	@JsonProperty("HNO")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String HNO = null;

	@JsonProperty("HNS")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String HNS = null;

	@JsonProperty("LMK")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String LMK = null;

	@JsonProperty("LOC")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String LOC = null;

	@JsonProperty("NAM")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String NAM = null;

	@JsonProperty("PC")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String PC = null;

	@JsonProperty("BLD")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String BLD = null;

	@JsonProperty("UNIT")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String UNIT = null;

	@JsonProperty("FLR")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String FLR = null;

	@JsonProperty("ROOM")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String ROOM = null;

	@JsonProperty("PLC")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String PLC = null;

	@JsonProperty("PCN")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String PCN = null;

	@JsonProperty("POBOX")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String POBOX = null;

	@JsonProperty("ADDCODE")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String ADDCODE = null;

	@JsonProperty("SEAT")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String SEAT = null;

	@JsonProperty("RD")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String RD = null;

	@JsonProperty("RDSEC")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String RDSEC = null;

	@JsonProperty("RDBR")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String RDBR = null;

	@JsonProperty("RDSUBBR")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String RDSUBBR = null;

	@JsonProperty("PRM")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String PRM = null;

	@JsonProperty("POM")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String POM = null;

	@JsonProperty("usageRules")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String usageRules = null;

	@JsonProperty("method")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String method = null;

	@JsonProperty("providedBy")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String providedBy = null;

	public CivicAddress country(String country) {
		this.country = country;
		return this;
	}

	/**
	 * Get country
	 * 
	 * @return country
	 **/
	@Schema(description = "")

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public CivicAddress a1(String a1) {
		this.a1 = a1;
		return this;
	}

	/**
	 * Get a1
	 * 
	 * @return a1
	 **/
	@Schema(description = "")

	public String getA1() {
		return a1;
	}

	public void setA1(String a1) {
		this.a1 = a1;
	}

	public CivicAddress a2(String a2) {
		this.a2 = a2;
		return this;
	}

	/**
	 * Get a2
	 * 
	 * @return a2
	 **/
	@Schema(description = "")

	public String getA2() {
		return a2;
	}

	public void setA2(String a2) {
		this.a2 = a2;
	}

	public CivicAddress a3(String a3) {
		this.a3 = a3;
		return this;
	}

	/**
	 * Get a3
	 * 
	 * @return a3
	 **/
	@Schema(description = "")

	public String getA3() {
		return a3;
	}

	public void setA3(String a3) {
		this.a3 = a3;
	}

	public CivicAddress a4(String a4) {
		this.a4 = a4;
		return this;
	}

	/**
	 * Get a4
	 * 
	 * @return a4
	 **/
	@Schema(description = "")

	public String getA4() {
		return a4;
	}

	public void setA4(String a4) {
		this.a4 = a4;
	}

	public CivicAddress a5(String a5) {
		this.a5 = a5;
		return this;
	}

	/**
	 * Get a5
	 * 
	 * @return a5
	 **/
	@Schema(description = "")

	public String getA5() {
		return a5;
	}

	public void setA5(String a5) {
		this.a5 = a5;
	}

	public CivicAddress a6(String a6) {
		this.a6 = a6;
		return this;
	}

	/**
	 * Get a6
	 * 
	 * @return a6
	 **/
	@Schema(description = "")

	public String getA6() {
		return a6;
	}

	public void setA6(String a6) {
		this.a6 = a6;
	}

	public CivicAddress PRD(String PRD) {
		this.PRD = PRD;
		return this;
	}

	/**
	 * Get PRD
	 * 
	 * @return PRD
	 **/
	@Schema(description = "")

	public String getPRD() {
		return PRD;
	}

	public void setPRD(String PRD) {
		this.PRD = PRD;
	}

	public CivicAddress POD(String POD) {
		this.POD = POD;
		return this;
	}

	/**
	 * Get POD
	 * 
	 * @return POD
	 **/
	@Schema(description = "")

	public String getPOD() {
		return POD;
	}

	public void setPOD(String POD) {
		this.POD = POD;
	}

	public CivicAddress STS(String STS) {
		this.STS = STS;
		return this;
	}

	/**
	 * Get STS
	 * 
	 * @return STS
	 **/
	@Schema(description = "")

	public String getSTS() {
		return STS;
	}

	public void setSTS(String STS) {
		this.STS = STS;
	}

	public CivicAddress HNO(String HNO) {
		this.HNO = HNO;
		return this;
	}

	/**
	 * Get HNO
	 * 
	 * @return HNO
	 **/
	@Schema(description = "")

	public String getHNO() {
		return HNO;
	}

	public void setHNO(String HNO) {
		this.HNO = HNO;
	}

	public CivicAddress HNS(String HNS) {
		this.HNS = HNS;
		return this;
	}

	/**
	 * Get HNS
	 * 
	 * @return HNS
	 **/
	@Schema(description = "")

	public String getHNS() {
		return HNS;
	}

	public void setHNS(String HNS) {
		this.HNS = HNS;
	}

	public CivicAddress LMK(String LMK) {
		this.LMK = LMK;
		return this;
	}

	/**
	 * Get LMK
	 * 
	 * @return LMK
	 **/
	@Schema(description = "")

	public String getLMK() {
		return LMK;
	}

	public void setLMK(String LMK) {
		this.LMK = LMK;
	}

	public CivicAddress LOC(String LOC) {
		this.LOC = LOC;
		return this;
	}

	/**
	 * Get LOC
	 * 
	 * @return LOC
	 **/
	@Schema(description = "")

	public String getLOC() {
		return LOC;
	}

	public void setLOC(String LOC) {
		this.LOC = LOC;
	}

	public CivicAddress NAM(String NAM) {
		this.NAM = NAM;
		return this;
	}

	/**
	 * Get NAM
	 * 
	 * @return NAM
	 **/
	@Schema(description = "")

	public String getNAM() {
		return NAM;
	}

	public void setNAM(String NAM) {
		this.NAM = NAM;
	}

	public CivicAddress PC(String PC) {
		this.PC = PC;
		return this;
	}

	/**
	 * Get PC
	 * 
	 * @return PC
	 **/
	@Schema(description = "")

	public String getPC() {
		return PC;
	}

	public void setPC(String PC) {
		this.PC = PC;
	}

	public CivicAddress BLD(String BLD) {
		this.BLD = BLD;
		return this;
	}

	/**
	 * Get BLD
	 * 
	 * @return BLD
	 **/
	@Schema(description = "")

	public String getBLD() {
		return BLD;
	}

	public void setBLD(String BLD) {
		this.BLD = BLD;
	}

	public CivicAddress UNIT(String UNIT) {
		this.UNIT = UNIT;
		return this;
	}

	/**
	 * Get UNIT
	 * 
	 * @return UNIT
	 **/
	@Schema(description = "")

	public String getUNIT() {
		return UNIT;
	}

	public void setUNIT(String UNIT) {
		this.UNIT = UNIT;
	}

	public CivicAddress FLR(String FLR) {
		this.FLR = FLR;
		return this;
	}

	/**
	 * Get FLR
	 * 
	 * @return FLR
	 **/
	@Schema(description = "")

	public String getFLR() {
		return FLR;
	}

	public void setFLR(String FLR) {
		this.FLR = FLR;
	}

	public CivicAddress ROOM(String ROOM) {
		this.ROOM = ROOM;
		return this;
	}

	/**
	 * Get ROOM
	 * 
	 * @return ROOM
	 **/
	@Schema(description = "")

	public String getROOM() {
		return ROOM;
	}

	public void setROOM(String ROOM) {
		this.ROOM = ROOM;
	}

	public CivicAddress PLC(String PLC) {
		this.PLC = PLC;
		return this;
	}

	/**
	 * Get PLC
	 * 
	 * @return PLC
	 **/
	@Schema(description = "")

	public String getPLC() {
		return PLC;
	}

	public void setPLC(String PLC) {
		this.PLC = PLC;
	}

	public CivicAddress PCN(String PCN) {
		this.PCN = PCN;
		return this;
	}

	/**
	 * Get PCN
	 * 
	 * @return PCN
	 **/
	@Schema(description = "")

	public String getPCN() {
		return PCN;
	}

	public void setPCN(String PCN) {
		this.PCN = PCN;
	}

	public CivicAddress POBOX(String POBOX) {
		this.POBOX = POBOX;
		return this;
	}

	/**
	 * Get POBOX
	 * 
	 * @return POBOX
	 **/
	@Schema(description = "")

	public String getPOBOX() {
		return POBOX;
	}

	public void setPOBOX(String POBOX) {
		this.POBOX = POBOX;
	}

	public CivicAddress ADDCODE(String ADDCODE) {
		this.ADDCODE = ADDCODE;
		return this;
	}

	/**
	 * Get ADDCODE
	 * 
	 * @return ADDCODE
	 **/
	@Schema(description = "")

	public String getADDCODE() {
		return ADDCODE;
	}

	public void setADDCODE(String ADDCODE) {
		this.ADDCODE = ADDCODE;
	}

	public CivicAddress SEAT(String SEAT) {
		this.SEAT = SEAT;
		return this;
	}

	/**
	 * Get SEAT
	 * 
	 * @return SEAT
	 **/
	@Schema(description = "")

	public String getSEAT() {
		return SEAT;
	}

	public void setSEAT(String SEAT) {
		this.SEAT = SEAT;
	}

	public CivicAddress RD(String RD) {
		this.RD = RD;
		return this;
	}

	/**
	 * Get RD
	 * 
	 * @return RD
	 **/
	@Schema(description = "")

	public String getRD() {
		return RD;
	}

	public void setRD(String RD) {
		this.RD = RD;
	}

	public CivicAddress RDSEC(String RDSEC) {
		this.RDSEC = RDSEC;
		return this;
	}

	/**
	 * Get RDSEC
	 * 
	 * @return RDSEC
	 **/
	@Schema(description = "")

	public String getRDSEC() {
		return RDSEC;
	}

	public void setRDSEC(String RDSEC) {
		this.RDSEC = RDSEC;
	}

	public CivicAddress RDBR(String RDBR) {
		this.RDBR = RDBR;
		return this;
	}

	/**
	 * Get RDBR
	 * 
	 * @return RDBR
	 **/
	@Schema(description = "")

	public String getRDBR() {
		return RDBR;
	}

	public void setRDBR(String RDBR) {
		this.RDBR = RDBR;
	}

	public CivicAddress RDSUBBR(String RDSUBBR) {
		this.RDSUBBR = RDSUBBR;
		return this;
	}

	/**
	 * Get RDSUBBR
	 * 
	 * @return RDSUBBR
	 **/
	@Schema(description = "")

	public String getRDSUBBR() {
		return RDSUBBR;
	}

	public void setRDSUBBR(String RDSUBBR) {
		this.RDSUBBR = RDSUBBR;
	}

	public CivicAddress PRM(String PRM) {
		this.PRM = PRM;
		return this;
	}

	/**
	 * Get PRM
	 * 
	 * @return PRM
	 **/
	@Schema(description = "")

	public String getPRM() {
		return PRM;
	}

	public void setPRM(String PRM) {
		this.PRM = PRM;
	}

	public CivicAddress POM(String POM) {
		this.POM = POM;
		return this;
	}

	/**
	 * Get POM
	 * 
	 * @return POM
	 **/
	@Schema(description = "")

	public String getPOM() {
		return POM;
	}

	public void setPOM(String POM) {
		this.POM = POM;
	}

	public CivicAddress usageRules(String usageRules) {
		this.usageRules = usageRules;
		return this;
	}

	/**
	 * Get usageRules
	 * 
	 * @return usageRules
	 **/
	@Schema(description = "")

	public String getUsageRules() {
		return usageRules;
	}

	public void setUsageRules(String usageRules) {
		this.usageRules = usageRules;
	}

	public CivicAddress method(String method) {
		this.method = method;
		return this;
	}

	/**
	 * Get method
	 * 
	 * @return method
	 **/
	@Schema(description = "")

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public CivicAddress providedBy(String providedBy) {
		this.providedBy = providedBy;
		return this;
	}

	/**
	 * Get providedBy
	 * 
	 * @return providedBy
	 **/
	@Schema(description = "")

	public String getProvidedBy() {
		return providedBy;
	}

	public void setProvidedBy(String providedBy) {
		this.providedBy = providedBy;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CivicAddress civicAddress = (CivicAddress) o;
		return Objects.equals(this.country, civicAddress.country) &&
				Objects.equals(this.a1, civicAddress.a1) &&
				Objects.equals(this.a2, civicAddress.a2) &&
				Objects.equals(this.a3, civicAddress.a3) &&
				Objects.equals(this.a4, civicAddress.a4) &&
				Objects.equals(this.a5, civicAddress.a5) &&
				Objects.equals(this.a6, civicAddress.a6) &&
				Objects.equals(this.PRD, civicAddress.PRD) &&
				Objects.equals(this.POD, civicAddress.POD) &&
				Objects.equals(this.STS, civicAddress.STS) &&
				Objects.equals(this.HNO, civicAddress.HNO) &&
				Objects.equals(this.HNS, civicAddress.HNS) &&
				Objects.equals(this.LMK, civicAddress.LMK) &&
				Objects.equals(this.LOC, civicAddress.LOC) &&
				Objects.equals(this.NAM, civicAddress.NAM) &&
				Objects.equals(this.PC, civicAddress.PC) &&
				Objects.equals(this.BLD, civicAddress.BLD) &&
				Objects.equals(this.UNIT, civicAddress.UNIT) &&
				Objects.equals(this.FLR, civicAddress.FLR) &&
				Objects.equals(this.ROOM, civicAddress.ROOM) &&
				Objects.equals(this.PLC, civicAddress.PLC) &&
				Objects.equals(this.PCN, civicAddress.PCN) &&
				Objects.equals(this.POBOX, civicAddress.POBOX) &&
				Objects.equals(this.ADDCODE, civicAddress.ADDCODE) &&
				Objects.equals(this.SEAT, civicAddress.SEAT) &&
				Objects.equals(this.RD, civicAddress.RD) &&
				Objects.equals(this.RDSEC, civicAddress.RDSEC) &&
				Objects.equals(this.RDBR, civicAddress.RDBR) &&
				Objects.equals(this.RDSUBBR, civicAddress.RDSUBBR) &&
				Objects.equals(this.PRM, civicAddress.PRM) &&
				Objects.equals(this.POM, civicAddress.POM) &&
				Objects.equals(this.usageRules, civicAddress.usageRules) &&
				Objects.equals(this.method, civicAddress.method) &&
				Objects.equals(this.providedBy, civicAddress.providedBy);
	}

	@Override
	public int hashCode() {
		return Objects.hash(country, a1, a2, a3, a4, a5, a6, PRD, POD, STS, HNO, HNS, LMK, LOC, NAM, PC, BLD, UNIT, FLR,
				ROOM, PLC, PCN, POBOX, ADDCODE, SEAT, RD, RDSEC, RDBR, RDSUBBR, PRM, POM, usageRules, method,
				providedBy);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class CivicAddress {\n");

		sb.append("    country: ").append(toIndentedString(country)).append("\n");
		sb.append("    a1: ").append(toIndentedString(a1)).append("\n");
		sb.append("    a2: ").append(toIndentedString(a2)).append("\n");
		sb.append("    a3: ").append(toIndentedString(a3)).append("\n");
		sb.append("    a4: ").append(toIndentedString(a4)).append("\n");
		sb.append("    a5: ").append(toIndentedString(a5)).append("\n");
		sb.append("    a6: ").append(toIndentedString(a6)).append("\n");
		sb.append("    PRD: ").append(toIndentedString(PRD)).append("\n");
		sb.append("    POD: ").append(toIndentedString(POD)).append("\n");
		sb.append("    STS: ").append(toIndentedString(STS)).append("\n");
		sb.append("    HNO: ").append(toIndentedString(HNO)).append("\n");
		sb.append("    HNS: ").append(toIndentedString(HNS)).append("\n");
		sb.append("    LMK: ").append(toIndentedString(LMK)).append("\n");
		sb.append("    LOC: ").append(toIndentedString(LOC)).append("\n");
		sb.append("    NAM: ").append(toIndentedString(NAM)).append("\n");
		sb.append("    PC: ").append(toIndentedString(PC)).append("\n");
		sb.append("    BLD: ").append(toIndentedString(BLD)).append("\n");
		sb.append("    UNIT: ").append(toIndentedString(UNIT)).append("\n");
		sb.append("    FLR: ").append(toIndentedString(FLR)).append("\n");
		sb.append("    ROOM: ").append(toIndentedString(ROOM)).append("\n");
		sb.append("    PLC: ").append(toIndentedString(PLC)).append("\n");
		sb.append("    PCN: ").append(toIndentedString(PCN)).append("\n");
		sb.append("    POBOX: ").append(toIndentedString(POBOX)).append("\n");
		sb.append("    ADDCODE: ").append(toIndentedString(ADDCODE)).append("\n");
		sb.append("    SEAT: ").append(toIndentedString(SEAT)).append("\n");
		sb.append("    RD: ").append(toIndentedString(RD)).append("\n");
		sb.append("    RDSEC: ").append(toIndentedString(RDSEC)).append("\n");
		sb.append("    RDBR: ").append(toIndentedString(RDBR)).append("\n");
		sb.append("    RDSUBBR: ").append(toIndentedString(RDSUBBR)).append("\n");
		sb.append("    PRM: ").append(toIndentedString(PRM)).append("\n");
		sb.append("    POM: ").append(toIndentedString(POM)).append("\n");
		sb.append("    usageRules: ").append(toIndentedString(usageRules)).append("\n");
		sb.append("    method: ").append(toIndentedString(method)).append("\n");
		sb.append("    providedBy: ").append(toIndentedString(providedBy)).append("\n");
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
