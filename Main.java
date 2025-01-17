import Controller.*;
import Models.*;
import Views.*;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            CampingModel model = new CampingModel();
            CampingView view = new CampingView();
            CampingController controller = new CampingController(model, view);
        });
    }
}
