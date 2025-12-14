package school.sorokin.javacore.Exception.CustomException;

public class InvalidRoomNumberException extends RuntimeException {
    public InvalidRoomNumberException(int roomNumber) {
        super("Некорректный номер комнаты: " + roomNumber +
                ". Номер должен быть в диапазоне от 1 до 1000.");
    }
}
