package school.sorokin.javacore.Exception.CustomException;

public class RoomNotAvailableException extends RuntimeException {
    public RoomNotAvailableException (int roomNumber){
        super("Комната № " + roomNumber + " недоступна.");
    }
}
