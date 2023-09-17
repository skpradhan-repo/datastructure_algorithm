/**
 * 
 */
package com.ibm.basics.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author 004ISA744
 *
 */
public class ListOfMapToListOfJsonString {

	public static void main(String[] args) {
		// Sample list of maps, where each map contains RatePlanCode and
		// TemplateReferenceCode
		List<Map<String, String>> ratePlanList = new ArrayList<>();

		Map<String, String> map1 = new HashMap<>();
		map1.put("RatePlanCode", "RP1");
		map1.put("TemplateReferenceCode", "TRC1");
		ratePlanList.add(map1);

		Map<String, String> map2 = new HashMap<>();
		map2.put("RatePlanCode", "RP2");
		map2.put("TemplateReferenceCode", "TRC2");
		ratePlanList.add(map2);

		// Convert the list of maps to a list of strings (each string is a JSON object)
		List<String> jsonStringList = ratePlanList
				.stream().map(map -> "{\"RatePlanCode\":\"" + map.get("RatePlanCode")
						+ "\",\"TemplateReferenceCode\":\"" + map.get("TemplateReferenceCode") + "\"}")
				.collect(Collectors.toList());

		// Print the list of JSON strings
		jsonStringList.forEach(System.out::println);

		// To retrieve the data and reconstruct the list of maps (if needed)
		// You can parse the JSON strings back to a list of maps using a JSON library.
	}
}
