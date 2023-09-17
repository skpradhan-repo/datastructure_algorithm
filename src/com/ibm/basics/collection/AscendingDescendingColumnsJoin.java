/**
 * 
 */
package com.ibm.basics.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 004ISA744
 *
 */
public class AscendingDescendingColumnsJoin {
	public static void main(String[] args) {
		List<TableRow> yourTable = new ArrayList<>(); // Replace with your table data

		yourTable.add(new TableRow(1, 5, 101));
        yourTable.add(new TableRow(2, 4, 102));
        yourTable.add(new TableRow(3, 3, 103));
        yourTable.add(new TableRow(4, 2, 104));
        yourTable.add(new TableRow(5, 1, 105));
        yourTable.add(new TableRow(6, 6, 106));
        yourTable.add(new TableRow(7, 7, 107));
		yourTable.add(new TableRow(8, 8, 108));


		// Sort and assign row numbers
		List<TableRow> cte1 = yourTable.stream().sorted(Comparator.comparingInt(TableRow::getFirst_col))
				.collect(Collectors.toList());

		List<TableRow> cte2 = yourTable.stream().sorted(Comparator.comparingInt(TableRow::getSecond_col).reversed())
				.collect(Collectors.toList());

		// Perform the join based on some_unique_identifier
		List<TableRow> result = cte1.stream().flatMap(row1 -> cte2.stream()
				.filter(row2 -> row1.getSome_unique_identifier() == row2.getSome_unique_identifier()).map(row2 -> {
					// You can combine row1 and row2 here if needed
					// For example, create a new object or collect the fields you want
					return row1; // Modify this part as needed
				})).collect(Collectors.toList());
		
		result.forEach(System.out::println);

		result.forEach(row -> {
		    System.out.println("First_col: " + row.getFirst_col() +
		            ", Second_col: " + row.getSecond_col() +
		            ", Some_unique_identifier: " + row.getSome_unique_identifier());
		});
	}
}
