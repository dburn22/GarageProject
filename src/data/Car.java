package data;

public class Car {
	private String make;
	private String model;
	private String whp;
	private String torque;
	private String topSpeed;
	private String color;

	public Car() {
	}

	public Car(String make, String model, String whp, String torque, String topSpeed, String color) {
		super();
		this.make = make;
		this.model = model;
		this.whp = whp;
		this.torque = torque;
		this.topSpeed = topSpeed;
		this.color = color;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getWhp() {
		return whp;
	}

	public void setWhp(String whp) {
		this.whp = whp;
	}

	public String getTorque() {
		return torque;
	}

	public void setTorque(String torque) {
		this.torque = torque;
	}

	public String getTopSpeed() {
		return topSpeed;
	}

	public void setTopSpeed(String topSpeed) {
		this.topSpeed = topSpeed;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Car [make=");
		builder.append(make);
		builder.append(", model=");
		builder.append(model);
		builder.append(", whp=");
		builder.append(whp);
		builder.append(", torque=");
		builder.append(torque);
		builder.append(", topSpeed=");
		builder.append(topSpeed);
		builder.append(", color=");
		builder.append(color);
		builder.append("]");
		return builder.toString();
	}



}
