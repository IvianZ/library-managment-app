package Service;

import Model.User;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class UserService {
    private Map<Integer, User> users = new HashMap<>();

    private Scanner scanners = new Scanner(System.in);

    public void addUser() {
        System.out.println("Enter id: ");
        Integer id = scanners.nextInt();

        for (Integer userId : users.keySet()){
            if (Objects.equals(userId, id)) {
                System.out.println("This user is already added");
                return;
            }
        }

        System.out.println("Write first name : ");
        String firstName = scanners.next();

        System.out.println("Write last name : ");
        String lastName = scanners.next();

        User newUser = new User(id, firstName, lastName, Instant.now() , null);

        users.put(id, newUser);

        System.out.println(
                String.format(
                        "Successfully created a user %s - %s - %s ",
                        id,
                        firstName,
                        lastName
                )
        );


    }
    public User getUser(Integer userId){
        return users.get(userId);
    }
    public User getUser() {
        System.out.println(" Enter id for users ");

        Integer id;

        try {
            id = scanners.nextInt();

        } catch (Exception exception) {
            System.out.println("Please enter only numbers ");
            return null;

        }
        User existingUser = users.get(id);

        if (existingUser == null) {
            System.out.println("Not found ");
            return null;
        }
        System.out.println(
                String.format(
                        "Found user %s - %s - %s - %s -%s ",
                        existingUser.getId(),
                        existingUser.getFirstName(),
                        existingUser.getLastName(),
                        existingUser.getCreateDate(),
                        existingUser.getUpdateTime()
                )
        );
        return existingUser;
    }

    public void updateUser() {
        User updateUsers = getUser();
        System.out.println(
                String.format(
                        "Current first name %s" ,
                        updateUsers.getFirstName()

                )
        );
        System.out.println("Enter new first name: ");
        String newFirstName = scanners.next();
        updateUsers.setFirstName(newFirstName);
        updateUsers.setUpdateTime(Instant.now());



    }

    public void deleteUser() {
        System.out.println("Enter id of the user you wont delete ? ");
        Integer id = scanners.nextInt();
        users.remove(id);
        System.out.println("You successful delete the user ");


    }

}
