/**
 * 
 */
package com.ibm.basics.collection;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * @author 004ISA744
 *
 */
public class ModifiedAscDescColumnJoin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<TableRow> yourTable = new ArrayList<>();

		yourTable.add(new TableRow(1, 5, 101));
		yourTable.add(new TableRow(2, 4, 102));
		yourTable.add(new TableRow(3, 3, 103));
		yourTable.add(new TableRow(4, 2, 104));
		yourTable.add(new TableRow(5, 1, 105));
		yourTable.add(new TableRow(6, 6, 106));
		yourTable.add(new TableRow(7, 7, 107));
		yourTable.add(new TableRow(8, 8, 108));

//		yourTable.add(new TableRow(3, 6, 101));
//		yourTable.add(new TableRow(1, 4, 102));
//		yourTable.add(new TableRow(2, 5, 103));

		List<TableRow> clonedList = yourTable.stream().map(TableRow::clone).collect(Collectors.toList());

		// Sort the first column in ascending order
		List<TableRow> sortedFirstCol = clonedList.stream().sorted(Comparator.comparingInt(TableRow::getFirst_col))
				.collect(Collectors.toList());

		// Sort the second column in descending order
		List<TableRow> sortedSecondCol = clonedList.stream()
				.sorted(Comparator.comparingInt(TableRow::getSecond_col).reversed()).collect(Collectors.toList());

		// Merge the sorted lists back together
		List<TableRow> mergedList = new ArrayList<>();
		for (int i = 0; i < yourTable.size(); i++) {
			TableRow mergedRow = new TableRow(sortedFirstCol.get(i).getFirst_col(),
					sortedSecondCol.get(i).getSecond_col());
			mergedList.add(mergedRow);
		}

		mergedList.forEach(row -> System.out
				.println(row.getFirst_col() + ", " + row.getSecond_col()));
	}

}
