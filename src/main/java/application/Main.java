package application;

import service.GithubActivity;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the Github User Name");
        String gitHubUserName = scan.nextLine();

        GithubActivity gitHubActivity = new GithubActivity();
        gitHubActivity.getGitHubActivity(gitHubUserName);
    }
}
