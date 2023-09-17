/**
 * 
 */
package com.ibm.basics.collection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class RatePlan {
    private String ratePlanCode;
    private String templateReferenceCode;

    

    public String getRatePlanCode() {
		return ratePlanCode;
	}



	public void setRatePlanCode(String ratePlanCode) {
		this.ratePlanCode = ratePlanCode;
	}



	public String getTemplateReferenceCode() {
		return templateReferenceCode;
	}



	public void setTemplateReferenceCode(String templateReferenceCode) {
		this.templateReferenceCode = templateReferenceCode;
	}



	@Override
    public String toString() {
        return "RatePlan{" +
                "ratePlanCode='" + ratePlanCode + '\'' +
                ", templateReferenceCode='" + templateReferenceCode + '\'' +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        List<String> jsonStringList = new ArrayList<>();
        jsonStringList.add("[{\"ratePlanCode\":\"BARRP\",\"templateReferenceCode\":\"BARRP\"}]");
        jsonStringList.add("[{\"ratePlanCode\":\"XYZRP\",\"templateReferenceCode\":\"XYZRP\"}]");

        List<RatePlan> ratePlans = extractRatePlans(jsonStringList);

        // Print the extracted RatePlan objects
        ratePlans.forEach(System.out::println);
    }

    public static List<RatePlan> extractRatePlans(List<String> jsonStringList) {
    	Pattern pattern = Pattern.compile("\"ratePlanCode\":\"(.*?)\",\"templateReferenceCode\":\"(.*?)\"");

        return jsonStringList.stream()
            .flatMap(jsonString -> {
                Matcher matcher = pattern.matcher(jsonString);
                List<RatePlan> ratePlans = new ArrayList<>();
                while (matcher.find()) {
                    RatePlan ratePlan = new RatePlan();
                    ratePlan.setRatePlanCode(matcher.group(1));
                    ratePlan.setTemplateReferenceCode(matcher.group(2));
                    ratePlans.add(ratePlan);
                }
                return ratePlans.stream();
            })
            .collect(Collectors.toList());
    }
}
