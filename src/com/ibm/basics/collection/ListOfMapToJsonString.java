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
public class ListOfMapToJsonString {

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

		// Convert the list of maps to a JSON string using Collectors.joining
		String jsonString = ratePlanList.stream()
				.map(map -> new StringBuilder("{\"RatePlanCode\":\"").append(map.get("RatePlanCode"))
						.append("\",\"TemplateReferenceCode\":\"").append(map.get("TemplateReferenceCode"))
						.append("\"}").toString())
				.collect(Collectors.joining(", ", "[", "]"));

		// Print the JSON string
		System.out.println(jsonString);

		// To retrieve the data and reconstruct the list of maps (if needed)
		// You can parse the JSON string back to a list of maps using a JSON library.
	}
}
