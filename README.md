# How to Run This Project
## Prerequisites
### Install Docker on your machine.
### Docker Commands
### Create the containers:
### ` docker-compose up -d`
### Destroy the containers:
### `docker-compose down`
### List running containers:
### `docker ps`
### Verify busy port:
### `sudo lsof -i -P -n | grep 5432`
## Kill a process:
### `sudo kill <process_id>`
### Replace <process_id> with the actual process ID you need to terminate.
## Handling Docker Compose Errors
### You may need to run the following command to fix it:
### `sudo ln -sf /Applications/Docker.app/Contents/Resources/cli-plugins/docker-compose /usr/local/bin/docker-compose`
## Database Information
### This project uses PostgreSQL as the default database. If you wish to use a different database, follow these steps:
### Modify the docker-compose.yml file to use the desired database configuration.
### Install the necessary dependencies for the database driver of your choice. Update the pom.xml file to include the required dependencies.
### Update the database configurations in the following files:
### docker-compose.yml
### application.properties
