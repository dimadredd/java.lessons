package school.sorokin.javacore.Exception.CustomException;

public class Hotel {

    private int availableRooms;

    public Hotel(int availableRooms) {
        this.availableRooms = availableRooms;
    }

    public void bookRoom(int roomNumber) {

        if(roomNumber < 1 || roomNumber > 1000){
            throw new InvalidRoomNumberException(roomNumber);
        }

        if(availableRooms == 0){
            throw new RoomNotAvailableException(roomNumber);
        } else {
            availableRooms--;
            System.out.println("Номер забронирован!");
        }

    }
}
