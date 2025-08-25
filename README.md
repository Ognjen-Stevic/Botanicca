# Botanicca E-Shop 🌱

A simple web-shop application for gardening products built with **Spring Boot (MVC)**, **Thymeleaf**, and **Bootstrap 5**.  
The project demonstrates basic e-commerce functionality with in-memory data storage.

---

## 📌 Features
- User registration & login  
- Browsing available products with images, descriptions, and prices  
- Purchasing items (only for logged-in users)  
- Viewing purchase history (date & time included)  
- Editing account information  

---

## 🛠️ Technologies Used
- **Java Spring Boot** (MVC architecture)  
- **Thymeleaf** (template engine)  
- **Bootstrap 5** (responsive UI design)  
- **In-memory storage** (data stored in objects instead of a real database)  

---

## 📂 Project Structure
- `controller` – Handles HTTP requests (login, register, account, history, home)  
- `model` – Contains entities (User, Article, Order, etc.)  
- `repository` – In-memory data simulation  
- `service` – Business logic (UserService, OrderService, ArticleService)  
- `templates` – Thymeleaf HTML pages (home, login, register, history, account)  
- `static/img` – Product images  
