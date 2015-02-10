package neu.cs5200.movieTv.tv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import neu.cs5200.movieTv.movie.Movie;
import neu.cs5200.movieTv.people.People;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class TvJsonWebServiceClient {

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

	public List<Tv> findTvsByTvName(String tvName) {
		List<Tv> tvs = new ArrayList<Tv>();
		String urlApi = "http://api.themoviedb.org/3/search/tv?api_key=cb308fc308a03542532cff9b7c2ed4d9&query={tvName}";
		String target = "{tvName}";
		String json = "";

		tvName = tvName.replaceAll(" ", "%20");
		json = findJson(urlApi, target, tvName);
		JSONParser parser = new JSONParser();
		JSONObject jsonObject;

		try {
			JSONObject root = (JSONObject) parser.parse(json);
			JSONArray results = (JSONArray) root.get("results");

			for (Object obj : results) {
				JSONObject result = (JSONObject) obj;
				String backDropPath = (String) result.get("backdrop_path");
				String id =  result.get("id").toString();
				String originalName = (String) result.get("original_name");
				String firstAirDate = (String) result.get("first_air_date");
				String posterPath = (String) result.get("poster_path");
				String voteAverage = (String) result.get("vote_average").toString();
				String voteCount = (String) result.get("vote_count").toString();

				Tv newTv = new Tv(backDropPath, id, originalName, firstAirDate,
						posterPath, voteAverage, voteCount);
				String imageBaseUrl = "http://image.tmdb.org/t/p/w500";
				newTv.setPosterPath(imageBaseUrl+posterPath);
				tvs.add(newTv);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tvs;

	}

	
	public List<Tv> findPopularTvs(){
		List<Tv> tvs = new ArrayList<Tv>();
		String urlApi = "http://api.themoviedb.org/3/tv/popular?api_key=cb308fc308a03542532cff9b7c2ed4d9";
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
				String backDropPath = (String) result.get("backdrop_path");
				String id =  result.get("id").toString();
				String originalName = (String) result.get("original_name");
				String firstAirDate = (String) result.get("first_air_date");
				String posterPath = (String) result.get("poster_path");
				String voteAverage = (String) result.get("vote_average").toString();
				String voteCount = (String) result.get("vote_count").toString();

				Tv newTv = new Tv(backDropPath, id, originalName, firstAirDate,
						posterPath, voteAverage, voteCount);
				String imageBaseUrl = "http://image.tmdb.org/t/p/w500";
				newTv.setPosterPath(imageBaseUrl+posterPath);
				tvs.add(newTv);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tvs;
	} 
	
	public List<Tv> findTopRatedTvs(){
		List<Tv> tvs = new ArrayList<Tv>();
		String urlApi = "http://api.themoviedb.org/3/tv/top_rated?api_key=cb308fc308a03542532cff9b7c2ed4d9";
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
				String backDropPath = (String) result.get("backdrop_path");
				String id =  result.get("id").toString();
				String originalName = (String) result.get("original_name");
				String firstAirDate = (String) result.get("first_air_date");
				String posterPath = (String) result.get("poster_path");
				String voteAverage = (String) result.get("vote_average").toString();
				String voteCount = (String) result.get("vote_count").toString();

				Tv newTv = new Tv(backDropPath, id, originalName, firstAirDate,
						posterPath, voteAverage, voteCount);
				String imageBaseUrl = "http://image.tmdb.org/t/p/w500";
				newTv.setPosterPath(imageBaseUrl+posterPath);
				tvs.add(newTv);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tvs;
	} 
	
	public List<Tv> findAiringTodayTvs(){
		List<Tv> tvs = new ArrayList<Tv>();
		String urlApi = "http://api.themoviedb.org/3/tv/airing_today?api_key=cb308fc308a03542532cff9b7c2ed4d9";
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
				String backDropPath = (String) result.get("backdrop_path");
				String id =  result.get("id").toString();
				String originalName = (String) result.get("original_name");
				String firstAirDate = (String) result.get("first_air_date");
				String posterPath = (String) result.get("poster_path");
				String voteAverage = (String) result.get("vote_average").toString();
				String voteCount = (String) result.get("vote_count").toString();

				Tv newTv = new Tv(backDropPath, id, originalName, firstAirDate,
						posterPath, voteAverage, voteCount);
				String imageBaseUrl = "http://image.tmdb.org/t/p/w500";
				newTv.setPosterPath(imageBaseUrl+posterPath);
				tvs.add(newTv);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tvs;
	} 
	
	public List<Tv> findOnTheAirTvs(){
		List<Tv> tvs = new ArrayList<Tv>();
		String urlApi = "http://api.themoviedb.org/3/tv/on_the_air?api_key=cb308fc308a03542532cff9b7c2ed4d9";
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
				String backDropPath = (String) result.get("backdrop_path");
				String id =  result.get("id").toString();
				String originalName = (String) result.get("original_name");
				String firstAirDate = (String) result.get("first_air_date");
				String posterPath = (String) result.get("poster_path");
				String voteAverage = (String) result.get("vote_average").toString();
				String voteCount = (String) result.get("vote_count").toString();

				Tv newTv = new Tv(backDropPath, id, originalName, firstAirDate,
						posterPath, voteAverage, voteCount);
				String imageBaseUrl = "http://image.tmdb.org/t/p/w500";
				newTv.setPosterPath(imageBaseUrl+posterPath);
				tvs.add(newTv);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tvs;
	} 
	
	public List<Tv> findPopularPeople(){
		List<Tv> tvs = new ArrayList<Tv>();
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
				String backDropPath = (String) result.get("backdrop_path");
				String id =  result.get("id").toString();
				String originalName = (String) result.get("original_name");
				String firstAirDate = (String) result.get("first_air_date");
				String posterPath = (String) result.get("poster_path");
				String voteAverage = (String) result.get("vote_average").toString();
				String voteCount = (String) result.get("vote_count").toString();

				Tv newTv = new Tv(backDropPath, id, originalName, firstAirDate,
						posterPath, voteAverage, voteCount);
				String imageBaseUrl = "http://image.tmdb.org/t/p/w500";
				newTv.setPosterPath(imageBaseUrl+posterPath);
				tvs.add(newTv);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tvs;
	} 
	
	
public Tv findTvById(String tid) {
		
		String urlApi = "http://api.themoviedb.org/3/tv/{id}?api_key=cb308fc308a03542532cff9b7c2ed4d9";
		String target = "{id}";
		String json = "";
		json = findJson(urlApi, target, tid);
		JSONParser parser = new JSONParser();
		JSONObject jsonObject;
		Tv tv = new Tv();
		try {
			JSONObject root = (JSONObject) parser.parse(json);
			String overView = (String) root.get("overview");
			String name = (String) root.get("name");
			String posterPath = (String) root.get("poster_path");
			tv.setId(tid);
			tv.setOriginalName(name);
			tv.setOverView(overView);
			String imageBaseUrl = "http://image.tmdb.org/t/p/w500";
			tv.setPosterPath(imageBaseUrl + posterPath);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tv;

	}
	
	public static void main(String[] args) {
//		TvJsonWebServiceClient tvJws = new TvJsonWebServiceClient();
//		System.out.println(tvJws.findTvsByTvName("big bang theory").get(0).getOriginalName());
//		TvJsonWebServiceClient tvJws = new TvJsonWebServiceClient();
//		System.out.println(tvJws.findTvById("61599").getOriginalName() );
	}
}
