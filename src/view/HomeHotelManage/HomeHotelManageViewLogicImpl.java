package view.HomeHotelManage;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import controller.Reservation.ControllerReservation;
import controller.Reservation.ControllerReservationImpl;
import model.Reservation.Reservation;

public class HomeHotelManageViewLogicImpl implements HomeHotelManageViewLogic {

    private final ControllerReservation reservationController = new ControllerReservationImpl();
    private SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");


    @Override
    public final Color statusOnDate(final Date currentDate, final int roomNumber) {
        Set<Reservation> reservations = reservationController.getAllReservation();

        for (Reservation reservation : reservations) {
            String dateIn = dateFormatter.format(reservation.getDateIn());
            String dateOut = dateFormatter.format(reservation.getDateOut());

            if ((reservation.getRoom().getNumber()) - 1 == roomNumber) {
                if ((currentDate.after(reservation.getDateIn()) && currentDate.before(reservation.getDateOut()))
                        || dateIn.equals(dateFormatter.format(currentDate))) {
                    return Color.RED;
                } else if (dateOut.equals(dateFormatter.format(currentDate))) {
                    return Color.ORANGE;
                } else {
                    return Color.GREEN;
                }
            }
        }
        return Color.GREEN;
    }
}