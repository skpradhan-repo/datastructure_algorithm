/**
 * 
 */
package com.ibm.basics.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 004ISA744
 *
 */
public class ExtractJsonObjFromListOfString {

	public static void main(String[] args) {
		// Sample list of JSON strings, each representing a JSON object
		List<String> jsonStringList = new ArrayList<>();
		jsonStringList.add("{\"RatePlanCode\":\"\",\"TemplateReferenceCode\":\"null\"}");
		jsonStringList.add("{\"RatePlanCode\":\"\",\"TemplateReferenceCode\":\"]\"}");
		jsonStringList.add("{\"RatePlanCode\":\"\",\"TemplateReferenceCode\":\"\"}");

		// Extract rate plan codes and template reference codes from the list of JSON
		// strings using regex
		List<String> ratePlanCodes = new ArrayList<>();
		List<String> templateReferenceCodes = new ArrayList<>();

		// Define the regex pattern to match RatePlanCode and TemplateReferenceCode
		Pattern pattern = Pattern.compile("\"RatePlanCode\":\"(.*?)\",\"TemplateReferenceCode\":\"(.*?)\"");

		for (String jsonString : jsonStringList) {
			Matcher matcher = pattern.matcher(jsonString);
			if (matcher.find()) {
				String ratePlanCode = matcher.group(1);
				String templateReferenceCode = matcher.group(2);
				ratePlanCodes.add(ratePlanCode);
				templateReferenceCodes.add(templateReferenceCode);
			}
		}

		// Print the extracted rate plan codes and template reference codes
		System.out.println("Rate Plan Codes: " + ratePlanCodes);
		System.out.println("Template Reference Codes: " + templateReferenceCodes);
	}
}
