package com.kademika.shop;

import com.kademika.shop.devices.Computer;
import com.kademika.shop.devices.Device;
import com.kademika.shop.devices.Notebook;
import com.kademika.shop.devices.Printer;
import com.kademika.shop.devices.Telephone;
import com.kademika.shop.devices.Tv;

public class Store {
	
	private static double pricedown = 20;
	
	private Computer[] computers;
	private Notebook[] notebooks;
	private Printer[] printers;
	private Telephone[] phones;
	private Tv[] tvs;
	
	Registration registration;

	GuiTransactionList lGui;	//	TransactionList
	
//	private Transaction[] tranzactions = new Transaction[100];
	
//	public Device[] storeDevices = computers;
	
	public Store() {
		
		computers = new Computer[100];
		notebooks = new Notebook[100];
		printers = new Printer[100];
		phones = new Telephone[100];
		tvs = new Tv[100];
		
		registration = new Registration();
		
		lGui = new GuiTransactionList(this);	//	TransactionList starts
	}
	
	public void addDevices(Device[] devices) {
		
		for (int i = 0; i < devices.length; i++) {
			if (devices[i] == null) {
				break;
			}
			
			addDevice(devices[i]);
		}
	}
	
	public void addDevice(Device device) {
		
		if (device instanceof Notebook) {
			addToStore(device, notebooks);
		}
		else if (device instanceof Computer) {
			addToStore(device, computers);
		}
		else if (device instanceof Printer) {
			addToStore(device, printers);
		}
		else if (device instanceof Telephone) {
			addToStore(device, phones);
		}
		else if (device instanceof Tv) {
			addToStore(device, tvs);
		}
		else {
			System.out.println("This device isn't for this shop.");
		}
	}
	
	private void addToStore(Device device, Device[] storeDevices) {
		
		int nNew;
		
		device.switchOn();
		if (device.isSwitchedOn() == false) {
			System.out.println("This is not accepted.");
		}
		
		else {
			device.switchOff();
			
			if (storeDevices[storeDevices.length-1] != null) {
				Device[] t = storeDevices;
				
				if (device instanceof Notebook) {
					storeDevices = new Notebook[t.length + 100];
				}
				else if (device instanceof Computer) {
					storeDevices = new Computer[t.length + 100];
				}
				else if (device instanceof Printer) {
					storeDevices = new Printer[t.length + 100];
				}
				else if (device instanceof Telephone) {
					storeDevices = new Telephone[t.length + 100];
				}
				else {
					storeDevices = new Tv[t.length + 100];
				}
				
				System.arraycopy(t, 0, storeDevices, 0, t.length);
				nNew = t.length;
			}
			else {
				for (nNew = 0; nNew < storeDevices.length; nNew++) {
					if (storeDevices[nNew] == null) {
						break;
					}
				}
			}
			
			if (device.isSkratched()) {
				device.setPrice(toPricedown(device.getPrice()));
			}
			
			storeDevices[nNew] = device;
		}
	}
	
	private double toPricedown(double price) {
		
		return price - price * pricedown / 100;
	}
	
//	public void pricelist(boolean skratched) {
//		
//		if (skratched == false)
//			System.out.println("Pricelist of valid devices:");
//		else
//			System.out.println("Pricelist of defective devices:");
//			
//			System.out.println();
//			System.out.println();
//			System.out.print("Computers:");
//			printPrices(computers, skratched);
//			
//			System.out.println();
//			System.out.print("Notebooks:");
//			printPrices(notebooks, skratched);
//			
//			System.out.println();
//			System.out.print("Printers:");
//			printPrices(printers, skratched);
//			
//			System.out.println();
//			System.out.print("Telephones:");
//			printPrices(phones, skratched);
//			
//			System.out.println();
//			System.out.print("TVs:");
//			printPrices(tvs, skratched);
//	}
//	
//	private static void printPrices(Device[] devices, boolean skratched) {
//		
//		if (devices[0] == null) {
//			System.out.println(" absent.");
//			return;
//		}
//			
//		if (skratched == false) {
//			for (int i = 0; i < devices.length; i++) {
//				if (devices[i] == null)
//					break;
//				if (devices[i].isSkratched() == false) {
//					System.out.println(" " + devices[i].getPrice() + " grn.");
//					break;
//				}
//			}
//		}
//		
//		else {
//			System.out.println();
//			
//			int count = 0;
//			
//			for (int i = 0; i < devices.length; i++) {
//				if (devices[i] == null) {
//					if (count == 0)
//						System.out.println("absent.");
//					break;
//				}
//				if (devices[i].isSkratched() == true) {
//					System.out.println(devices[i].getProduser() + " " + devices[i].getModel() + ": "
//							+ devices[i].getPrice() + " grn.");
//				}
//			}
//		}
//	}
	
//	public void pricelist(boolean skratched) {
//		
//		if (skratched == false) {
//			System.out.println("Pricelist of valid devices:");
//			System.out.println();
//			
//			System.out.println("Computers: " + countDevices(computers) + );
//		}
//	}
	
	public void fullTotalDevices() {
		
		System.out.println();
		System.out.println("Total of the present decices:");
		System.out.println();
		
		System.out.println("Computers: " + linkTheDevice(computers));
		System.out.println("Notebooks: " + linkTheDevice(notebooks));
		System.out.println("Printers: " + linkTheDevice(printers));
		System.out.println("Phones: " + linkTheDevice(phones));
		System.out.println("TVs: " + linkTheDevice(tvs));
	}
	
	private int linkTheDevice(Device[] devices) {
		
		if (devices[0] == null) {
			return 0;
		}
		
		int i = 0;
		for (i = 0; i < devices.length; i++) {
			if (devices[i] == null) {
				return i;
			}
		}
		return i;
	}
	
	public void catalogFull() {
		
		System.out.println();
		
		System.out.println("Computers:");
		System.out.println();
		printDevices(computers);
		System.out.println();
		
		System.out.println("Notebooks:");
		System.out.println();
		printDevices(notebooks);
		System.out.println();
		
		System.out.println("Printers:");
		System.out.println();
		printDevices(printers);
		System.out.println();
		
		System.out.println("Telephones:");
		System.out.println();
		printDevices(phones);
		System.out.println();
		
		System.out.println("TV:");
		System.out.println();
		printDevices(tvs);
	}
	
	public Device[] catalogByCategory(int type) {
		
		System.out.println();
		
		Device[] devices;
		
		if (type == 0) {
			System.out.println("Computers:");
			System.out.println();
			devices = computers;
		} else if (type == 1) {
			System.out.println("Notebooks:");
			System.out.println();
			devices = notebooks;
		} else if (type == 2) {
			System.out.println("Printers:");
			System.out.println();
			devices = printers;
		} else if (type == 3) {
			System.out.println("Telephones:");
			System.out.println();
			devices = phones;
		} else if (type == 4) {
			System.out.println("TV:");
			System.out.println();
			devices = tvs;
		} else {
			System.out.println("Wrong option.");
			return null;
		}
		
		int total = printDevices(devices);
		
		if (total == 0) {
			System.out.println("Empty.");
			return null;
		} else if (total == devices.length) {
			return devices;
		}
//		else {
			Device[] t = new Device[total];
			System.arraycopy(devices, 0, t, 0, total);
			return t;
//		}
	}
	
	private int printDevices(Device[] devices) {
		
		for (int i = 0; i < devices.length; i++) {
			if (devices[i] == null) {
				return i;
			}
			
			System.out.print(i+1 + ". ");
			printDevice(devices[i]);
		}
		return devices.length;
	}
	
	private void shortPrintDevice(Device device) {
		
		System.out.print(device.getProduser() + " " + device.getModel() + ": " + device.getColor());
		
		if (device.isSkratched()) {
			System.out.print(" (skratched)");
		}
		
		System.out.println(": " + device.getPrice() + " grn.");
	}
	
	private void printDevice(Device device) {
		
		System.out.print(device.getProduser() + " " + device.getModel());
		
		if (device.isSkratched()) {
			System.out.print(" (skrached)");
		}
		
		System.out.print(": " + device.getColor() + ", ");
		
		if (device instanceof Computer) {
			Computer c = (Computer)device;
			System.out.print(c.getProcessor() + ", " + c.getVideocard() + ", HDD: " + c.getHdd() + " (GB), RAM: " +
					c.getRam() + " (GB), " + c.getTotalUsb() + " USB, ");
			if (c.isCardreader())
				System.out.print("Cardreader, ");
			if (c.isVga())
				System.out.print("VGA, ");
			if (c.isHdmi())
				System.out.print("HDMI, ");
			if (c.isEthernet())
				System.out.print("Ethernet port, ");
			System.out.print(c.getOs());
			
			if (device instanceof Notebook) {
				Notebook n = (Notebook) device;
				System.out.print(", diagonal: " + n.getDiagonal() + " (inches), " + n.getBattaryLife() + " (h)");
			}
			
//			System.out.println(".");
		}
		
		else if (device instanceof Printer) {
			Printer p = (Printer) device;
			System.out.print(p.getType() + ", ");
			if (p.isColored() == true) {
				System.out.print("Colored");
			}
			else {
				System.out.print("Uncolored");
			}
			System.out.print(", " + p.getResolution() + " (picsels)");
		}
		
		else if (device instanceof Telephone) {
			Telephone t = (Telephone) device;
			System.out.print(t.getType() + ", " + t.getTotalSim() + " sim, " + t.getOs());
		}
		
		else if (device instanceof Tv) {
			Tv t = (Tv) device;
			System.out.print(t.getDiagonal() + " (inches)");
			if (t.isFunc3d()) {
				System.out.print(", 3D");
			}
//			System.out.println(".");
		}
		System.out.println(", " + device.getPrice() + " grn.");
	}
	
	public void buy(Customer customer, Device device) {
		
		Device[] storeDevices;
		
		device.setPrice(discount(device.getPrice()));

        if (device instanceof Notebook) {
			storeDevices = notebooks;
		}
		else if (device instanceof Computer) {
			storeDevices = computers;
		}
		else if (device instanceof Printer) {
			storeDevices = printers;
		}
		else if (device instanceof Telephone) {
			storeDevices = phones;
		}
		else {
			storeDevices = tvs;
		}
		
		for (int i = 0; i < storeDevices.length; i++) {
			if (storeDevices[i] == device) {
				int nDelete = 0;
				
				if (i == storeDevices.length - 1 || storeDevices[i + 1] == null) {
					nDelete = i;
				}
				else for (int j = i; j < storeDevices.length - 1; j++) {
					if (storeDevices[j + 1] == null) {
						nDelete = j;
						break;
					}
					
					storeDevices[i] = storeDevices[i+1];
				}
				
				storeDevices[nDelete] = null;
				
				break;
			}
		}
		
		registration.newTransaction(customer, device, lGui);
		
		System.out.println();
		System.out.print(customer.getFirstname() + " " + customer.getLastname() + " bought ");
		shortPrintDevice(device);

        lGui.createListPanel();
	}

    private double discount(double price) {
       if (price > 1000) {
            return price * 0.9;
        } else if (price > 500) {
           return price - price * 0.05;
        }
        return price;
    }

	public void tranzactionList() {
		registration.transactionList();
	}
	
	public void resultToday() {
		registration.resultToday();
	}
	
	public void results7Days() {
		registration.results7Days();
	}
	
	public void nextDay() {
		registration.nextDay();
	}

	public Computer[] getComputers() {
		return computers;
	}

	public Notebook[] getNotebooks() {
		return notebooks;
	}

	public Printer[] getPrinters() {
		return printers;
	}

	public Telephone[] getPhones() {
		return phones;
	}

	public Tv[] getTvs() {
		return tvs;
	}

	public Registration getRegistration() {
		return registration;
	}
}
