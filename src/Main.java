
public class Main {

	public static void main(String[] args) {
		//Model - logic
		Model model = new Model();
		//View - UI
		View view = new View();
		//Controller - bridges the gap between Model and View
		Controller controller = new Controller(model, view);

		controller.view.gui.setVisible(true);
	}
}
