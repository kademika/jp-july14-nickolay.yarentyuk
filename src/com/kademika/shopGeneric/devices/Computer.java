package com.kademika.shopGeneric.devices;


public class Computer extends Device {

    private String processor;
    private String videocard;

    private double hdd;
    private double ram;

    private int totalUsb;
    private boolean cardreader;
    private boolean vga;
    private boolean hdmi;
    private boolean ethernet;

    private String os;

    public Computer() {
		
	}

    public Computer(String producer, String model, String color, boolean broken, boolean scratched, double price) {
        super(producer, model, color, broken, scratched, price);
    }
		
	public Computer(String producer, String model, String color, boolean broken, boolean scratched,
			String processor, String videocard, double hdd, double ram,
			int totalUsb, boolean cardreader, boolean vga, boolean hdmi, boolean ethernet, String os, double price) {
		
		super(producer, model, color, broken, scratched, price);

		this.processor = processor;
		this.videocard = videocard;
		this.hdd = hdd;
		this.ram = ram;
		this.totalUsb = totalUsb;
		this.cardreader = cardreader;
		this.vga = vga;
		this.hdmi = hdmi;
		this.ethernet = ethernet;
		this.os = os;
	}

	public String getProcessor() {
		return processor;
	}

	public String getVideocard() {
		return videocard;
	}

	public double getHdd() {
		return hdd;
	}

	public double getRam() {
		return ram;
	}

	public int getTotalUsb() {
		return totalUsb;
	}

	public boolean isCardreader() {
		return cardreader;
	}

	public boolean isVga() {
		return vga;
	}

	public boolean isHdmi() {
		return hdmi;
	}

	public boolean isEthernet() {
		return ethernet;
	}

	public String getOs() {
		return os;
	}

//    @Override
//    public String toString() {
//        StringBuilder stringBuilder = new StringBuilder(super.toString());
//
//        stringBuilder.append(", " + processor + ", HDD: " + hdd + " GB, RAM: " + ram + ", " + totalUsb + " USB");
//        if (cardreader == true) {
//            stringBuilder.append(", cardreader");
//        }
//        if (vga == true) {
//            stringBuilder.append(", VGA");
//        }
//        if (hdmi == true) {
//            stringBuilder.append(", HDMI");
//        }
//        if (ethernet == true) {
//            stringBuilder.append(", Ethernet");
//        }
//        stringBuilder.append(", " + os + ".");
//
//        return stringBuilder.toString();
//    }
}
