package neu.cs5200.movieTv.people;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import neu.cs5200.movieTv.tv.Tv;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class PeopleJsonWebServiceClient {
	public String findJson(String urlApi, String target, String parameter) {
		String urlString = urlApi.replace(target, parameter);
		String line;
		String json = "";
		try {
			URL url = new URL(urlString);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setRequestMethod("GET");
			InputStream stream = connection.getInputStream();
			InputStreamReader reader = new InputStreamReader(stream);
			BufferedReader buffer = new BufferedReader(reader);

			while ((line = buffer.readLine()) != null) {
				json += line;
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return json;
	}

	public List<People> findPeopleByName(String personName) {
		List<People> ppl = new ArrayList<People>();
		String urlApi = "http://api.themoviedb.org/3/search/person?api_key=cb308fc308a03542532cff9b7c2ed4d9&query={personName}";
		String target = "{personName}";
		String json = "";

		personName = personName.replaceAll(" ", "%20");
		json = findJson(urlApi, target, personName);
		JSONParser parser = new JSONParser();
		JSONObject jsonObject;

		try {
			JSONObject root = (JSONObject) parser.parse(json);
			JSONArray results = (JSONArray) root.get("results");

			for (Object obj : results) {
				JSONObject result = (JSONObject) obj;
				String id = result.get("id").toString();
				String name = (String) result.get("name");
				String profilePath = (String) result.get("profile_path");
				JSONArray knownForArray = (JSONArray) result.get("known_for");
				List<KnownForMedia> kfms = new ArrayList<KnownForMedia>();
				for (Object o : knownForArray) {
					JSONObject knownForObj = (JSONObject) o;
					String backDropPath = (String) knownForObj
							.get("backdrop_path");
					String mediaId = knownForObj.get("id").toString();
					String originalTitle = (String) knownForObj
							.get("original_title");
					String releaseDate = (String) knownForObj
							.get("release_date");
					String posterPath = (String) knownForObj.get("poster_path");
					String voteAverage = (String) knownForObj.get(
							"vote_average").toString();
					String voteCount = (String) knownForObj.get("vote_count")
							.toString();
					String mediaType = (String) knownForObj.get("media_type");
					KnownForMedia newKfm = new KnownForMedia(backDropPath, id,
							originalTitle, releaseDate, posterPath,
							voteAverage, voteCount, mediaType);
					kfms.add(newKfm);
				}

				People newPerson = new People(id, name, kfms, profilePath);
				String imageBaseUrl = "http://image.tmdb.org/t/p/w500";
				newPerson.setProfilePath(imageBaseUrl + profilePath);
				ppl.add(newPerson);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ppl;
	}
	
	public People findPeopleById(String pid) {
		
		String urlApi = "http://api.themoviedb.org/3/person/{id}?api_key=cb308fc308a03542532cff9b7c2ed4d9";
		String target = "{id}";
		String json = "";
		json = findJson(urlApi, target, pid);
		JSONParser parser = new JSONParser();
		JSONObject jsonObject;
		People person = new People();
		try {
			JSONObject root = (JSONObject) parser.parse(json);
			String bioGraphy = (String) root.get("biography");
			String birthDay = (String) root.get("birthday");
			String name = (String) root.get("name");
			String placeOfBirth = (String) root.get("place_of_birth");
			String profilePath = (String) root.get("profile_path");
			person.setId(pid);
			person.setName(name);
			person.setBioGraphy(bioGraphy);
			person.setBirthDay(birthDay);
			person.setPlaceOfBirth(placeOfBirth);
			String imageBaseUrl = "http://image.tmdb.org/t/p/w500";
			person.setProfilePath(imageBaseUrl + profilePath);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return person;

	}
	
	public List<People> findPopularPeople() {
		List<People> ppl = new ArrayList<People>();
		String urlApi = "http://api.themoviedb.org/3/person/popular?api_key=cb308fc308a03542532cff9b7c2ed4d9";
		String json = "";
		try {
			URL url = new URL(urlApi);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setRequestMethod("GET");
			InputStream stream = connection.getInputStream();
			InputStreamReader reader = new InputStreamReader(stream);
			BufferedReader buffer = new BufferedReader(reader);
			String line;
			while ((line = buffer.readLine()) != null) {
				json += line;
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		JSONParser parser = new JSONParser();
		JSONObject jsonObject;

		try {
			JSONObject root = (JSONObject) parser.parse(json);
			JSONArray results = (JSONArray) root.get("results");

			for (Object obj : results) {
				JSONObject result = (JSONObject) obj;
				String id = result.get("id").toString();
				String name = (String) result.get("name");
				String profilePath = (String) result.get("profile_path");
				JSONArray knownForArray = (JSONArray) result.get("known_for");
				List<KnownForMedia> kfms = new ArrayList<KnownForMedia>();
				for (Object o : knownForArray) {
					JSONObject knownForObj = (JSONObject) o;
					String backDropPath = (String) knownForObj
							.get("backdrop_path");
					String mediaId = knownForObj.get("id").toString();
					String originalTitle = (String) knownForObj
							.get("original_title");
					String releaseDate = (String) knownForObj
							.get("release_date");
					String posterPath = (String) knownForObj.get("poster_path");
					String voteAverage = (String) knownForObj.get(
							"vote_average").toString();
					String voteCount = (String) knownForObj.get("vote_count")
							.toString();
					String mediaType = (String) knownForObj.get("media_type");
					KnownForMedia newKfm = new KnownForMedia(backDropPath, id,
							originalTitle, releaseDate, posterPath,
							voteAverage, voteCount, mediaType);
					kfms.add(newKfm);
				}

				People newPerson = new People(id, name, kfms, profilePath);
				String imageBaseUrl = "http://image.tmdb.org/t/p/w500";
				newPerson.setProfilePath(imageBaseUrl + profilePath);
				ppl.add(newPerson);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ppl;
	}
	public static void main(String[] args) {
//		PeopleJsonWebServiceClient pplJws = new PeopleJsonWebServiceClient();
//	System.out.println(pplJws.findPopularPeople().get(0).getName());
//		System.out.println(pplJws.findPeopleByTvName("Monica Bellucci").get(0).getName());
//		PeopleJsonWebServiceClient pplJws = new PeopleJsonWebServiceClient();
//		System.out.println(pplJws.findPeopleById("28782").getPlaceOfBirth() );


	}
}
