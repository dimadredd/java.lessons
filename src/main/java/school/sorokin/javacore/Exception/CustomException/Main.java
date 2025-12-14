package school.sorokin.javacore.Exception.CustomException;

public class Main {
    public static void main(String[] args) {

        Hotel ht = new Hotel(2);

        try {
            ht.bookRoom(125);
            ht.bookRoom(101);
            ht.bookRoom(2);
            ht.bookRoom(1005);
        }catch (RoomNotAvailableException e){
            System.out.println("Ошибка бронирования: " + e.getMessage());
        }catch (InvalidRoomNumberException e){
            System.out.println("Ошибка ввода: " + e.getMessage());
        }
    }
}
