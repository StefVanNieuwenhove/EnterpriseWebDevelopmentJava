package domein;

import java.util.List;

public class BeerProperty {

	private List<String> colors;
	
	public BeerProperty() {
		colors = List.of("light", "brown", "dark");
	}
	
	public List<String> getColors() {
		return this.colors;
	}
}
