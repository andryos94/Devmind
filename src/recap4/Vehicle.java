package recap4;

public class Vehicle {
	private static final String producedBy = "Ford";
	private static final char[] letters = new char[] {'A','B','C','D','E','F','G','H','J','K','L','M','N','P','R','S','T','U','V','W','X','Y','Z'};
	private static final int[] valueOfLetter = new int[] {1,2,3,4,5,6,7,8,1,2,3,4,5,7,9,2,3,4,5,6,7,8,9};
	private final int productionYear;
	private final String vin;
	private String plateNumber;
	private double kilometers;
	private int lastSoldOnYear;
	private double positionX;
	private double positionY;
	
	public double getKilometers() {
		return kilometers;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public Vehicle(int productionYear, String vin) {
		this.productionYear = productionYear;
		this.vin = vin;
	}
	
	public Vehicle(int productionYear, String vin, String plateNumber) {
		this(productionYear, vin);
		this.plateNumber = plateNumber;
	}
	
	public Vehicle(int productionYear, String vin, String plateNumber, int kilometers) {
		this(productionYear, vin, plateNumber);
		this.kilometers = kilometers;
	}
	
	public void sellVehicle(String plateNumber, int lastSoldOnYear) {
		this.plateNumber = plateNumber;
		this.lastSoldOnYear = lastSoldOnYear;
	}
	
	public void moveVehicle(double positionX, double positionY) {
		double newKilometers = Math.sqrt(Math.pow((positionX - this.positionX), 2) + Math.pow((positionY - this.positionY), 2));
		this.positionX = positionX;
		this.positionY = positionY;
		this.kilometers += newKilometers;
	}
	
	public boolean isVinValid(boolean isDrivingInNorthAmerica) {
		if(isDrivingInNorthAmerica == false) {
			return true;
		}
		return false;
	}
}
