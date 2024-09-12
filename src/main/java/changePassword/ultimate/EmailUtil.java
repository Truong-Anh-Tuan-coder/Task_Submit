package changePassword.ultimate;

import changePassword.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

import static org.springframework.beans.factory.support.InstanceSupplier.using;
@Component
public class EmailUtil {

	public static void sendEmail(String password) {
		String to = "test@email.com";
		String from = "test@email.com";
		String host = "smtp.freesmtpservers.com";

		Properties properties = new Properties();
		properties.setProperty("mail.smtp.host", host);
		properties.put("mail.smtp.port", "25"); // Port for STARTTLS
		properties.put("mail.smtp.starttls.enable", "true");
		javax.mail.Session session = Session.getDefaultInstance(properties);

		try {
			MimeMessage message = new MimeMessage(session);

			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO,
					new InternetAddress(to));
			message.setSubject("ping");
			message.setText("Hi, you new password is: "+ password);

			Transport.send(message);

		} catch(MessagingException mex){
			mex.printStackTrace();
		}
	}

}
