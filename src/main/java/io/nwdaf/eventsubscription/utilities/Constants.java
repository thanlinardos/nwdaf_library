package io.nwdaf.eventsubscription.utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import io.nwdaf.eventsubscription.model.Ecgi;
import io.nwdaf.eventsubscription.model.GlobalRanNodeId;
import io.nwdaf.eventsubscription.model.Ncgi;
import io.nwdaf.eventsubscription.model.NetworkAreaInfo;
import io.nwdaf.eventsubscription.model.PlmnId;
import io.nwdaf.eventsubscription.model.Tai;
import io.nwdaf.eventsubscription.model.NwdafEvent.NwdafEventEnum;

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
}
