# Spring Blog Application

This is a **Spring Boot Blog Application** developed by **Virendra Gadekar**.  
It includes user registration, login, profile management, profile photo upload, forgot password via email, and secure password reset functionality.

---

## 📌 **Features**

- ✅ User Registration & Login
- ✅ Profile View & Update
- ✅ Upload & Update Profile Photo
- ✅ Forgot Password & Email Reset Link
- ✅ Secure Token Expiry for Password Reset
- ✅ Simple Email Service using Gmail SMTP
- ✅ Integrated with Thymeleaf for dynamic HTML views

---

## ⚙️ **Tech Stack**

- **Backend:** Java 17, Spring Boot 3.x, Spring MVC, Spring Security, Spring Data JPA, Hibernate
- **Database:** H2 Embedded DB (File-based)
- **View:** Thymeleaf Template Engine
- **Email:** JavaMailSender (Gmail SMTP)
- **Build Tool:** Maven

---

## 🚀 **Getting Started**

### 1️⃣ **Clone the Repository**

```bash
git clone https://github.com/your-username/your-repo-name.git
cd your-repo-name

2️⃣ Add Secret Properties

Create a secrect.properties file in the src/main/resources folder (or configure your .env):

spring.mail.username=your-gmail@gmail.com
spring.mail.password=your-gmail-app-password
site.domain=http://localhost:8080/
password.token.reset.timeout.minutes=10

✅ Important:
Use a Google App Password, not your Gmail password, for secure SMTP.

3️⃣ Run the Application

# Using Maven
mvn spring-boot:run

# OR using your IDE (IntelliJ, VSCode, Eclipse)
Run `SpringBlogApplication.java`

4️⃣ Access in Browser
http://localhost:8080/

src/main/java
 ├── controller
 │   └── AccountController.java
 ├── service
 │   ├── AccountService.java
 │   ├── EmailService.java
 ├── config
 │   └── AppConfig.java
 ├── model
 │   └── Account.java
 ├── repository
 │   └── AccountRepository.java
 ├── SpringBlogApplication.java

Templates: src/main/resources/templates/account_views/
Static files: src/main/resources/static/

📧 Email Configuration

Uses Gmail SMTP:
	•	smtp.gmail.com
	•	Port 587
	•	TLS enabled

Ensure:
	•	Less secure app access is OFF.
	•	Use an App Password for best security.

⸻

⚠️ Troubleshooting
	•	DB Locked Error: Close other instances or run in server mode.
	•	Email Not Sending: Check Gmail App Password or SMTP config.
	•	Fragments Warning: Use ~{} syntax in Thymeleaf fragments.

⸻

🙌 Author

Made with ❤️ by Virendra Gadekar

⸻

📃 License

Open source for learning purposes.
Feel free to fork, modify, and improve!

---

## ✅ **How to Use**

1️⃣ Save this as `README.md` in your project root.  
2️⃣ Push to GitHub:  
```bash
git add README.md
git commit -m "Add detailed README"
git push origin main
