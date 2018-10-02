package main;

import java.util.HashMap;
import java.util.Map;

public class DNSServer implements DomainServer {

	private static Map<String, String> dnsLookupMap = new HashMap<>();

	// using static code block to populate map on application startup itself
	static {
		dnsLookupMap.put("google.com", "172.217.11.174");
		dnsLookupMap.put("microsoft.com", "191.239.213.197");
		dnsLookupMap.put("digg.com", "50.18.126.196");
		dnsLookupMap.put("ebay.com", "66.135.209.52");
		dnsLookupMap.put("office.com", "52.108.208.0");
		dnsLookupMap.put("amazon.com", "176.32.103.205");
		dnsLookupMap.put("imdb.com", "52.94.225.248");
		dnsLookupMap.put("facebook.com", "31.13.67.35");
		dnsLookupMap.put("paypal.com", "64.4.250.33");
		dnsLookupMap.put("wordpress.org", "198.143.164.252");
		dnsLookupMap.put("apple.com", "17.172.224.47");
		dnsLookupMap.put("adobe.com", "193.104.215.58");
		dnsLookupMap.put("flickr.com", "69.147.92.11");
		dnsLookupMap.put("github.com", "192.30.253.112");
		dnsLookupMap.put("mozilla.org", "63.245.208.195");
		dnsLookupMap.put("salesforce.com", "96.43.148.26");

	}

	@Override
	public String dnsDig(String input) {
		return dnsLookupMap.get(input);
	}

}