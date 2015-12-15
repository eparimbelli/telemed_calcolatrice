package calcolatrice;

import javax.swing.JButton;

/**
 *
 * @author Matteo Gabetta <matteo.gabetta at unipv.it>
 */
public class CalcolatriceButton extends JButton implements Comparable<CalcolatriceButton> {
    private int keyCode, ordine;
    private boolean specialButton;

    public CalcolatriceButton(String string, int keyCode, int ordine, boolean special) {
        super(string);
        this.keyCode = keyCode;
        this.ordine = ordine;
        this.specialButton = special;
    }
    
    @Override
    public int compareTo(CalcolatriceButton t) {
        return (ordine-t.ordine);
    }

    public int getKeyCode() {
        return keyCode;
    }

    public boolean isSpecialButton() {
        return specialButton;
    }
}
