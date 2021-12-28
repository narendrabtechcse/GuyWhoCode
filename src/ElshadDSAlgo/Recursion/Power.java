package ElshadDSAlgo.Recursion;

public class Power {

	public Power() {
		// TODO Auto-generated constructor stub
		
		
	}

	public static void main(String[] args) {
		Long power = calculatePower(2,10);
		System.out.println(power);

	}

	private static Long calculatePower(int base, int power) {
	
		//2pow3= 2*2pow2
		if(base>0 && power>0)
		return base*calculatePower(base,power-1);
		else
			return 1L;
	}

}
