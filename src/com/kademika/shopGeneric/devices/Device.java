package com.kademika.shopGeneric.devices;

public abstract class Device {
	
	protected double price = 0;
	protected String producer;
	protected String model;
	protected String color;
	protected boolean switchedOn = false;
	protected boolean scratched;
	protected boolean broken;

	public Device() {
		price = 1;
	}
	
	public Device(String producer, String model, String color, boolean broken, boolean scratched, double price) {
		this.producer = producer;
		this.model = model;
		this.color = color;
		this.broken = broken;
		this.scratched = scratched;
		this.price = price;
	}
	
	public void switchOn() {
		if (broken == false)
		switchedOn = true;
	}
	
	public void switchOff() {
		switchedOn = false;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}

	public String getProducer() {
		return producer;
	}

	public String getModel() {
		return model;
	}

	public String getColor() {
		return color;
	}

	public boolean isSwitchedOn() {
		return switchedOn;
	}

	public boolean isScratched() {
		return scratched;
	}

    public String shortFeatures() {
        return producer + ", " + model;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(producer + ", " + model + ", " + color);

        if (broken == true) {
            stringBuilder.append(", broken");
        }
        if (scratched == true) {
            stringBuilder.append(", scratched");
        }

        return stringBuilder.toString();
    }
}
