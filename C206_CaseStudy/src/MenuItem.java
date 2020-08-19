
public class MenuItem {
	
	private String category;
	private String name;
	private boolean healthyChoice;
	private double price;
	
	public MenuItem(String category, String name, boolean healthyChoice, double price) {
		this.category = category;
		this.name = name;
		this.healthyChoice = healthyChoice;
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isHealthyChoice() {
		return healthyChoice;
	}

	public void setHealthyChoice(boolean healthyChoice) {
		this.healthyChoice = healthyChoice;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public String toString() {
		String healthyChoicePrinter = "no";
		if (healthyChoice) {
			healthyChoicePrinter = "yes";
		}
		return String.format("%-20s %-30s %-15s $%-10.2f", category, name, healthyChoicePrinter, price);
	}
	
	

}
