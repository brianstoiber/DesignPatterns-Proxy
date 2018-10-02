package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import main.DomainServer;
import main.ProxyServer;

public class DnsdigTest {

	private static DomainServer server;

	@BeforeClass
	public static void setUp() {
		server = new ProxyServer();
	}

	@AfterClass
	public static void tearDown() {
		server = null;
	}

	@Test
	public void testDnsDig() {
		assertEquals("176.32.103.205", server.dnsDig("amazon.com"));
		assertEquals("52.94.225.248", server.dnsDig("imdb.com"));
		assertEquals("66.135.209.52", server.dnsDig("ebay.com"));
		// need not forward request to DNS server as the IP was accessed previously.
		assertEquals("52.94.225.248", server.dnsDig("imdb.com"));
		// only 3 unique DNS entries fetched. so, routing table size should be 3.
		assertTrue(((ProxyServer) server).getRoutingTableSize() == 3);
	}

}