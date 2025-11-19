package org.example.model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private Integer roomNumber;
    private Date checkIn;
    private Date chgeckOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(Integer roomNumber, Date checkIn, Date chgeckOut) {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.chgeckOut = chgeckOut;
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


    public Date getChgeckOut() {
        return chgeckOut;
    }

    public long duration(){

        // a variável abaixo recebe o do checkOut menos o valor do checkIn
        // armazenando do valor em milisegundos
        long diff = chgeckOut.getTime() - checkIn.getTime();

        //Aqui convertemos o valor em dias e o retornamos
        return TimeUnit.DAYS.convert(diff, TimeUnit.MICROSECONDS);
    }

    public void updateDate(Date checkIn, Date checkOut){
        this.checkIn = checkIn;
        this.chgeckOut = checkOut;
    }

    @Override
    public String toString(){
        return "Room: "
                + getRoomNumber()
                + ", check-in: "
                + sdf.format(getCheckIn())
                + ", check-out: "
                + sdf.format(getChgeckOut())
                + ","
                + duration()
                + "nights";
    }

}
