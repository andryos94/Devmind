package recap4;

public class Vehicle {
	private static final String producedBy = "Ford";
	private static final char[] letters = new char[] {'A','B','C','D','E','F','G','H','J','K','L','M','N','P','R','S','T','U','V','W','X','Y','Z'};
	private static final int[] valueOfLetter = new int[] {1,2,3,4,5,6,7,8,1,2,3,4,5,7,9,2,3,4,5,6,7,8,9};
	private static final int[] weights = new int[] {8,7,6,5,4,3,2,10,0,9,8,7,6,5,4,3,2};
	private final int productionYear;
	private final String vin;
	private String plateNumber;
	private double kilometers;
	private int lastSoldOnYear;
	private double positionX;
	private double positionY;
	
	public int getProductionYear() {
		return productionYear;
	}

	public int getLastSoldOnYear() {
		return lastSoldOnYear;
	}
	
	public static String getProducedby() {
		return producedBy;
	}
	
	public int getValueOfLetter(char a) {
		for(int i = 0; i < letters.length; i++) {
			if(letters[i] == a) {
				return valueOfLetter[i];
			}
		}
		return 0;
	}
	public String getVin() {
		return vin;
	}
	
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
		String vinVehicle = getVin();
		int sumOfProducts = 0;
		for(int i = 0; i < vinVehicle.length(); i++) {
			if(Character.isLetter(vinVehicle.charAt(i))) {
				if(i == 8) {
					continue;
				}
				sumOfProducts += (getValueOfLetter(vinVehicle.charAt(i)) * weights[i]);
			} else {
				sumOfProducts += (vinVehicle.charAt(i) - 48) * weights[i];
			}
		}
		
		if(sumOfProducts % 11 == 10) {
			return true;
		}
		return false;
	}
	
	public void printVinDecomposed() {
		String vinVehicle = getVin();
		String manufacturerIdentifier = vinVehicle.substring(0, 3);
		String vehicleAttributes = vinVehicle.substring(3, 8);
		String checkDigit = vinVehicle.substring(8, 9);
		String productionYear = vinVehicle.substring(9, 10);
		String factoryId = vinVehicle.substring(10, 11);
		String idNumber = vinVehicle.substring(11);
		System.out.println("The VIN decomposed:\nIdentificatorul producatorului: " + manufacturerIdentifier + 
				"\nAtributele vehiculului: " + vehicleAttributes + "\nCifra de verificare: " + checkDigit +
				"\nAnul productiei modelului: " + productionYear + "\nSeria fabricii: " + factoryId + 
				"\nIdentificatorul numeric: " + idNumber);
	}
	
	public String display() {
		return ("Vehiculul verificat are urmatoarele specificatii: \n\t-> Marca: " + getProducedby() + ";\n\t-> Anul fabricarii: " +
	getProductionYear() + ";\n\t-> VIN: " + getVin() + ";\n\t-> Numar de inmatriculare: " + getPlateNumber() + ";\n\t-> Kilometri parcursi: " + 
				getKilometers() + ".");
	}
}
