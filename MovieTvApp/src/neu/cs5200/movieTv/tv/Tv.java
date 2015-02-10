package neu.cs5200.movieTv.tv;

public class Tv {
  private String backDropPath;
  private String id;
  private String originalName;
  private String firstAirDate;
  private String posterPath;
  private String voteAverage;
  private String voteCount;
  
  private String overView;
  private String lastAirDate;
  
  
  
  public String getOverView() {
	return overView;
}
public void setOverView(String overView) {
	this.overView = overView;
}
public String getLastAirDate() {
	return lastAirDate;
}
public void setLastAirDate(String lastAirDate) {
	this.lastAirDate = lastAirDate;
}
public Tv(String id, String firstAirDate, String posterPath,
		String voteAverage, String overView, String lastAirDate) {
	super();
	this.id = id;
	this.firstAirDate = firstAirDate;
	this.posterPath = posterPath;
	this.voteAverage = voteAverage;
	this.overView = overView;
	this.lastAirDate = lastAirDate;
}
public Tv() {
	super();
}
public Tv(String backDropPath, String id, String originalName,
		String firstAirDate, String posterPath, String voteAverage,
		String voteCount) {
	super();
	this.backDropPath = backDropPath;
	this.id = id;
	this.originalName = originalName;
	this.firstAirDate = firstAirDate;
	this.posterPath = posterPath;
	this.voteAverage = voteAverage;
	this.voteCount = voteCount;
}
public String getBackDropPath() {
	return backDropPath;
}
public void setBackDropPath(String backDropPath) {
	this.backDropPath = backDropPath;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getOriginalName() {
	return originalName;
}
public void setOriginalName(String originalName) {
	this.originalName = originalName;
}
public String getFirstAirDate() {
	return firstAirDate;
}
public void setFirstAirDate(String firstAirDate) {
	this.firstAirDate = firstAirDate;
}
public String getPosterPath() {
	return posterPath;
}
public void setPosterPath(String posterPath) {
	this.posterPath = posterPath;
}
public String getVoteAverage() {
	return voteAverage;
}
public void setVoteAverage(String voteAverage) {
	this.voteAverage = voteAverage;
}
public String getVoteCount() {
	return voteCount;
}
public void setVoteCount(String voteCount) {
	this.voteCount = voteCount;
}
  
}
