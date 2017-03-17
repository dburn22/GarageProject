package data;

public class Car {
	private String make;
	private String model;
	private String whp;
	private String torque;
	private String topSpeed;
	private String color;
	private String picture;
	private int carNum;

	public Car() {
	}

	public Car(String make, String model, String whp, String torque, String topSpeed, String color, String picture,
			int carNum) {
		super();
		this.make = make;
		this.model = model;
		this.whp = whp;
		this.torque = torque;
		this.topSpeed = topSpeed;
		this.color = color;
		this.picture = picture;
		this.carNum = carNum;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
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

	public int getCarNum() {
		return carNum;
	}

	public void setCarNum(int carNum) {
		this.carNum = carNum;
	}

	@Override
	public String toString() {
		return "Car [make=" + make + ", model=" + model + ", whp=" + whp + ", torque=" + torque + ", topSpeed="
				+ topSpeed + ", color=" + color + ", picture=" + picture + ", carNum=" + carNum + "]";
	}

}
