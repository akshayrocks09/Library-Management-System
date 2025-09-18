# Library Management System

# Description
A Java-based Library Management System that demonstrates Object-Oriented Programming (OOP), SOLID principles, and design patterns. 
This system allows librarians to manage books, patrons, and lending processes efficiently. The project includes a simple recommendation system
based on patron borrowing history.

## Features
- Add, remove, and update books
- Add and update patrons
- Track borrowing history
- Check out and return books
- Search books by title, author, or ISBN
- Book recommendations based on borrowing history
- Demonstrates Factory, Strategy, and Observer design patterns

## Project Structure

- `src/com/example/library/Book.java` – Represents a book  
- `src/com/example/library/BookFactory.java` – Factory for creating books  
- `src/com/example/library/Patron.java` – Represents a library patron  
- `src/com/example/library/PatronFactory.java` – Factory for creating patrons  
- `src/com/example/library/PatronObserver.java` – Observer interface for notifications  
- `src/com/example/library/Loan.java` – Represents book checkout/return  
- `src/com/example/library/Library.java` – Core system managing books, patrons, loans, and recommendations  
- `src/com/example/library/RecommendationStrategy.java` – Interface for recommendation algorithms  
- `src/com/example/library/SimpleHistoryRecommendation.java` – Concrete recommendation based on borrowing history  
- `src/com/example/library/Demo.java` – Demo program showcasing all functionalities  
- `src/com/example/library/Main.java` – Entry point to run the system

*Explanation:*  
- `Library` manages collections of `Book`, `Patron`, and `Loan`.  
- `BookFactory` and `PatronFactory` handle object creation.  
- `RecommendationStrategy` interface is implemented by `SimpleHistoryRecommendation`.  
- `PatronObserver` allows notifications to patrons when certain events happen.  

## How to Run
1. Clone the repository:
2. Open the project in IntelliJ.  
3. Make sure JDK 24 is configured for the project and module.  
4. Right-click `Main.java` → **Run Main**  

## Notes
- All project functionalities are implemented in-memory (no database).  
- You can extend the system with multi-branch support, reservations, and advanced recommendation systems.  
