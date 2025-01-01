
# IPL REST API

This project is a Spring Boot-based REST API that manages an IPL (Indian Premier League) scenario. The API allows you to:

- Add and manage **Players**, **Teams**, and **Matches** as entities.
- Establish relationships between players, teams, and matches.
- Automatically update the match count for players and teams as matches are played.

---

## Features

1. **Player Management**:
   - Add, update, and retrieve player details.
   - Track the total matches a player has participated in.

2. **Team Management**:
   - Add, update, and retrieve team details.
   - Track the total matches played by a team.

3. **Match Management**:
   - Schedule matches between teams.
   - Associate players with teams for each match.
   - Automatically update match statistics.

---

## Technologies Used

- **Java**: Programming language.
- **Spring Boot**: Framework for building the REST API.
- **MySQL**: Database for persisting data.
- **Lombok**: For reducing boilerplate code.
- **Hibernate/JPA**: ORM for entity relationships and database interactions.
- **Postman**: For testing API endpoints.

---

## Database Design

### Entities

1. **Player**
   - `playerId` (Primary Key)
   - `playerName`
   - `teamName`
   - `totalMatches`

2. **Team**
   - `teamId` (Primary Key)
   - `teamName`
   - `homeGround`
   - `totalMatches`

3. **Match**
   - `matchId` (Primary Key)
   - `team1` (Foreign Key referencing Team)
   - `team2` (Foreign Key referencing Team)
   - `players` (List of players participating in the match)
   - `matchDate`

### Relationships

- A **Player** belongs to one **Team**.
- A **Team** can have multiple **Players**.
- A **Match** is played between two **Teams** and involves multiple **Players**.

---

## Installation and Setup

### Prerequisites

1. JDK 11 or higher.
2. Maven or Gradle.
3. MySQL Server.
4. IntelliJ IDEA or any preferred IDE.

### Steps

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/ipl-rest-api.git
   cd ipl-rest-api
   ```

2. Configure the database:
   - Update `application.properties` with your MySQL credentials:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/ipl?createDatabaseIfNotExist=true
     spring.datasource.username=your_username
     spring.datasource.password=your_password
     spring.jpa.hibernate.ddl-auto=update
     ```

3. Build and run the project:
   ```bash
   mvn spring-boot:run
   ```

4. Access the API documentation:
   - Open `http://localhost:8080/swagger-ui.html` (if Swagger is integrated).

---

## API Endpoints

### Player Endpoints

- **Add a Player**
  ```http
  POST /players
  ```
  Body:
  ```json
  {
      "playerName": "Virat Kohli",
      "teamName": "RCB"
  }
  ```

- **Get All Players**
  ```http
  GET /players
  ```

- **Update Player Name**
  ```http
  PUT /players/{playerId}
  ```
  Body:
  ```json
  {
      "playerName": "MS Dhoni"
  }
  ```

### Team Endpoints

- **Add a Team**
  ```http
  POST /teams
  ```
  Body:
  ```json
  {
      "teamName": "Mumbai Indians",
      "homeGround": "Wankhede Stadium"
  }
  ```

- **Get All Teams**
  ```http
  GET /teams
  ```

### Match Endpoints

- **Schedule a Match**
  ```http
  POST /matches
  ```
  Body:
  ```json
  {
      "team1": "RCB",
      "team2": "MI",
      "players": [1, 2, 3, 4],
      "matchDate": "2025-01-01"
  }
  ```

- **Get Match Details**
  ```http
  GET /matches/{matchId}
  ```

---

## Future Enhancements

1. Add player statistics (e.g., runs, wickets).
2. Support for tournaments and seasons.
3. Enhanced query endpoints (e.g., top players, team rankings).
4. Authentication and authorization for secure API access.

---

## License

This project is licensed under the [MIT License](LICENSE).

---

## Author

Swapnil Panchade 
