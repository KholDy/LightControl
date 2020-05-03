package xyz.kholdy.smartlight;

public enum Ip {
	
	HALLWAY("192.168.0.100"), KITCHEN("192.168.0.103"),
	LIVINGROOM("192.168.0.102"), BEDROOM("192.168.0.101");
	
	private String value;
	
	private Ip(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}
