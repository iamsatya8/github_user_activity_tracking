# GitHub User Activity Tracking Application

project URL : https://roadmap.sh/projects/github-user-activity
A Simple Java-Based console application that fetches and analyzes a GitHub user's recent public activity using GitHub Rest API

## Features
- Accepts a GitHub username as input
- Fetches recent public events using GitHub API
- Parses JSON response using Jackson
- Groups activity by event type
- Tracks count of each event type
- Diplays repository nname associated with the activity

## Tech Stack
- Java 21
- Java HttpClient
- Jackson Databind
- Maven

## API Used

GitHub Public Events API:

https://api.github.com/users/{username}/events

## Project Structure

```
src
  |-- Main.java
  |-- GithubActivity.java
```

## How It Works

1. User enters GitHub username
2. Application sends GET request to GitHub REST API
3. Response is received in JSON format
4. Jackson parses JSON into JsonNode
5. Activity types are grouped and counted
6. Results are printed to console


## Sample Output

Enter the Github User Name  
octocat

PushEvent 4 octocat/Hello-World  
WatchEvent 2 octocat/Spoon-Knife  
CreateEvent 1 octocat/Test-Repo

## Learning Outcomes

This project helped practice:

- REST API integration in Java
- JSON parsing
- HashMap usage
- Collection handling
- Basic backend design
- Working with external public APIs

## Author

Sai Satyanarayana Vadapalli
