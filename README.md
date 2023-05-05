# ustore-copilot-challenge-3
ustore-copilot-challenge-3
[PostmanCollection](https://github.com/genndi/ustore-copilot-challenge-3/blob/main/Copilot%20-%20Challenge3.postman_collection.json)


# ustore-copilot-challenge-4

### BUILD CONTAINER - root dir
docker build -t ustorecopilotchallenge4:latest .

### RUN container
docker run -p8080:8080 -e "DB_URL=jdbc:mariadb://127.0.0.1:3306/employee_challenge" -e "DB_PASS=root" -e "DB_PASS=root" ustorecopilotchallenge4:latest
