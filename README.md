# todo-list
📝 StackTask - Smart Todo App
Your Smart Todo Companion – Organize your day, track tasks, and boost productivity with StackTask, a modern task management system.

🚀 Features
✅ User Registration & Login

🔐 Secure Authentication with Spring Security

🧾 Create, Read, Update, Delete (CRUD) for tasks

🧑‍💼 Role-based access (private task lists per user)

🌐 RESTful API using Spring Boot

🛡️ Password Encryption (BCrypt)

🔐 Session-based Authentication (or JWT if implemented)

🧪 Error Handling & Input Validation

📦 MySQL Database Integration

📋 Pagination and Filtering of Tasks

🖥️ Frontend built using HTML, CSS, JS 

# SETUP INSTRUCTION
1. Clone the Repository
       git clone https://github.com/1akshaym12/todo-list
       cd stacktask-todo-app
2. Configure Database

   Open src/main/resources/application.properties
   Add your DB credentials:

      spring.datasource.url=jdbc:mysql://localhost:3306/todo_db
      spring.datasource.username=root
      spring.datasource.password=yourpassword

3. Run the Application

      ./mvnw spring-boot:run
4. Open in Browser

   http://localhost:8081/home.html → Homepage

   http://localhost:8081/login.html → Login

   http://localhost:8081/tasks.html → Task Manager

## SCREENSHOTS
<img width="1918" height="722" alt="Screenshot 2025-07-17 213317" src="https://github.com/user-attachments/assets/058b8670-6ad6-4367-9a2c-6e484d185b42" />
<img width="1895" height="843" alt="Screenshot 2025-07-17 213215" src="https://github.com/user-attachments/assets/60974c44-2709-46fc-b58a-43d31f895596" />
<img width="1861" height="838" alt="Screenshot 2025-07-17 213201" src="https://github.com/user-attachments/assets/f2793342-eaaf-4d52-9f0d-5a49d57e3ad3" />

       
## 🧪 API Endpoints
| Method | Endpoint         | Description                   |
| ------ | ---------------- | ----------------------------- |
| POST   | `/auth/register` | Register new user             |
| POST   | `/login`         | Login user (session/JWT)      |
| GET    | `/tasks`         | Get all tasks (user-specific) |
| POST   | `/tasks`         | Create new task               |
| PUT    | `/tasks/{id}`    | Update task                   |
| DELETE | `/tasks/{id}`    | Delete task                   |

## Security Notes

   CSRF disabled for REST APIs

   Session-based login (or JWT optional)

   Access to /tasks restricted to logged-in users

   BCrypt encryption used for password storage

## 📁 Project Structure

todo_app/
├── src/
│   ├── main/
│   │   ├── java/com/akshay/todo_app/
│   │   │   ├── controller/
│   │   │   ├── model/
│   │   │   ├── repository/
│   │   │   ├── service/
│   │   │   └── config/
│   └── resources/
│       ├── static/
│       │   ├── home.html, login.html, tasks.html
│       │   └── tasks.js, style.css
│       └── application.properties

## 🙋‍♂️ Author

Akshay M

🎓 AIML Engineering Student

📫 [LinkedIn Profile](https://www.linkedin.com/in/akshay-m-80641b218/)


