package webdemo.services;

public class MySampleInterfaceImpl implements MySampleInterface {

    @Override
    public void printUsername(String userName) {
        System.out.println("User name: " + userName);
    }
}
