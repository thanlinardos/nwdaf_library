package io.nwdaf.eventsubscription.utilities;

import java.util.List;

import io.nwdaf.eventsubscription.model.AnalyticsSubset;
import io.nwdaf.eventsubscription.model.NfLoadLevelInformation;
import io.nwdaf.eventsubscription.model.AnalyticsSubset.AnalyticsSubsetEnum;

public class OtherUtil {
    public static String setNfloadPostgresColumns(String columns, List<AnalyticsSubset> listOfAnaSubsets){
        String columnFormat = Constants.nfloadPostgresColumnFormat;
		if(ParserUtil.safeParseContains(listOfAnaSubsets,new AnalyticsSubset().anaSubset(AnalyticsSubsetEnum.NF_RESOURCE_USAGE))){
			columns += String.format(columnFormat,"nfCpuUsage");
			columns += String.format(columnFormat,"nfMemoryUsage");
			columns += String.format(columnFormat,"nfStorageUsage");
			columns += "NULL as nfLoadLevelAverage,";
			columns += "NULL as nfLoadAvgInAoi,";
			columns += "NULL as nfLoadLevelpeak,";
		}
		if(ParserUtil.safeParseContains(listOfAnaSubsets,new AnalyticsSubset().anaSubset(AnalyticsSubsetEnum.NF_LOAD))){
			columns += "NULL as nfCpuUsage,";
			columns += "NULL as nfMemoryUsage,";
			columns += "NULL as nfStorageUsage,";
			columns += String.format(columnFormat,"nfLoadLevelAverage");
			columns += "NULL as nfLoadAvgInAoi,";
			columns += "NULL as nfLoadLevelpeak,";
		}
		if(ParserUtil.safeParseContains(listOfAnaSubsets,new AnalyticsSubset().anaSubset(AnalyticsSubsetEnum.NF_LOAD_AVG_IN_AOI))){
			columns += "NULL as nfCpuUsage,";
			columns += "NULL as nfMemoryUsage,";
			columns += "NULL as nfStorageUsage,";
			columns += "NULL as nfLoadLevelAverage,";
			columns += String.format(columnFormat,"nfLoadAvgInAoi");
			columns += "NULL as nfLoadLevelpeak,";
		}
		if(ParserUtil.safeParseContains(listOfAnaSubsets,new AnalyticsSubset().anaSubset(AnalyticsSubsetEnum.NF_PEAK_LOAD))){
			columns += "NULL as nfCpuUsage,";
			columns += "NULL as nfMemoryUsage,";
			columns += "NULL as nfStorageUsage,";
			columns += "NULL as nfLoadLevelAverage,";
			columns += "NULL as nfLoadAvgInAoi,";
			columns += String.format(columnFormat,"nfLoadLevelpeak");
		}
        return columns;
    }

	public static List<NfLoadLevelInformation> setNfloadNonIncludedInfoNull(List<NfLoadLevelInformation> nfloadlevels, List<AnalyticsSubset> listOfAnaSubsets){
		if(!ParserUtil.safeParseContains(listOfAnaSubsets,new AnalyticsSubset().anaSubset(AnalyticsSubsetEnum.NF_RESOURCE_USAGE))){
			for(int i=0;i<nfloadlevels.size();i++){
				nfloadlevels.get(i).nfCpuUsage(null).nfMemoryUsage(null).nfStorageUsage(null);
			}
		}
		if(!ParserUtil.safeParseContains(listOfAnaSubsets,new AnalyticsSubset().anaSubset(AnalyticsSubsetEnum.NF_LOAD))){
			for(int i=0;i<nfloadlevels.size();i++){
				nfloadlevels.get(i).nfLoadLevelAverage(null);
			}
		}
		if(!ParserUtil.safeParseContains(listOfAnaSubsets,new AnalyticsSubset().anaSubset(AnalyticsSubsetEnum.NF_LOAD_AVG_IN_AOI))){
			for(int i=0;i<nfloadlevels.size();i++){
				nfloadlevels.get(i).nfLoadAvgInAoi(null);
			}
		}
		if(!ParserUtil.safeParseContains(listOfAnaSubsets,new AnalyticsSubset().anaSubset(AnalyticsSubsetEnum.NF_PEAK_LOAD))){
			for(int i=0;i<nfloadlevels.size();i++){
			nfloadlevels.get(i).nfLoadLevelpeak(null);
		}
		}
		if(!ParserUtil.safeParseContains(listOfAnaSubsets,new AnalyticsSubset().anaSubset(AnalyticsSubsetEnum.NF_STATUS))){
			for(int i=0;i<nfloadlevels.size();i++){
				nfloadlevels.get(i).nfStatus(null);
			}
		}
		return nfloadlevels;
	}
}
