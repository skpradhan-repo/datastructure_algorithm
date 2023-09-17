/**
 * 
 */
package com.ibm.basics.collection;

/**
 * @author 004ISA744
 *
 */
class TableRow implements Cloneable {
	private int first_col;
	private int second_col;
	private int some_unique_identifier;

	public TableRow(int first_col, int second_col, int some_unique_identifier) {
		this.first_col = first_col;
		this.second_col = second_col;
		this.some_unique_identifier = some_unique_identifier;
	}

	public TableRow(int first_col, int second_col) {
		super();
		this.first_col = first_col;
		this.second_col = second_col;
	}

	public int getFirst_col() {
		return first_col;
	}

	public void setFirst_col(int first_col) {
		this.first_col = first_col;
	}

	public int getSecond_col() {
		return second_col;
	}

	public void setSecond_col(int second_col) {
		this.second_col = second_col;
	}

	public int getSome_unique_identifier() {
		return some_unique_identifier;
	}

	public void setSome_unique_identifier(int some_unique_identifier) {
		this.some_unique_identifier = some_unique_identifier;
	}

	@Override
	public String toString() {
		return "TableRow [first_col=" + first_col + ", second_col=" + second_col + ", some_unique_identifier="
				+ some_unique_identifier + "]";
	}

	public TableRow clone() {
		return new TableRow(this.first_col, this.second_col);
	}

}