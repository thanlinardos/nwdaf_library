package io.nwdaf.eventsubscription.utilities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import io.nwdaf.eventsubscription.model.*;
import io.nwdaf.eventsubscription.model.NwdafEvent.NwdafEventEnum;

import static java.util.Map.entry;

public class Constants {
	public static Integer MIN_PERIOD_SECONDS = 1;
	public static Integer MAX_PERIOD_SECONDS = 600;
	public static List<NwdafEventEnum> supportedEvents = new ArrayList<>(Arrays.asList(NwdafEventEnum.NF_LOAD,NwdafEventEnum.UE_MOBILITY));
	//check 5.1.8-1 table (135) from 3gpp 29520-h80 and for encoding : 29571-h80 (17) table 5.2.2-3
	//Events supported: 2(UeMobility), 7(NfLoad), 11(EneNA), 17(NfLoadExt), 22(UeMobilityExt)
	public static String supportedFeatures = "210442";  //all 24 features: FFFFFF
	public static List<Integer> supportedFeaturesList = new ArrayList<>(Arrays.asList(2,7,11,17,22));
	public static List<String> supportedFeaturesNames = new ArrayList<>(Arrays.asList("ServiceExperience", "UeMobility", "UeCommunication", "QoSSustainability", "AbnormalBehaviour", "UserDataCongestion", "NfLoad", "NetworkPerformance", "NsiLoad", "ES3XX Extended", "EneNA", "UserDataCongestionExt", "Aggregation", "NsiLoadExt", "ServiceExperienceExt", "DnPerformance", "NfLoadExt", "Dispersion", "RedundantTransmissionExp", "WlanPerformance", "UeCommunicationExt", "UeMobilityExt", "AnaCtxTransfer", "AnaSubTransfer"));
	public static List<String> supportedFeaturesDesc = new ArrayList<>(Arrays.asList("This feature indicates support for the event related to service experience.", "This feature indicates the support of analytics based on UE mobility information.", "This feature indicates the support of analytics based on UE communication information.", "This feature indicates support for the event related to QoS sustainability.", "This feature indicates support for the event related to abnormal behaviour information.", "This feature indicates support for the event related to user data congestion.", "This feature indicates the support of the analytics related to the load of NF instances.", "This feature indicates the support of analytics based on network performance.", "This feature indicates the support of the event related to the load level of Network Slice and the optionally associated Network Slice Instance.", "This feature indicates the support of redirection for any service operation, according to Stateless NF procedures as specified in clauses 6.5.3.2 and 6.5.3.3 of 3GPP TS 29.500 [6] and according to HTTP redirection principles for indirect communication, as specified in clause 6.10.9 of 3GPP TS 29.500 [6].", "This feature indicates support for the enhancements of network data analytics requirements.", "This feature indicates support for the extensions to the event related to user data congestion, including support of GPSI and/or list of Top applications. Supporting this feature also requires the support of feature UserDataCongestion.", "This feature indicates support for analytics aggregation.", "This feature indicates support for the extensions to the event related to the load level of Network Slice and the optionally associated Network Slice Instance, including support of the area of interest, NF load information, and the number of UE or number of PDU Session. Supporting this feature also requires the support of feature NsiLoad.", "This feature indicates support for the extensions to the event related to service experience, including support of RAT type and/or Frequency. Supporting this feature also requires the support of feature ServiceExperience.", "This feature indicates the support of the analytics related to DN performance.", "This feature indicates support for the extensions to the event related to the load of NF instances, including NF load over the area of interest. Supporting this feature also requires the support of feature NfLoad.", "This feature indicates support for the analytics related to dispersion analytics information.", "This feature indicates support of the analytics related to redundant transmission experience analytics information.", "This feature indicates support of the analytics related to WLAN performance information.", "This feature indicates the support of the analytics related to UE communication.", "This feature indicates support for extensions to the event related to UE mobility, including support of LADN DNN to refer to the LADN service area as the AOI. Supporting this feature also requires the support of feature UeMobility.", "This feature indicates support for functionality related to Analytics Context Transfer.", "This feature indicates support for Analytics Subscription Transfer initiated by the source NWDAF."));
	public static String cpuQuerry = "sum by (name,id,nfType) (rate(container_cpu_usage_seconds_total{image!=\"\",container_label_org_label_schema_group=\"\",nfType!=\"\"}[1m])) / scalar(count(node_cpu_seconds_total{mode=\"user\"})) * 100";
	public static String memQuerry = "sum by (name,id,nfType)(container_memory_usage_bytes{image!=\"\",container_label_org_label_schema_group=\"\",nfType!=\"\"}) / scalar(sum(node_memory_MemTotal_bytes)) * 100";
	public static String storageQuerry = "sum by (name,id,nfType)(container_fs_usage_bytes{image!=\"\",container_label_org_label_schema_group=\"\",nfType!=\"\"}) / scalar(sum(node_filesystem_size_bytes{fstype=\"tmpfs\"})) * 100";
	public static String maxCpuQuerry = "max by (name,id,nfType) (rate(container_cpu_usage_seconds_total{image!=\"\",container_label_org_label_schema_group=\"\"}[1m])) * 100";
	public static String maxMemQuerry = "sum by (name,id,nfType)(max_over_time(container_memory_usage_bytes{image!=\"\",container_label_org_label_schema_group=\"\",nfType!=\"\"}[1m])) / scalar(sum(node_memory_MemTotal_bytes)) * 100";
	public static String maxStorageQuerry = "sum by (name,id,nfType)(max_over_time(container_fs_usage_bytes{image!=\"\",container_label_org_label_schema_group=\"\",nfType!=\"\"}[1m])) / scalar(sum(node_filesystem_size_bytes{fstype=\"tmpfs\"})) * 100";
	public static PlmnId plmnId = new PlmnId().mcc("123").mnc("123");
	public static NetworkAreaInfo ServingAreaOfInterest = new NetworkAreaInfo()
	.id(UUID.fromString("dca7adaa-834e-4d05-b373-297a986a5256"))
	.addEcgisItem(new Ecgi().plmnId(plmnId).eutraCellId("FFFFFFF"))
	.addEcgisItem(new Ecgi().plmnId(plmnId).eutraCellId("0000000"))
	.addGRanNodeIdsItem(new GlobalRanNodeId().plmnId(plmnId).ngeNbId("MacroNGeNB-00000"))
	.addGRanNodeIdsItem(new GlobalRanNodeId().plmnId(plmnId).eNbId("MacroeNB-00000"))
	.addGRanNodeIdsItem(new GlobalRanNodeId().plmnId(plmnId).n3IwfId("FFFFFFFFFFFF"))
	.addNcgisItem(new Ncgi().plmnId(plmnId).nid("00000000000").nrCellId("000000000"))
	.addNcgisItem(new Ncgi().plmnId(plmnId).nid("FFFFFFFFFFF").nrCellId("000000000"))
	.addTaisItem(new Tai().plmnId(plmnId).nid("00000000000").tac("0000"))
	.addTaisItem(new Tai().plmnId(plmnId).nid("FFFFFFFFFFF").tac("FFFF"))
	;
	// inside serving aoi in this example:
	public static NetworkAreaInfo AreaOfInterestExample1 = new NetworkAreaInfo()
	.id(UUID.fromString("f6af027d-9084-4f5f-a039-b863d7b1f540"))
	.addEcgisItem(new Ecgi().plmnId(plmnId).eutraCellId("FFFFFFF"))
	.addNcgisItem(new Ncgi().plmnId(plmnId).nid("00000000000").nrCellId("000000000"))
	.addNcgisItem(new Ncgi().plmnId(plmnId).nid("FFFFFFFFFFF").nrCellId("000000000"))
	.addTaisItem(new Tai().plmnId(plmnId).nid("00000000000").tac("0000"))
	.addTaisItem(new Tai().plmnId(plmnId).nid("FFFFFFFFFFF").tac("FFFF"))
	;
	public static NetworkAreaInfo AreaOfInterestExample2 = new NetworkAreaInfo()
	.id(UUID.fromString("80bff104-c082-4d55-8514-d9243e7ba1d1"))
	.addEcgisItem(new Ecgi().plmnId(plmnId).eutraCellId("FFFFFFF"))
	.addTaisItem(new Tai().plmnId(plmnId).nid("00000000000").tac("0000"))
	.addTaisItem(new Tai().plmnId(plmnId).nid("FFFFFFFFFFF").tac("FFFF"))
	;
	public static NetworkAreaInfo AreaOfInterestExample3 = new NetworkAreaInfo()
	.id(UUID.fromString("c7d7cb53-f345-4753-8a3f-0c821c4ed961"))
	.addEcgisItem(new Ecgi().plmnId(plmnId).eutraCellId("FFFFFFF"))
	.addGRanNodeIdsItem(new GlobalRanNodeId().plmnId(plmnId).ngeNbId("MacroNGeNB-00000"))
	.addGRanNodeIdsItem(new GlobalRanNodeId().plmnId(plmnId).eNbId("MacroeNB-00000"))
	.addGRanNodeIdsItem(new GlobalRanNodeId().plmnId(plmnId).n3IwfId("FFFFFFFFFFFF"))
	.addNcgisItem(new Ncgi().plmnId(plmnId).nid("00000000000").nrCellId("000000000"))
	.addNcgisItem(new Ncgi().plmnId(plmnId).nid("FFFFFFFFFFF").nrCellId("000000000"))
	.addTaisItem(new Tai().plmnId(plmnId).nid("00000000000").tac("0000"))
	.addTaisItem(new Tai().plmnId(plmnId).nid("FFFFFFFFFFF").tac("FFFF"))
	;
	public static Map<UUID,NetworkAreaInfo> ExampleAOIsMap = initExampleAOIsMap();
	public static Map<NetworkAreaInfo,UUID> ExampleAOIsToUUIDsMap = initExampleAOIsToUUIDsMap();

	public static Map<UUID,NetworkAreaInfo> initExampleAOIsMap(){
		Map<UUID,NetworkAreaInfo> res = new HashMap<>();
		res.put(ServingAreaOfInterest.getId(), ServingAreaOfInterest);
		res.put(AreaOfInterestExample1.getId(), AreaOfInterestExample1);
		res.put(AreaOfInterestExample2.getId(), AreaOfInterestExample2);
		res.put(AreaOfInterestExample3.getId(), AreaOfInterestExample3);
		return res;
	}

	public static Map<NetworkAreaInfo,UUID> initExampleAOIsToUUIDsMap(){
		Map<NetworkAreaInfo,UUID> res = new HashMap<>();
		res.put(ServingAreaOfInterest, ServingAreaOfInterest.getId());
		res.put(AreaOfInterestExample1, AreaOfInterestExample1.getId());
		res.put(AreaOfInterestExample2, AreaOfInterestExample2.getId());
		res.put(AreaOfInterestExample3, AreaOfInterestExample3.getId());
		return res;
	}

	public static String nfloadPostgresColumnFormat = "CAST(ROUND(AVG(CAST(data->>'%1$s' as numeric))) as integer) AS %1$s,";
	public static BigDecimal ONE_BILLION = new BigDecimal(1_000_000_000);
	public static String[] nfLoadThresholdProps = { "nfCpuUsage", "nfMemoryUsage", "nfStorageUsage", "nfLoadLevelAverage" };
	public static Map<String,String> ethernetTypesDescription = Map.ofEntries(
			entry("0800", "Internet Protocol Version 4 (IPv4)"),
			entry("0806", "Address Resolution Protocol (ARP)"),
			entry("0808", "Frame Relay ARP"),
			entry("22F3", "TRILL"),
			entry("22F4", "L2-IS-IS"),
			entry("8035", "Reverse Address Resolution Protocol (RARP)"),
			entry("86DD", "Internet Protocol Version 6 (IPv6)"),
			entry("880B", "Point-to-Point Protocol (PPP)"),
			entry("880C", "General Switch Management Protocol (GSMP)"),
			entry("8847", "MPLS"),
			entry("8848", "MPLS with upstream-assigned label"),
			entry("8861", "Multicast Channel Allocation Protocol (MCAP)"),
			entry("8863", "PPP over Ethernet (PPPoE) Discovery Stage"),
			entry("8864", "PPP over Ethernet (PPPoE) Session Stage"),
			entry("893B", "TRILL Fine Grained Labeling (FGL)"),
			entry("8946", "TRILL RBridge Channel"),
			entry("8100", "IEEE Std 802.1Q - Customer VLAN Tag Type (C-Tag, formerly called the Q-Tag)"),
			entry("8808", "IEEE Std 802.3 - Ethernet Passive Optical Network (EPON)"),
			entry("888E", "IEEE Std 802.1X - Port-based network access control"),
			entry("88A8", "IEEE Std 802.1Q - Service VLAN tag identifier (S-Tag)"),
			entry("88B5", "IEEE Std 802 - Local Experimental Ethertype"),
			entry("88B6", "IEEE Std 802 - Local Experimental Ethertype"),
			entry("88B7", "IEEE Std 802 - OUI Extended Ethertype"),
			entry("88C7", "IEEE Std 802.11 - Pre-Authentication (802.11i)"),
			entry("88CC", "IEEE Std 802.1AB - Link Layer Discovery Protocol (LLDP)"),
			entry("88E5", "IEEE Std 802.1AE - Media Access Control Security"),
			entry("88F5", "IEEE Std 802.1Q - Multiple VLAN Registration Protocol (MVRP)"),
			entry("88F6", "IEEE Std 802.1Q - Multiple Multicast Registration Protocol (MMRP)"),
			entry("890D", "IEEE Std 802.11 - Fast Roaming Remote Request (802.11r)"),
			entry("8917", "IEEE Std 802.21 - Media Independent Handover Protocol"),
			entry("8929", "IEEE Std 802.1Qbe - Multiple I-SID Registration Protocol"),
			entry("8940", "IEEE Std 802.1Qbg - ECP Protocol (also used in 802.1BR)")
	);
	public static List<String> ethernetTypes = new ArrayList<>(ethernetTypesDescription.keySet());
	public static IpFilterRule exampleIpv4FilterRule = IpFilterRule.builder()
															.code(507)
															.vendorId(10415)
															.ipVersion("4")
															.sourceIpAddr(new IpAddr().ipv4Addr("192.168.1.1"))
															.sourceIpAddrMask(new IpAddr().ipv4Addr("255.255.255.0"))
															.destIpAddr(new IpAddr().ipv4Addr("10.0.0.1"))
															.destIpAddrMask(new IpAddr().ipv4Addr("255.255.255.255"))
															.transportProtocol(new TransportProtocol().transportProtocol(TransportProtocol.TransportProtocolEnum.TCP))
															.sourcePort(80)
															.destinationPort(8080)
															.direction(new FlowDirection().fDir(FlowDirection.FlowDirectionEnum.UPLINK))
															.build();
	public static String exampleIpFilterRule = """
                                                    IPFilterRule AVP:
                                                    Code: 507
                                                    Vendor ID: 10415
                                                    IP Version: 4
                                                    IP Source Address: 192.168.1.1
                                                    IP Source Mask: 255.255.255.0
                                                    IP Destination Address: 10.0.0.1
                                                    IP Destination Mask: 255.255.255.255
                                                    Protocol: TCP (6)
                                                    Source Port: 80
                                                    Destination Port: 8080
                                                    Direction: Uplink""";
	public static String exampleDnn = "nidFFFFFFFFFFF.mcc123.mnc123.gprs";
}
