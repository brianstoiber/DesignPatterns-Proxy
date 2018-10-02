package main;

/**
 * replicates functionality of nslookup and dnsdig for communication with DNS
 * servers for domain mapping, the router looks for IPs in routing table, if
 * found forwards request, if not, forwards to external DNS server
 */
public interface DomainServer {

	public String dnsDig(String input);
}
