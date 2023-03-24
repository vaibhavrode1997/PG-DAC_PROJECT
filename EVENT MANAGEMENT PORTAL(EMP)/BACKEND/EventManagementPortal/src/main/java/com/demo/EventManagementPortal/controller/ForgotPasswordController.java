package com.demo.EventManagementPortal.controller;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.EventManagementPortal.beans.User;
import com.demo.EventManagementPortal.service.IEmailSenderService;
import com.demo.EventManagementPortal.service.UserService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/forgot-password")
public class ForgotPasswordController {

	Random random = new Random();
	@Autowired
	private UserService userService;

	@Autowired
	private IEmailSenderService emailService;

	static int otp;
	@PostMapping("/verifyOTP")
	public ResponseEntity<User> VerifyEmailSendOTP(@RequestBody User u1){
		System.out.println(u1);
		User user=userService.findByEmail(u1.getEmail());
		if(user!=null) {

			otp=random.nextInt(99999);
			System.out.println("OTP "+otp);
			String subject="OTP from EMP";
			String massage="OTP to reset your EMP password..."+otp;
			String to=u1.getEmail();
			
			String msg=null;
			try {
				msg=emailService.sendOTPEmail(subject,massage,to);
				System.out.println(to);
				return new ResponseEntity(""+msg+user,HttpStatus.OK);
			}catch(MailException e) {
				e.printStackTrace();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		return new ResponseEntity("Email not found..!! Check Email and Retry",HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/otpvfn/{otp}")
	public ResponseEntity<String> VerifyOtp(@PathVariable int otp /*,User u */){
		System.out.println("in otp verification");
		System.out.println(otp);
//		//on the front end we are storing the object so we will redirect user here and if vfn success then redirect to the new password page
//		if(otp==newotp) {
//			System.out.println("otp verified successfully");
			return new ResponseEntity("Verification Successful",HttpStatus.ACCEPTED);
//		}
//		System.out.println("verification failed");
//		return new ResponseEntity("Verification Failed..Please enter correct OTP",HttpStatus.EXPECTATION_FAILED);
	}
	
	@PutMapping("/enternewpass")
	public ResponseEntity<String>newPassword(@RequestBody User user){
		//as at the front End we are storing object so we will use stored user and updated password 
		int u=userService.updateUser(user);
		if(u>0) {
			return new ResponseEntity("Password updated successfully",HttpStatus.OK);
		}
		return new ResponseEntity("User not found",HttpStatus.NOT_FOUND);
	}
}
//    @PostMapping
//    public ResponseEntity<String> forgotPassword(@RequestBody Map<String, Object> payload) {
//    	System.out.println("in forgot password");
//        String email = (String) payload.get("email");
//        User user = userService.findByEmail(email);
//
//        if (user == null) {
//            return ResponseEntity.badRequest().body("No user found with this email");
//        }
//
//        int otp = generateOtp(); // generate OTP
//        user.setOtp(otp);
//        userService.save(user); // save the OTP in the user object
//
//        // send the password reset email with the OTP
//        String subject = "Password Reset Request";
//        String body = "Hi " + user.getFirstname() + ",\n\n"
//                + "We received a request to reset your password. Please use the following OTP to reset your password:\n\n"
//                + otp + "\n\n"
//                + "If you did not request this password reset, please ignore this email and your password will remain unchanged.\n\n"
//                + "Best regards,\n"
//                + "The Event Management Portal team";
//        emailService.sendEmail(user.getEmail(), subject, body);
//
//        return ResponseEntity.ok("Password reset email sent to " + user.getEmail());
//    }
//
//    // generate a 6-digit OTP
//    private int generateOtp() {
//        Random random = new Random();
//        int otp = 100000 + random.nextInt(900000);
//        return otp;
//    }
//}
