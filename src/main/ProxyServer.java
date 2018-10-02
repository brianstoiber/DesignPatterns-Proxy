package main;

import java.util.HashMap;
import java.util.Map;

/**
 * proxy server that simulates router and routing table, if the IP is in the
 * routing table, it returns that IP as a response to the request, if IP is
 * accessed for the first time, the request is forwarded to DNS server
 */

public class ProxyServer implements DomainServer {

	private static Map<String, String> routerTable;

	private DNSServer server;

	public ProxyServer() {
		routerTable = new HashMap<String, String>();
		server = new DNSServer();
	}

	@Override
	public String dnsDig(String input) {
		// if the domain had been accessed before, the IP should be the routing table
		String val = routerTable.get(input);
		if (val == null) {
			// fetch the IP from DNS server if IP is not there in the routing table
			System.out.println("IP for " + input + " NOT FOUND in routing table...");
			System.out.println("Forwarding request to external DNS server ");
			val = server.dnsDig(input);

			// cache the IP details in routing table for further use
			routerTable.put(input, val);
		} else {
			System.out.println("IP for " + input + " FOUND in routing table...");
		}
		return val;
	}

	public int getRoutingTableSize() {
		return routerTable.size();
	}

}