
package user.GUI;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;
/**
 *
 * @author Adrian
 */


public class Principal {

    public static void main(String[] args) {
        FlatLightLaf.setup();
        UIManager.put("TextComponent.arc", 3);

        NewJFrame ventana = new NewJFrame();
        ventana.setVisible(true);
    }

}
