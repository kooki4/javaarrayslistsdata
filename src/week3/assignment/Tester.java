package week3.assignment;

import static org.junit.Assert.assertEquals;

/**
 * Assignment: Reading Web Logs / Unique IPs - Tester
 * 
 * @version June 22, 2016
 */

import java.util.*;

import org.junit.Test;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
    	 LogAnalyzer la = new LogAnalyzer();
    	 la.readFile("./weblog/short-test_log");
    	 la.printAll();
    }
    
    public void testUniqIP() {
		LogAnalyzer la = new LogAnalyzer();
		la.readFile("./weblog/short-test_log");
		int uniqueIPs = la.countUniqueIPs();
		System.out.println("There are " + uniqueIPs + " IPs");
	}
    
    public void testprintAllHigherThanNum() {
    	int num = 200;
    	LogAnalyzer la = new LogAnalyzer();
   	 	la.readFile("./weblog/short-test_log");
   	 	la.printAllHigherThanNum(num);
	}
    
	public void testuniqueIPVisitsOnDay() {
		LogAnalyzer la = new LogAnalyzer();
		la.readFile("./weblog/weblog-short_log");
		ArrayList IPa = la.uniqueIPVisitsOnDay("Sep 14");
		ArrayList IPb = la.uniqueIPVisitsOnDay("Sep 30");
		System.out.println(IPa.toString());
		System.out.println(IPb.toString());
	}
	
	public void testcountUniqueIPsInRange() {
		LogAnalyzer la = new LogAnalyzer();
		la.readFile("./weblog/short-test_log");
		int countIPs = la.countUniqueIPsInRange(200,299);
		System.out.println("There are " + countIPs + " unique IP addresses that have a status code from 200 to 299");
	    countIPs = la.countUniqueIPsInRange(300,399);
		System.out.println("There are " + countIPs + " unique IP addresses that have a status code from 300 to 399");
	}
	
	public void testcountVisitsPerIP() {
		LogAnalyzer la = new LogAnalyzer();
		la.readFile("./weblog/weblog-short_log");
		System.out.println(la.countVisitsPerIP());
	}
	
	public void testmostNumberVisitsByIP() {
		LogAnalyzer la = new LogAnalyzer();
		la.readFile("./weblog/weblog3-short_log");
		System.out.println(la.mostNumberVisitsByIP(la.countVisitsPerIP()));
	}
	
	public void testiPsMostVisits() {
		LogAnalyzer la = new LogAnalyzer();
		la.readFile("./weblog/weblog3-short_log");
		ArrayList<String> list = la.iPsMostVisits(la.countVisitsPerIP());
		for (int i=0; i< list.size();i++) 
			System.out.print(list.get(i) + " ");
	}
}
