// Java Program to Illustrate Inner class can be
	// declared within a method of outer class
package com.training.org;
	// Class 1
	// Outer class
public class InnerDeclaredOuterClass {
	
		// Method inside outer class
		void outerMethod() {

			// Print statement
			System.out.println("inside outerMethod");

			// Class 2
			// Inner class
			// It is local to outerMethod()
			class Inner {

				// Method defined inside inner class
				void innerMethod() {

					// Print statement whenever inner class is
					// called
					System.out.println("inside innerMethod");
				}
			}

			// Creating object of inner class
			Inner y = new Inner();

			// Calling over method defined inside it
			y.innerMethod();
		}
	}

