package org.example.model.entities;

import org.example.model.exceptions.DomainException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException{
        if(!checkOut.after(checkIn)){
            throw new DomainException("Check-out date must be after check-in date");
        }
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }


    public Date getCheckOut() {
        return checkOut;
    }

    public long duration(){

        // a variável abaixo recebe o do checkOut menos o valor do checkIn
        // armazenando do valor em milisegundos
        long diff = checkOut.getTime() - checkIn.getTime();

        //Aqui convertemos o valor em dias e o retornamos
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public void updateDate(Date checkIn, Date checkOut)throws DomainException{
        Date now = new Date();

        if(checkIn.before(now) || checkOut.before(now)){
            throw new DomainException("Reservation dates for update be future dates");
        }
        if(!checkOut.after(checkIn)){
            throw new DomainException("Check-out date must be after check-in date");
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString(){
        return "Room: "
                + getRoomNumber()
                + ", check-in: "
                + sdf.format(getCheckIn())
                + ", check-out: "
                + sdf.format(getCheckOut())
                + ","
                + duration()
                + " nights";
    }

}
