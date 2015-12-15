package calcolatrice;

import calcolatriceModel.Calcolatrice;

/**
 *
 * @author Matteo Gabetta <matteo.gabetta at unipv.it>
 */
public class CalcolatriceGUITester {
    public static void main(String[] args){
        Calcolatrice calcolatrice = new Calcolatrice();
        CalcolatriceGUI calcolatriceGUI = new CalcolatriceGUI(calcolatrice);
        
        calcolatriceGUI.setVisible(true);
    }
}
