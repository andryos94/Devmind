package recap4;

public class AppVehicle {

	public static void main(String[] args) {
		Vehicle v1 = new Vehicle(2008, "1M8GDM9AXKP042788", "B 06 897", 12100);
		System.out.println(v1.display());
		v1.moveVehicle(123.4, 12.8);
		System.out.println(v1.display());
		System.out.println("Este valid VIN-ul lui v1?: " + v1.isVinValid(true));
		if(v1.isVinValid(true)) {
			v1.printVinDecomposed();
		}
		Vehicle v2 = new Vehicle(2010, "1M8GDM9AXKP042777");
		System.out.println(v1.display());
		System.out.println(v2.display());
		System.out.println("Este valid VIN-ul lui v2?: " + v2.isVinValid(true));
		if(v2.isVinValid(true)) {
			v2.printVinDecomposed();
		}

	}

}
