package calcolatrice;

import calcolatriceModel.Calcolatrice;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Matteo Gabetta <matteo.gabetta at unipv.it>
 */
public class CalcolatriceGUI extends JFrame {

    private Calcolatrice calcolatrice;
    private ArrayList<CalcolatriceButton> allButtons;
    //
    private JLabel screen;
    //
    private JPanel tastierinoPanel;

    public CalcolatriceGUI(Calcolatrice c) {
        this.calcolatrice = c;
        allButtons = new ArrayList<CalcolatriceButton>();
        initComponents();
    }

    private void initComponents() {
        //Bottoni
        allButtons.add(new CalcolatriceButton("0", Calcolatrice.BUTTON_0, 160, false));
        allButtons.add(new CalcolatriceButton("1", Calcolatrice.BUTTON_1, 110, false));
        allButtons.add(new CalcolatriceButton("2", Calcolatrice.BUTTON_2, 120, false));
        allButtons.add(new CalcolatriceButton("3", Calcolatrice.BUTTON_3, 130, false));
        allButtons.add(new CalcolatriceButton("4", Calcolatrice.BUTTON_4, 60, false));
        allButtons.add(new CalcolatriceButton("5", Calcolatrice.BUTTON_5, 70, false));
        allButtons.add(new CalcolatriceButton("6", Calcolatrice.BUTTON_6, 80, false));
        allButtons.add(new CalcolatriceButton("7", Calcolatrice.BUTTON_7, 10, false));
        allButtons.add(new CalcolatriceButton("8", Calcolatrice.BUTTON_8, 20, false));
        allButtons.add(new CalcolatriceButton("9", Calcolatrice.BUTTON_9, 30, false));
        allButtons.add(new CalcolatriceButton(".", Calcolatrice.BUTTON_COMMA, 170, false));
        allButtons.add(new CalcolatriceButton("+", Calcolatrice.BUTTON_PLUS, 40, false));
        allButtons.add(new CalcolatriceButton("−", Calcolatrice.BUTTON_MINUS, 90, false));
        allButtons.add(new CalcolatriceButton("×", Calcolatrice.BUTTON_MOLT, 140, false));
        allButtons.add(new CalcolatriceButton("÷", Calcolatrice.BUTTON_DIV, 190, false));
        allButtons.add(new CalcolatriceButton("=", Calcolatrice.BUTTON_RETURN, 180, false));
        allButtons.add(new CalcolatriceButton("CE", Calcolatrice.BUTTON_CE, 50, false));
        allButtons.add(new CalcolatriceButton("M+", Calcolatrice.BUTTON_M, 100, false));
        allButtons.add(new CalcolatriceButton("MR", Calcolatrice.BUTTON_MR, 150, true));
        allButtons.add(new CalcolatriceButton("MC", Calcolatrice.BUTTON_MC, 200, true));

        Collections.sort(allButtons);

        //ActionListener da associare a tutti i bottoni (una sola istanza!)
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                manageAction(((CalcolatriceButton) ae.getSource()).getKeyCode());
            }

            private void manageAction(int b) {
                calcolatrice.key(b);
                screen.setText(calcolatrice.getDisplay());

                //Gestisce i bottoni speciali
                for (CalcolatriceButton cb : allButtons) {
                    if (cb.isSpecialButton()) {
                        cb.setForeground((calcolatrice.hasMemory()) ? Color.blue : Color.black);
                    }
                }
            }
        };

        for (CalcolatriceButton cb : allButtons) {
            cb.setFont(new java.awt.Font("Arial", 1, 24));
            cb.addActionListener(al);
        }

        //Tastierino Panel
        tastierinoPanel = new JPanel();
        tastierinoPanel.setLayout(new GridLayout(4, 5, 10, 10));
        for (CalcolatriceButton cb : allButtons) {
            tastierinoPanel.add(cb);
        }

        //Screen Label
        screen = new JLabel();
        screen.setText("HELLO!");
        screen.setBackground(Color.black);
        screen.setFont(new java.awt.Font("Synchro LET", 1, 36));
        screen.setForeground(new java.awt.Color(51, 255, 0));
        screen.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        screen.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 40));
        screen.setOpaque(true);
        screen.setPreferredSize(new java.awt.Dimension(100, 70));

        //Main Frame (la classe stessa!!!)
        setLayout(new BorderLayout());
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(500, 300));
        setResizable(false);

        add(tastierinoPanel, BorderLayout.CENTER);
        add(screen, BorderLayout.NORTH);
    }

}
