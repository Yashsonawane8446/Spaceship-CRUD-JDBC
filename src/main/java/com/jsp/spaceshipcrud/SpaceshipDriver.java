package com.jsp.spaceshipcrud;

import java.util.Scanner;

public class SpaceshipDriver {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		boolean flag = true;
		while (flag) {

			System.out.println("\n1.Insert\n2.Update\n3.Delete\n4.Read\n5.Exit");

			System.out.println("Enter your choice:");
			int choice = sc.nextInt();

			switch (choice) {
			case 1: {
				SpaceshipRepo.insertQuery();
				System.out.println("==========Data inserted==========");
			}

				break;
			case 2: {
				SpaceshipRepo.updateQuery();
				System.out.println("==========Data Updated==========");
			}

				break;
			case 3: {
				SpaceshipRepo.deleteQuery();
				System.out.println("==========Data Deleted==========");
			}

				break;
			case 4: {
				SpaceshipRepo.readQuery();
				System.out.println("==========Data Read==========");
			}

				break;
			case 5: {
				System.out.println("Do you want to exit?1.yes\n2.no");
				int a = sc.nextInt();
				if (a == 1) {
					flag = false;
					System.out.println("Thank You...!");
				} else
					continue;
			}

				break;

			default:{ System.out.println("Invalid choice Enter");
			
			}
			break;
			}
				
			}
		}
	}


