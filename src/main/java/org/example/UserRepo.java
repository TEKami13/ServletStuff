package org.example;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserRepo {

    private static Map<String, String> users = Map.of(
            "tobias", "password"
    );

    public static Map<String, String> getUsers() {
        return users;
    }

}
