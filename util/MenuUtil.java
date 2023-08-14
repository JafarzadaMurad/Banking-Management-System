package util;

import static util.InputUtil.byteInput;

public class MenuUtil {
    public static byte mainMenu(){
        System.out.println(
                """
                        [0] -> Exit system
                        [1] -> Register
                        [2] -> Login
                        [3] -> Increase the balance
                """
        );
        return byteInput("Choose the option: ");
    }

    public static byte loginMenu(){
        System.out.println(
                """
                        [1] -> Show my details
                        [2] -> Update my details
                        [3] -> Operations
                        [4] -> Log out
                """
        );
        return byteInput("Choose the option: ");
    }

    public static byte operationsMenu(){
        System.out.println(
                """
                        [1] - > show balance
                        [2] - > cashing out 
                """
        );
        return byteInput("Choose the option: ");
    }
}
