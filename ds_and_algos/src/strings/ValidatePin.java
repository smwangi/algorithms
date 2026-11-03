package strings;

public class ValidatePin {

    public static void main(String[] args) {

        System.out.println( validatePin("1234"));
        System.out.println( validatePin("12345"));
        System.out.println( validatePin("a234"));
    }
    public static boolean validatePin(String pin) {

        /*if(pin.chars().allMatch(Character::isDigit) && (pin.length() == 4 || pin.length() == 6)){
            return true;
        }else{
            return false;
        }*/
        return pin.matches("\\d{4}|\\d{6}");

    }
}
