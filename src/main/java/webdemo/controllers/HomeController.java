package webdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.List;


@Controller("/")
public class HomeController {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcUserDetailsManager userDetailsManager;

    @Autowired
    private PasswordEncoder encoder;

    @GetMapping
    public String index() {

        return "index";
    }

    @GetMapping("/createUser")
    public String createUser(Model model) {
        int count = 0;

        try (Connection connection = dataSource.getConnection())
        {
            Statement statement = connection.createStatement();
            statement.execute("SELECT COUNT(*) FROM users");
            ResultSet rs = statement.getResultSet();

            while (rs.next()) {
                count = rs.getInt(1);
            }

            statement.close();
        }
        catch(SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }

        count++;

        String userString = "user" + count;
        String passwordString = encoder.encode("user" + count);
        List<GrantedAuthority> authorityList = AuthorityUtils.createAuthorityList("ROLE_ADMIN");

        UserDetails user = new User(userString, passwordString, authorityList);

        userDetailsManager.createUser(user);

        model.addAttribute("infoString","Created a new user: " + user.getUsername() + ", " + user.getPassword());

        return "index";
    }

    @GetMapping("/trial")
    public String trial() {

        return "trial";
    }

    @GetMapping("/servlet")
    public String servlet() {

        return "servlet";
    }

    @GetMapping("/myLogin")
    public String login() {
        return "login";
    }
}
