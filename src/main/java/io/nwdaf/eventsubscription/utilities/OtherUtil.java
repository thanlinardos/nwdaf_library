package io.nwdaf.eventsubscription.utilities;

import java.util.List;

import io.nwdaf.eventsubscription.model.AnalyticsSubset;
import io.nwdaf.eventsubscription.model.NfLoadLevelInformation;
import io.nwdaf.eventsubscription.model.SupportedGADShapes;
import io.nwdaf.eventsubscription.model.SupportedGADShapes.SupportedGADShapesEnum;
import io.nwdaf.eventsubscription.model.AnalyticsSubset.AnalyticsSubsetEnum;
import io.nwdaf.eventsubscription.model.EventSubscription;
import io.nwdaf.eventsubscription.model.GADShape;
import io.nwdaf.eventsubscription.model.LocationArea;

public class OtherUtil {
	// set the shape attribute for each geographicArea 
	// because of polymoprhic inheritance bug when jackson is deserialising the json
	public static EventSubscription setShapes(EventSubscription e){
		if(e.getExptUeBehav()!=null){
			if(e.getExptUeBehav().getExpectedUmts()!=null){
				for(int j=0;j<e.getExptUeBehav().getExpectedUmts().size();j++){
					LocationArea area = e.getExptUeBehav().getExpectedUmts().get(j);
					if(area.getGeographicAreas()!=null){
						for(int k=0;k<area.getGeographicAreas().size();k++){
    						String shapeType = area.getGeographicAreas().get(k).getType();
							if(shapeType.equals("Point")){
								((GADShape)area.getGeographicAreas().get(k)).setShape(new SupportedGADShapes().supportedGADShapes(SupportedGADShapesEnum.Point));
							}
							else if(shapeType.equals("PointAltitude")){
								((GADShape)area.getGeographicAreas().get(k)).setShape(new SupportedGADShapes().supportedGADShapes(SupportedGADShapesEnum.PointAltitude));
							}
							else if(shapeType.equals("PointAltitudeUncertainty")){
								((GADShape)area.getGeographicAreas().get(k)).setShape(new SupportedGADShapes().supportedGADShapes(SupportedGADShapesEnum.PointAltitudeUncertainty));
							}
							else if(shapeType.equals("PointUncertaintyCircle")){
								((GADShape)area.getGeographicAreas().get(k)).setShape(new SupportedGADShapes().supportedGADShapes(SupportedGADShapesEnum.PointUncertaintyCircle));
							}
							else if(shapeType.equals("PointUncertaintyEllipse")){
								((GADShape)area.getGeographicAreas().get(k)).setShape(new SupportedGADShapes().supportedGADShapes(SupportedGADShapesEnum.PointUncertaintyEllipse));
							}
							else if(shapeType.equals("Polygon")){
								((GADShape)area.getGeographicAreas().get(k)).setShape(new SupportedGADShapes().supportedGADShapes(SupportedGADShapesEnum.Polygon));
							}
							else if(shapeType.equals("EllipsoidArc")){
								((GADShape)area.getGeographicAreas().get(k)).setShape(new SupportedGADShapes().supportedGADShapes(SupportedGADShapesEnum.EllipsoidArc));
							}
						}
					}
				}
			}
		}
		return e;	
	}
	
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
		if(listOfAnaSubsets==null || listOfAnaSubsets.size() == 0){
			return nfloadlevels;
		}
		boolean cont = false;
		for(int i=0;i<listOfAnaSubsets.size();i++){
			if(listOfAnaSubsets.get(i).getAnaSubset()!=null){
				cont = true;
			}
		}
		if(!cont){
			return nfloadlevels;
		}
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
