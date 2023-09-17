/**
 * 
 */
package com.ibm.basics.intv;

/**
 * @author 004ISA744
 *
 */
public class Test1 {

	/**
	 * @param args
	 * @throws CloneNotSupportedException 
	 */
	public static void main(String[] args) throws CloneNotSupportedException {
		int arr[] = {0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
		
		int start = 0;
		int end = arr.length-1;
		
		Thread thread = new Thread(() -> System.out.println("Hello"));
		thread.start();
		
		while(start < end) {
			if (arr[start] == 1 && arr[end] ==0) {
				swap(arr, start, end);
				start ++;
				end --;
			}else if(arr[start] == 0) {
				start ++;
			}else if(arr[end]  == 1 ) {
				end --;
			}
		}
		
		Employee e1 = new Employee(1001, "Robin", "BLR", 35, Gender.MALE, 100000);
		Employee clone = (Employee) e1.clone();
	}

	private static void swap(int[] arr, int start, int end) {
		int temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
	}

}
