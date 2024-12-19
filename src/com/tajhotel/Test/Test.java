package com.tajhotel.Test;
import java.util.Scanner;

import com.tajhotel.controller.ControllerImpl;
import com.tajhotel.controller.IController;


public class Test {

	public static void main(String[] args) {

		Test.start();
	}
	public static void start() {
		System.out.println("**********************Welcome To Tajhotel***************************");
		IController controller = new ControllerImpl();
		while(true) {
			System.out.println("************************************************************");
			System.out.println("1. Insert customer Record \n2.Update customer Record \n3. Delete customer Record \n4. view customer Record \n5.Exit ");
			System.out.println("******************************************************************");
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter your Choice :: ");
			int x=sc.nextInt();
			
			switch(x) {
			case 1: controller.insert();
			        break;
			case 2: controller.update();
			        break;
			case 3: controller.delete();
			        break;
			case 4: controller.select();
			        break;
			case 5: System.out.println("Thank you for using our application");
			        System.exit(0);
			        break;
			    default:System.out.println("Invalid input Please Try Again !!!");
			}
			System.out.println("*****************************************************\n");
		}
		}
	}

