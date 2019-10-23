package edu.eci.arep.client.REST;

import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.arep.client.Entities.User;
import edu.eci.arep.client.Services.UserServices;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
	UserServices UserServices;
	
	
	
	@RequestMapping(value="/User",method = RequestMethod.GET)
	public ResponseEntity<?> listAllUsers(){
	    try {
	        return new ResponseEntity<>(UserServices.getUsersList(),HttpStatus.ACCEPTED);
	    } catch (Exception ex) {
	        return new ResponseEntity<>("Not Found",HttpStatus.NOT_FOUND);
	    }
    }
    @RequestMapping(value = "User/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getUserById(@PathVariable("id") String userId) {
		try {
			
			return new ResponseEntity<>(UserServices.getUserById(userId),HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("error", HttpStatus.NOT_FOUND);

		}

	}
	@RequestMapping(value = "/User", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody User u) {
		try {
			
			return new ResponseEntity<>(UserServices.createUser(u),HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("error", HttpStatus.NOT_FOUND);

		}

    }
    @RequestMapping(value = "/RUser/{id}", method = RequestMethod.POST)
	public ResponseEntity<?> removeUser(@PathVariable("id") String userId) {
		try {
			UserServices.removeUser(userId);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("error", HttpStatus.NOT_FOUND);

		}

    }
    @RequestMapping(value = "/UUser", method = RequestMethod.POST)
	public ResponseEntity<?> updateUser(@RequestBody User u) {
		try {
			UserServices.updateUser(u);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("error", HttpStatus.NOT_FOUND);

		}

	}
	@RequestMapping( value = "/login", method = RequestMethod.POST )
    public Token login( @RequestBody User login )
        throws ServletException
    {

        String jwtToken = "";

        if ( login.getName() == null || login.getPassword() == null )
        {
            throw new ServletException( "Please fill in username and password" );
        }

        String username = login.getName();
        String password = login.getPassword();

		User user = UserServices.getUserById(login.getName());
		

        if ( user == null )
        {
            throw new ServletException( "User username not found." );
        }

        String pwd = user.getPassword();

        if ( !password.equals( pwd ) )
        {
            throw new ServletException( "Invalid login. Please check your name and password." );
        }
        //
        jwtToken = Jwts.builder().setSubject( username ).claim( "roles", "user" ).setIssuedAt( new Date() ).signWith(
            SignatureAlgorithm.HS256, "secretkey" ).compact();

        return new Token( jwtToken );
    }
    public class Token
    {

        String accessToken;


        public Token( String accessToken )
        {
            this.accessToken = accessToken;
        }


        public String getAccessToken()
        {
            return accessToken;
        }

        public void setAccessToken( String access_token )
        {
            this.accessToken = access_token;
        }
    }
}