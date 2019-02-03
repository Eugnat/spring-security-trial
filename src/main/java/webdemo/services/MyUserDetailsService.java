package webdemo.services;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import javax.sql.DataSource;
import java.sql.*;

public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private Connection connection;

    public MyUserDetailsService() {
        super();
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE username = ?");

            statement.setString(1, name);

            ResultSet rs = statement.executeQuery();

            User.UserBuilder userBuilder = null;

            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("userpassword");
                String authorities = rs.getString("authorities");

                if (username != null && password != null && authorities != null) {
                    userBuilder = User.withUsername(username);
                    userBuilder.password(passwordEncoder.encode(password));
                    userBuilder.authorities(authorities);
                }
                else {
                    throw new UsernameNotFoundException("User not configured properly");
                }
                break;
            }

            if (userBuilder != null)
              return userBuilder.build();
            else {
                throw new UsernameNotFoundException("UserBuilder is null");
            }

        }
        catch(SQLException e) {
            throw new UsernameNotFoundException("User name not found!");
        }
        finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            }
            catch(SQLException e) {

            }
        }
    }

}
