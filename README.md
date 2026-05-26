# BFHL API - Campus Hiring Assessment

This is a REST API built using Spring Boot and Java 17 for the campus hiring assessment.

## Endpoints

### `POST /bfhl`

Accepts a JSON payload containing an array of strings and processes it according to the assessment rules.

#### Input Format
```json
{
  "data": ["a","1","334","4","R","$"]
}
```

#### Output Format
```json
{
  "is_success": true,
  "user_id": "priyanshi_khorwal_09052006",
  "email": "priyanshikhorwal231190@acropolis.in",
  "roll_number": "0827CS231196",
  "odd_numbers": ["1"],
  "even_numbers": ["334", "4"],
  "alphabets": ["A", "R"],
  "special_characters": ["$"],
  "sum": "339",
  "concat_string": "Ra"
}
```

## Setup & Running Locally

1. **Prerequisites**: Java 17, Maven installed.
2. **Build**: `mvn clean install`
3. **Run**: `mvn spring-boot:run`

### cURL Testing Command (Local)
```bash
curl -X POST http://localhost:8080/bfhl \
     -H "Content-Type: application/json" \
     -d '{"data": ["a","1","334","4","R","$"]}'
```

### Postman Testing
- Method: `POST`
- URL: `http://localhost:8080/bfhl`
- Headers: `Content-Type: application/json`
- Body (raw, JSON):
```json
{
  "data": ["A","ABCD","DOE", "2", "3"]
}
```

## Deployment to Render

This project is structured to be directly deployable to Render using Render's Web Service creation feature for Java.

### Steps:
1. Push this repository to GitHub.
```bash
git init
git add .
git commit -m "Initial commit for campus hiring assessment"
git branch -M main
git remote add origin <your-github-repo-url>
git push -u origin main
```
2. Go to Render dashboard and create a new **Web Service**.
3. Connect your GitHub repository.
4. Render will auto-detect a Java/Maven project.
   - Build Command: `mvn clean package`
   - Start Command: `java -jar target/bfhl-api-0.0.1-SNAPSHOT.jar`
5. Click **Deploy**. Your API will be live!

### Hosted Endpoint Example (Post-Deployment)
Replace `<your-render-url>` with your actual URL.
```bash
curl -X POST https://<your-render-url>/bfhl \
     -H "Content-Type: application/json" \
     -d '{"data": ["1", "a", "$"]}'
```
