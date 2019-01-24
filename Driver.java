import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner dataFile = new Scanner(new File("companylist.csv"));
        Scanner scanUser = new Scanner(System.in);
        HashMap<String, company> myMap = new HashMap<>();
        String nick = dataFile.nextLine(); // skip first line
        while (dataFile.hasNext()) {
            company company = new company();
            String entry = dataFile.nextLine();
            String[] array = entry.split("\",\"");
            array[0] = array[0].substring(1);
//             "Symbol","Name","LastSale","MarketCap","ADR TSO","IPOyear","Sector","Industry","Summary Quote",
            if (!array[2].contains("n/a")) {
                company.setSymbol(array[0]);
                company.setName(array[1]);
                company.setLastSale(Double.parseDouble(array[2]));
                company.setSector(array[6]);
                company.setIndustry(array[7]);
                company.setSummaryQoute(array[8]);
                myMap.put(company.getSymbol(), company);
            }

           // company.setSymbol(array[0]);
           // company.setName(array[1]);
           // company.setSector(array[6]);
           // company.setIndustry(array[7]);
           // company.setSummaryQoute(array[8]);
           //
           // if (!array[2].contains("n/a")){
           //   company.setLastSale(Double.parseDouble(array[2]));
           // } else{
           //      company.setLastSale(-1);}
           // if (!array[3].contains("n/a"))
           //     company.setMarketCap(Double.parseDouble(array[3]));
           // else
           //     company.setMarketCap(-1);
           //
           // if (!array[4].contains("n/a"))
           //     company.setADR(Double.parseDouble(array[4]));
           // else
           //     company.setADR(-1);
           // if (!array[5].contains("n/a"))
           //     company.setADR(Double.parseDouble(array[5]));
           // else
           //     company.setADR(-1);
           //
           //  myMap.put(company.getSymbol(), company);
        } // end while


        // menu try
        int selector;
        char quit = 'n';
        String input;

        while (quit != 'y') {
            System.out.println("Main menu enter a number\n\t1 - To enter a symbol" +
                    "\n\t2 - Get cheapest stock\n\t3 - Get most expensive stock" +
                    "\n\t4 - Select a sector\n\t5 - Select an industry");
            selector = scanUser.nextInt();
            switch (selector) {
                case 1:
                    String userSymbol = getSymbol();
                    System.out.println(myMap.get(userSymbol));
                    break;
                case 2:
                    //cheapest stock
                    company outputS = null;
                    double smallest = 1000;
                    for (company c : myMap.values()) {
                        if (c.getLastSale() < smallest) {
                            smallest = c.getLastSale();
                            outputS = c;
                        }
                    }
                    System.out.println("Cheapest Stock is $" + smallest + "\nThe company is: " + outputS);
                    break;
                case 3:
                    //expensive stock
                    company outputE = null;
                    double biggest = 0;
                    for (company c : myMap.values()) {
                        if (c.getLastSale() > biggest) {
                            biggest = c.getLastSale();
                            outputE = c;
                        }
                    }
                    System.out.println("Most Expensive Stock is $" + biggest + "\nThe company is: " + outputE);
                    break;
                case 4:
                    // code here. user enters a sector. printout mean and median price
                    ArrayList<Double> sectorList = new ArrayList<>();
                    String sector = getSector();
                    double sum = 0.0;
                    int count = 0;
                    for (company comp : myMap.values()) {
                        if (comp.getSector().contains(sector)) { // use contains or equals?
                            sectorList.add(comp.getLastSale()); // add all prices for that sector into array
                            sum += comp.getLastSale();
                            count++;
                        }
                    }
                    double mean = sum / count;
                    int median = sectorList.size() / 2;
                    System.out.println(sector + ":\t Average price: " + mean + "\tMedian price: "
                            + median);
                    break;
                case 5:
                    //code here. user enters an industry. printout mean and median price
                    ArrayList<Double> industryList = new ArrayList<>();
                    String industry = getIndustry();
                    double sum2 = 0.0;
                    int count2 = 0;
                    for (company comp : myMap.values()) {
                        if (comp.getIndustry().contains(industry)) { // use contains or equals?
                            industryList.add(comp.getLastSale()); // add all prices for that industry into array
                            sum2 += comp.getLastSale();
                            count2++;
                        }
                    }
                    double mean2 = sum2 / count2;
                    int median2 = industryList.size() / 2;
                    System.out.println(industry + ":\t Average price: " + mean2 + "\tMedian price: "
                            + median2);
                    break;
                default: // do I need a default.
                    System.out.println("not an option");
            } // end switch


            System.out.println("Would you like to quit y/n?   ");
            input = scanUser.next().toLowerCase();
            quit = input.charAt(0);
        }// end while selector
    } // end main

    private static String getSymbol() {
        Scanner nScan = new Scanner(System.in);
        System.out.println("Enter a symbol");
        return nScan.nextLine();
    }

    private static String getSector() {
        Scanner nScan = new Scanner(System.in);
        System.out.println("Enter a sector");
        return nScan.nextLine();
    }

    private static String getIndustry() {
        Scanner nScan = new Scanner(System.in);
        System.out.println("Enter an Industry");
        return nScan.nextLine();
    }
}// end class
