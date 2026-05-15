package service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GithubActivity {

    public void getGitHubActivity(String userName){

        Map<String, List<Object>> log = new HashMap<>();

        try{
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.github.com/users/"+userName+"/events"))
                    .header("Accept", "application/vnd.github+json")
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String jsonResponse = response.body();

            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(jsonResponse);

            for(JsonNode event: root){
                String type      = event.get("type").asText();
                String repo      = event.get("repo").get("name").asText();

                if(!log.containsKey(type)){
                    log.put(type, Arrays.asList(1,repo));
                }
                else {
                    Integer count = (Integer) log.get(type).get(0);
                    log.get(type).set(0, count+1);
                }
            }

            for(String key:log.keySet()){
                System.out.println(key+" "+log.get(key).getFirst()+" "+log.get(key).get(1));
            }

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
