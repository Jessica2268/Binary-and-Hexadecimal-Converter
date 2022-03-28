/*
——————————————————————————————————————————
Name: Jessica Ly
Converts decimal numbers, IP addresses,
and Mac addresses to Binary or Hexadecimal
using only recursion.
——————————————————————————————————————————
*/

import java.util.Scanner;
class BinaryandHexide {
    public static String decimal2Binary (int decimal){
        int num;
        String answer;
        if (decimal == 0){
            return "";
        }
        else {
            num = (decimal % 2);
            answer=decimal2Binary(decimal/2)+num;
            return answer;
        }
    }
    public static String decimal2Hexadecimal(int decimal){
        String letter = "";
        int num = decimal % 16;

        if (decimal == 0) {
            return "";
        } else {
            switch (num) {
                case 10:
                    letter = "A";
                    break;
                case 11:
                    letter = "B";
                    break;
                case 12:
                    letter = "C";
                    break;
                case 13:
                    letter = "D";
                    break;
                case 14:
                    letter = "E";
                    break;
                case 15:
                    letter = "F";
                    break;
                default:
                    letter = num + letter;
                    break;
            }
            return decimal2Hexadecimal((decimal / 16)) + letter;
        }
    }
    public static String convertIpAddress(String[] myArray,int index){
        if (index == myArray.length-1){
            return decimal2Binary(Integer.parseInt(myArray[0]));
        }
        else{
            return decimal2Binary(Integer.parseInt(myArray[index]))+ "." + convertIpAddress(myArray,index+1);
        }
    }
    public static String convertMacAddress(String[] myArray,int index){
        if (index == myArray.length-1){
            return decimal2Hexadecimal(Integer.parseInt(myArray[0]));
        }
        else{
            return decimal2Hexadecimal(Integer.parseInt(myArray[index]))+ ":" + convertMacAddress(myArray,index+1);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int choice;
        do{
            System.out.println("1-Convert Decimal Number to Binary Number");
            System.out.println("2-Convert Decimal Number to Hexadecimal Number");
            System.out.println("3-Convert Decimal IP Address to Binary IP Address");
            System.out.println("4-Convert Decimal Mac Address to Hexadecimal MAC Address");
            System.out.println("5-Exit");
            System.out.println("\nEnter choice:");
            choice = scan.nextInt();
            if (choice > 5){
                System.out.println("Error: Please enter valid input");
            }

            switch (choice){
                case 1:
                    System.out.println("Enter Decimal Integer: ");
                    int dec = scan.nextInt();
                    System.out.println("Decimal Number: "+dec);
                    System.out.println("Binary Number: "+decimal2Binary(dec));
                            break;
                case 2:
                    System.out.println("Enter Decimal Integer: ");
                    dec = scan.nextInt();
                    System.out.println("Decimal Number: "+dec);
                    System.out.println("Hexadecimal Number: "+decimal2Hexadecimal(dec));
                    break;
                case 3:
                    System.out.println("Enter Decimal IP Address (i.e. 192.168.35.10):");
                    scan.nextLine();
                    String ip = scan.nextLine();
                    System.out.println("Decimal IP Address: " + ip);
                    String[] myArray = ip.split("\\.");
                    System.out.println(convertIpAddress(myArray, 0));
                    break;
                case 4:
                    System.out.println("Enter Decimal Mac Address (i.e. 203:65:157:93:13:7):");
                    scan.nextLine();
                    ip = scan.nextLine();
                    String[] myArray2 = ip.split(":");
                    System.out.println("Decimal MAC Address: "+ip);
                    System.out.println("Hexadecimal MAC Address: "+convertMacAddress(myArray2,0));
                    break;
            }

        }while (choice != 5);

    }
}
