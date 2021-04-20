package view.Reservation;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReservationsHomeView extends JFrame {

    private static final long serialVersionUID = 0;
    private static final int HORIZONTALGAP = 20;
    private static final int VERTICALGAP = 25;
    private static final int INFOTEXTFONTDIM = 15;

    private JPanel buttonsPanel = new JPanel();
    private JButton viewReservationButton = new JButton("Visualizza prenotazioni");
    private JButton addReservationButton = new JButton("Aggiungi prenotazione");
    private JButton modifyReservationButton = new JButton("Modifica prenotazione");
    private JButton deleteReservationButton = new JButton("Elimina prenotazione");
    private final JPanel infoPanel = new JPanel();
    private final JLabel infoLabel = new JLabel("Scegliere l'operazione da eseguire");
    private final FlowLayout buttonsPanelLayout = new FlowLayout(FlowLayout.CENTER, 100, 15);
    private final FlowLayout infoPanelLayout = new FlowLayout(FlowLayout.CENTER);



     /**
     * Create the frame.
     */
    public ReservationsHomeView() {

        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(buttonsPanel, BorderLayout.CENTER);
        this.setTitle("Prenotazioni");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        this.setBounds(100, 100, 450, 300);
        this.buttonsPanelLayout.setHgap(HORIZONTALGAP);
        this.buttonsPanel.setLayout(buttonsPanelLayout);
        this.buttonsPanel.add(deleteReservationButton);
        this.buttonsPanel.add(modifyReservationButton);
        this.buttonsPanel.add(viewReservationButton);
        this.buttonsPanel.add(addReservationButton);
        this.infoPanel.setLayout(infoPanelLayout);
        this.infoPanelLayout.setVgap(VERTICALGAP);
        this.getContentPane().add(infoPanel, BorderLayout.NORTH);
        this.infoLabel.setFont(new Font("Tahoma", Font.PLAIN, INFOTEXTFONTDIM));
        this.infoPanel.add(infoLabel);

        this.addReservationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
               AddReservationView newReservationView = new AddReservationView();
               newReservationView.setVisible(true);
            }
        });
    }
}
