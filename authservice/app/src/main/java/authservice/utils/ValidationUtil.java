package authservice.util;

import authservice.model.UserInfoDto;

public class ValidationUtil {

    public static void validateUserAttributes(UserInfoDto user) {
        if (user == null) {
            throw new IllegalArgumentException("User data cannot be null.");
        }

        if (user.getUsername() == null || user.getUsername().trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty.");
        }

        if (user.getPassword() == null || user.getPassword().length() < 6) {
            throw new IllegalArgumentException("Password must be at least 6 characters long.");
        }
    }
}