package com.ibm.basics.array;

import java.util.HashSet;
import java.util.Set;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		Set<Employe> set = new HashSet<>();
		Test test = new Test();
		set.add(test.new Employe("John"));
		set.add(test.new Employe("John"));
		Thread.sleep(10000);
		System.gc();
		System.out.println(set.size());
	}
	
	@Override
	public void finalize() throws Throwable {
		// TODO Auto-generated method stub
//		super.finalize();
		System.out.println("finalaize executed");
	}
	
	 class Employe{
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Employe(String name) {
			super();
			this.name = name;
		}
		
	}

}
