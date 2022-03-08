package domein;

import java.util.List;

public class BeerExpertBean {

	public List<String> getBrands(String color) {
		return switch (color.toLowerCase()) {
				case "light" -> List.of("Hoegaarden", "Brugs witbier");
				case "brown" -> List.of("Westmalle bruin", "Leffe bruin");
				case "dark" -> List.of("Affligem donker");
				default -> List.of();
		};
		
	}
}
