package portaltasks.PhoneNumber;

public class InvalidPhoneNumberLengthException extends Exception {
    public InvalidPhoneNumberLengthException(String message) {
        super(message);
    }
    public InvalidPhoneNumberLengthException() {
        super("Số điện thoại không hợp lệ");
    }
}
