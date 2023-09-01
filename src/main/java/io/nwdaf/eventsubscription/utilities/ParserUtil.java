package io.nwdaf.eventsubscription.utilities;

import java.time.OffsetDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectWriter;

import io.nwdaf.eventsubscription.model.EventSubscription;
import io.nwdaf.eventsubscription.model.GADShape;
import io.nwdaf.eventsubscription.model.LocationArea;
import io.nwdaf.eventsubscription.model.SupportedGADShapes;
import io.nwdaf.eventsubscription.model.SupportedGADShapes.SupportedGADShapesEnum;

public class ParserUtil {
    public static Integer safeParseInteger(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return null;
        }
    }
    public static Float safeParseFloat(String str) {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e) {
            return null;
        }
        catch (NullPointerException e) {
            return null;
        }
    }
    public static Double safeParseDouble(String str) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return null;
        }
        catch (NullPointerException e) {
            return null;
        }
    }
    public static OffsetDateTime safeParseOffsetDateTime(String str) {
        try {
            return OffsetDateTime.parse(str);
        } catch (DateTimeParseException e) {
            return null;
        }
        catch (NullPointerException e) {
            return null;
        }
    }
    public static UUID safeParseUUID(String str) {
        try {
            return UUID.fromString(str);
        } catch (IllegalArgumentException e) {
            return null;
        } catch(NullPointerException e){
            return null;
        }
    }
    public static Boolean safeParseBoolean(String value) {
        if (value == null) {
            return null;
        }

        return Boolean.parseBoolean(value);
    }
    public static String safeParseString(Object o) {
        if (o == null) {
            return null;
        }

        return o.toString();
    }
    public static List<String> safeParseListString(List<Object> l){
        List<String> res = new ArrayList<>();
        for(int i=0;i<l.size();i++){
            res.add(safeParseString(l.get(i)));
        }
        return res;
    }
    public static Boolean safeParseEquals(String value,String comparisonValue) {
        if (value == null) {
            return false;
        }
        try{
            return value.equalsIgnoreCase(comparisonValue);
        }catch(Exception e){
            return false;
        }
    }
    public static Long safeParseLong(String str) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            return null;
        }
    }
    public static <T> List<String> parseListToFilterList (List<T> list,String name){
		List<String> filterList = new ArrayList<>();
		for(int i=0;i<list.size();i++){
            if(list.get(i)==null || list.get(i).getClass()==null){
                continue;
            }
			if(list.get(i).getClass().equals(Integer.class)){
				filterList.add("{\""+name+"\":"+list.get(i)+"}");
			}
			else{
				filterList.add("{\""+name+"\":\""+list.get(i)+"\"}");
			}
		}
		return filterList;
	}

	public static String parseQuerryFilter(List<String> filterList){
		String res = "";
        if(filterList==null || filterList.size()==0){
            return null;
        }
		for(int i=0;i<filterList.size();i++){
			res += "data @> cast('"+filterList.get(i)+"' as jsonb)";
			if(i!=filterList.size()-1){
				res += " or ";
			}
		}

		return res;
	}

	public static String parseQuerryFilterContains(List<String> filterList, String subProperty){
		String res = "";
        if(filterList==null || filterList.size()==0){
            return null;
        }
		for(int i=0;i<filterList.size();i++){
			res += "data->'"+subProperty+"' @> '\""+filterList.get(i)+"\"'";
			if(i!=filterList.size()-1){
				res += " or ";
			}
		}

		return res;
	}

    // checks if input string is neither null nor empty string ("")
    public static Boolean checkNotNullNorEmptyString(String in){
        if(in!=null && !in.equals("")){
            return true;
        }
        return false;
    }
    // converts empty string to null
    public static String convertEmptyStringToNull(String in){
        if(in.equals("")){
            return null;
        }
        else{
            return in;
        }
    }

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

    // converts the hex bits to a list of integers, each representing the presence of a feature, using bit masking
	public static List<Integer> convertFeaturesToList(String features){
		int in;
		try{
		in = Integer.parseInt(features, 16);
		}catch(NumberFormatException e){
			return new ArrayList<>();
		}
        List<Integer> res = new ArrayList<>();

        for (int i = 1; i <= 24; i++) {
            int featureBit = 1 << (i - 1);
            if ((in & featureBit) != 0) {
                res.add(i);
            }
        }

        return res;
	}
    // remove edge cases from list of filters
    public static List<String> parseObjectListToFilterList(List<String> list) {
        List<String> filterList = new ArrayList<>();
        if(list==null){
            return null;
        }
		for(int i=0;i<list.size();i++){
            if(list.get(i)==null || list.get(i).getClass()==null || list.get(i)=="" || list.get(i)=="{}"){
                continue;
            }
			else{
				filterList.add(list.get(i));
			}
		}
		return filterList;
    }
    // converts a list of objects to a list of jsons in string format using objectWriter & jsonObject
    public static <T> List<String> convertObjectWriterList(List<T> list, ObjectWriter ow){
        List<String> res = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            try {
                res.add(ow.writeValueAsString(list.get(i)));
            } catch (JsonProcessingException e) {
                continue;
            }
        }
        return res;
    }
}