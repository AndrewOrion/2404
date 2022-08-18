package principal;

import modelo.SeguroCoche;

public class PruebaSeguro {

	public static void main(String[] args) {
		SeguroCoche seg1 = new SeguroCoche();
		System.out.println(seg1+"\n");
		
		SeguroCoche seg2 = new SeguroCoche("123", "Juan", "Perez Raya", "30999999J", 2020,
				"Anual", 200, 2, "4567WWW", 2000);
		
		System.out.println(seg2+"\n");
		System.out.println("La prima de "+seg2.getNombre()+" "+seg2.getApellidos()+" es: "+
				seg2.calcularPrima());
		
		seg2.setPrimaBase(425);
		System.out.println("La prima de "+seg2.getNombre()+" "+seg2.getApellidos()+" es: "+
				seg2.calcularPrima());
		
		
	

	}

}
