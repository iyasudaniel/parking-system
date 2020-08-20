package com.mycompany.duparking;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * This program creates accepts users/customers inputs and call the appropriate
 * method to access the get customer full name, address, parking lot choice,
 * carplate number, depending on the selection of the service as hourly or
 * monthly the system prints a Parking Permit
 *
 *
 *
 * @author Iyasu Geleta
 */
public class Main {

    public static void main(String[] args) {

        while (true) {
            String header = "Welcome to the University of Denver Parking System";
            formattedHeader(header);
            System.out.println(header);
            formattedHeader(header);
            System.out.println();
            System.out.println("Press 1 if you are a Customer");
            System.out.println();
            System.out.println("Press 2 if you are a Permit Manager");
            System.out.println();
            System.out.println("Press 3 if you are a Transaction Manager");
            System.out.println();
            System.out.println("Press 0 if you want to quit");
            System.out.println();
            while (true) {
                //creates scanner for user to input data
                Scanner scanner = new Scanner(System.in);
                char ch = scanner.next().charAt(0);

                switch (ch) {

                    case '0':
                        System.out.println("Quiting....\n");
                        System.exit(0);
                    case '1':
                        while (true) {
                            System.out.println("Enter N if you are using the system for the First time.");
                            System.out.println("Enter Q to quit.");
                            //get input from user

                            //creates scanner for user to input data
                            Scanner scannerCustomer = new Scanner(System.in);
                            char chCustomer = scannerCustomer.next().charAt(0);
                            CustomerData customerData = null;
                            PermitManager pm = new PermitManager();
                            TransactionManager tm = new TransactionManager();

                            switch (chCustomer) {
                                case 'q':
                                case 'Q':
                                    System.out.println("Quiting....\n");
                                    break;
                                case 'n':
                                case 'N':
                                    customerData = getData();
                                    ParkingPermit parkingPermit = pm.register(customerData.car);
                                    pm.authorizePermit(customerData.getCar(), customerData.getCustomer());
                                    Date date = new Date();
                                    ParkingTransaction pt = new ParkingTransaction(date, parkingPermit, searchParkingLotObject(customerData.getCustomer().getSelectioninInt()));

                                    pt.printTransaction();
                                    tm.park(date, parkingPermit, searchParkingLotObject(customerData.getCustomer().getSelectioninInt()));

                                    break;
                                default:
                                    System.out.println("Please enter 'N' or 'Q' \n");
                                    break;
                            }
                            break;

                        }
                        break;
                    case '2':
                        while (true) {
                            System.out.println("Press 1 to authorize permit");
                            System.out.println("Press 2 to list all authorized Permits");
                            System.out.println("Press 0 to quit from the system");
                            System.out.println("Quiting....\n");
                            while (true) {
//                               creates scanner for user to input data
                                Scanner scannerPermitManager = new Scanner(System.in);
                                char chPM = scannerPermitManager.next().charAt(0);
                                PermitManager pm = new PermitManager();
                                switch (chPM) {
                                    case '0':
                                        System.out.println("Quiting....\n");
                                        System.exit(0);
                                    case '1':

                                        if (pm.getPermits().size() == 0) {
                                            System.out.println("No Customer has a request for service");
                                            System.exit(0);
                                        } else {
                                            System.out.println("BASED UP ON Arrival or Evaluation it would be authorized ");
                                            System.out.println("For now ,All are authorized");
                                            break;
                                        }

                                    case '2':
                                        pm.listall();
                                        break;
                                    default:
                                        System.out.println("Please enter 1 or 2 or '0' \n");
                                        break;
                                }
                                break;
                            }
                            break;
                        }
                        break;
                    case '3':

                        while (true) {
                            System.out.println("Press 1 to see all transactions");
                            System.out.println("Press 2 to search by permit id the amount of money for to be paid");
                            System.out.println("Press 3 to search by customer the amount of money for to be paid");
                            System.out.println("Press 0 to quit from the system");

                            while (true) {
//                               creates scanner for user to input data
                                Scanner scannerTransactionManager = new Scanner(System.in);
                                char chTM = scannerTransactionManager.next().charAt(0);
                                TransactionManager tm = new TransactionManager();
                                switch (chTM) {
                                    case '0':
                                        System.out.println("Quiting....\n");
                                        System.exit(0);
                                    case '1':

                                        if (tm.getTransactions().size() == 0) {
                                            System.out.println("No Customer has  a request for service");
                                            System.exit(0);
                                        } else {
                                            tm.listall();
                                            break;
                                        }

                                    case '2':
                                        if (tm.getTransactions().size() == 0) {
                                            System.out.println("There is no transaction");
                                            System.exit(0);
                                        } else {

                                            System.out.println("Enter the parking permit Id: ");
                                            Scanner scannerId = new Scanner(System.in);

                                            String chId = scannerId.nextLine();
                                            ParkingPermit parkingPermit = getParkingPermit(chId, tm.getTransactions());
                                            if (parkingPermit == null) {
                                                System.out.println("No parking permit with Id " + chId + " exist.");
                                                System.exit(0);
                                            }
                                            Money chargeAmount = tm.getParkingCharges(parkingPermit);
                                            System.out.println(" Charged amount for parking permit is " + chargeAmount.toString());
                                            break;
                                        }
                                    case '3':
                                        if (tm.getTransactions().size() == 0) {
                                            System.out.println("There is no transaction");
                                            System.exit(0);
                                        } else {
                                            System.out.println("Enter the customer Name: ");
                                            Scanner scannerName = new Scanner(System.in);

                                            String chName = scannerName
                                                    .nextLine();
                                            Customer customer = getCustomer(chName, tm.getTransactions());
                                            if (customer == null) {
                                                System.out.println("No parking permit with customer name " + chName + " exist.");
                                                System.exit(0);
                                            }
                                            Money chargeAmount = tm.getParkingCharges(customer);
                                            System.out.println(" Charged amount for parking permit is " + chargeAmount.toString());
                                            break;
                                        }

                                    default:
                                        System.out.println("Please enter [1 - 3] or 'Q' \n");
                                        break;
                                }

                            }
                        }

                }
                break;
            }
        }

    } //end of psvm 

    public static void formattedHeader(String header) {
        for (int i = 0; i < header.length(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    private static CustomerData getData() {
        CustomerData cd = null;
        System.out.println("Please enter your Identification number(ID)");
        Scanner scnId = new Scanner(System.in);
        String id = scnId.nextLine();
        System.out.println("Please enter your First Name");
        Scanner scnFirstName = new Scanner(System.in);
        String firstName = scnFirstName.nextLine();
        System.out.println("Please enter your Last Name");
        Scanner scnLastName = new Scanner(System.in);
        String lastName = scnLastName.nextLine();
        System.out.println("Please enter your Phone Number");
        Scanner scnPhoneNumber = new Scanner(System.in);
        String phoneNumber = scnPhoneNumber.nextLine();
        System.out.println("Please enter your Street Address 1");
        Scanner scnstreetAddress1 = new Scanner(System.in);
        String streetAddress1 = scnstreetAddress1.nextLine();
        System.out.println("Please enter your City");
        Scanner scnCity = new Scanner(System.in);
        String city = scnCity.nextLine();
        System.out.println("Please enter your State");
        Scanner scnState = new Scanner(System.in);
        String state = scnState.nextLine();
        System.out.println("Please enter your Zip Code");
        Scanner scnZipcode = new Scanner(System.in);
        String zipcode = scnZipcode.nextLine();
        String message = "Enter Y/N if you have an additional information about your address "
                + "such as  apartment,\n suite or space number "
                + "(or any other designation not literally part of the physical address)";
        System.out.println(message);

        while (true) {
            Scanner scnadditionalinformation = new Scanner(System.in);
            char ch = scnadditionalinformation.next().charAt(0);
            Address address1 = null;
            if (ch == 'y' || ch == 'Y') {
                String streetaddress2 = getAdditionalData();
                address1 = new Address(streetAddress1, streetaddress2, city, state, zipcode);
            } else if (ch == 'n' || ch == 'N') {

                address1 = new Address(streetAddress1, city, state, zipcode);
            }
            System.out.println("Please enter your Car type as COMPACT or SUV");
            Scanner scnCarType = new Scanner(System.in);

            CarType type = null;
            String typeInput = scnCarType.nextLine();
            if (typeInput.equalsIgnoreCase(CarType.SUV.toString())) {
                type = CarType.SUV;
            } else if (typeInput.equalsIgnoreCase(CarType.COMPACT.toString())) {
                type = CarType.COMPACT;
            }
            System.out.println("Enter your License Plate number");
            Scanner scnLicensePlate = new Scanner(System.in);
            String plateNumber = scnLicensePlate.nextLine();
            System.out.println("List of Available Parking Lots");
            System.out.println("*******************************");
            ParkingOffice po = new ParkingOffice();
            po.displayParkings(po.LoadParkingLotsData());
            System.out.println("Enter parking lot  number you prefer  :");
            Scanner parkingLotScanner = new Scanner(System.in);
            int selection = parkingLotScanner.nextInt();

            String parkinglotSelection = assignParkingLot(selection, po);
            System.out.println("Do you want an hourly fee or monthly fee. ");
            System.out.println("H for Hourly base");
            System.out.println("M for Monthly base");
            Scanner scn_parkingmethod_choice = new Scanner(System.in);
            Customer customer2 = null;
            char confirm_parking_subscription = scn_parkingmethod_choice.next().charAt(0);
            if (confirm_parking_subscription == 'H' || confirm_parking_subscription == 'h') {

                System.out.println("How many hours do yo want to park");
                Scanner parkinghour = new Scanner(System.in);
                int hourSelection = parkinghour.nextInt();
                PermitType permtype = PermitType.DAILY;

                customer2 = new Customer(id, firstName, lastName, phoneNumber, address1, type, parkinglotSelection, hourSelection, permtype, selection);
            } else if (confirm_parking_subscription == 'M' || confirm_parking_subscription == 'm') {
                System.out.println("Please Input the Starting Date of th the parking Permit in year-month[01-12]-day format");
                Scanner scnsartDate = new Scanner(System.in);
                String startingDate = scnsartDate.nextLine();
                System.out.println("Please Input the date you want the  parking Permit to expire in Year-Month[01-12]-Day format");
                Scanner scnEndDate = new Scanner(System.in);
                String exprireDate = scnsartDate.nextLine();
                DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate d1 = LocalDate.parse(startingDate, df);
                LocalDate d2 = LocalDate.parse(exprireDate, df);
                Duration diff = Duration.between(d1.atStartOfDay(), d2.atStartOfDay());
                long diffDays = diff.toDays();
                System.out.println(diffDays);
                Date d2Date = convertToDateViaInstant(d2);
                PermitType permtype = PermitType.MONTHLY;
                customer2 = new Customer(id, firstName, lastName, phoneNumber, address1, type, parkinglotSelection, d2Date, diffDays, permtype, selection);
                System.out.println(customer2.getExpireDateSelection());
            } else {

            }

            System.out.println("Please Confirm the information you provide is accurate by pressing Y/N ");
            System.out.println("*************************************************************************");
            System.out.println("Full name: " + customer2.getCustomerName());
            System.out.println("Address: " + address1.getAddress());
            System.out.println("Car Type: " + customer2.getType());
            System.out.println("Parkinglot Selection: " + customer2.getParkinglotSelection());
            if (customer2.getPermType().equals(PermitType.DAILY)) {
                System.out.println("Parking Hour Selection: " + customer2.getParkinghour());
            } else {
                System.out.println("Number of days  Selection: " + customer2.getDiffDays());
            }
            Scanner scnconfirmation = new Scanner(System.in);
            char confirm_input = scnconfirmation.next().charAt(0);

            if (confirm_input == 'y' || confirm_input == 'Y') {
                System.out.println();
                System.out.println("Thank you for registering to the University of Denver Parking System");
                System.out.println("Your Permit will be prcessed by the Permit Manager");
                Car c = new Car(type, plateNumber, customer2);
                cd = new CustomerData(customer2, c);
                // po.register(customer2);
                break;
            } else {
                cd = getData();
            }

            break;
        }

        return cd;
    }


    private static String getAdditionalData() {
        System.out.println("Please enter your Steet Address 2");
        Scanner scnstreetAddress2 = new Scanner(System.in);
        String streetAddress2 = scnstreetAddress2.nextLine();
        return streetAddress2;
    }

    public static String assignParkingLot(int selection, ParkingOffice po) {
        String parkinglotSelection = "";
        switch (selection) {
            case 1:
                parkinglotSelection = po.LoadParkingLotsData().get(0).getName()
                        + "[" + "Address: " + po.LoadParkingLotsData().get(0).getAddress().getAddress() + "]";

                break;
            case 2:
                parkinglotSelection = po.LoadParkingLotsData().get(1).getName()
                        + "[" + "Address: " + po.LoadParkingLotsData().get(1).getAddress().getAddress() + "]";
                break;
            case 3:
                parkinglotSelection = po.LoadParkingLotsData().get(2).getName()
                        + "[" + "Address: " + po.LoadParkingLotsData().get(2).getAddress().getAddress() + "]";
                break;
            case 4:
                parkinglotSelection = po.LoadParkingLotsData().get(3).getName()
                        + "[" + "Address: " + po.LoadParkingLotsData().get(3).getAddress().getAddress() + "]";
                break;
            case 5:
                parkinglotSelection = po.LoadParkingLotsData().get(4).getName()
                        + "[" + "Address: " + po.LoadParkingLotsData().get(4).getAddress().getAddress() + "]";
                break;
            default:
                System.out.println("Please Enter the appropriate number");

        }
        return parkinglotSelection;
    }

    private static ParkingPermit getParkingPermit(String Id, List<ParkingTransaction> transactions) {
        for (ParkingTransaction parkingTransaction : transactions) {
            if (parkingTransaction.getPermit().getId().equalsIgnoreCase(Id)) {
                return parkingTransaction.getPermit();
            }
        }
        return null;
    }

    private static Customer getCustomer(String name, List<ParkingTransaction> transactions) {
        for (ParkingTransaction parkingTransaction : transactions) {
            if (parkingTransaction.getPermit().getCar().getOwner().getCustomerName().equalsIgnoreCase(name)) {
                return parkingTransaction.getPermit().getCar().getOwner();
            }
        }
        return null;
    }


    public static Date convertToDateViaInstant(LocalDate dateToConvert) {
        return java.util.Date.from(dateToConvert.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
    }

    public static ParkingLot searchParkingLotObject(int selection) {
        ParkingLot lot = null;
        switch (selection) {
            case 1:
                Address lotOneAddress = new Address("2308 E Evans Ave", "Denver", " CO", "80247");
                lot = new ParkingLot("301", "Evans Garage", lotOneAddress);
            case 2:
                Address lotTwoAddress = new Address("2201 S Gaylord St", "Denver", "CO", "80208");
                lot = new ParkingLot("304", "Sie International Relations Comples", lotTwoAddress);
            case 3:
                Address lotThreeAddress = new Address("2199 S University Blvd", "Denver", "CO", "80208");
                lot = new ParkingLot("304", "Mary Reed", lotThreeAddress);
            case 4:
                Address lotFourAddress = new Address("2197 S University Blvd", "Denver", "CO", "80208");
                lot = new ParkingLot("305", "University Hall", lotFourAddress);
            case 5:
                Address lotFiveAddress = new Address("2222 S High St", "Denver", "CO", "80210");
                lot = new ParkingLot("306", "Nelson Hall ", lotFiveAddress);

        }

        return lot;

    }

}//end of class

//
//    }
//
//
//  
//
//
//
//}
