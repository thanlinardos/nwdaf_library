package io.nwdaf.eventsubscription.utilities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectWriter;

public class ConvertUtil {
    // converts empty string to null
    public static String convertEmptyStringToNull(String in){
        if(in == null){
            return null;
        }
        if(in.equals("")){
            return null;
        }
        else{
            return in;
        }
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
    // converts a list of objects to a list of jsons in string format using objectWriter & jsonObject
    public static <T> List<String> convertObjectWriterList(List<T> list, ObjectWriter ow){
        List<String> res = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            try {
                res.add(ow.writeValueAsString(list.get(i)));
            } catch (JsonProcessingException e) {
                System.out.println("jsonprocessing error!!");
                continue;
            }
        }
        // System.out.println("object list: "+res);
        return res;
    }
}
