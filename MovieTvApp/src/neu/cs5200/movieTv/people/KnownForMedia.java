package neu.cs5200.movieTv.people;

public class KnownForMedia {
	private String backDropPath;
	private String id;
	private String originalTitle;
	private String releaseDate;
	private String posterPath;
	private String voteAverage;
	private String voteCount;
	private String mediaType;
	public KnownForMedia(String backDropPath, String id, String originalTitle,
			String releaseDate, String posterPath, String voteAverage,
			String voteCount, String mediaType) {
		super();
		this.backDropPath = backDropPath;
		this.id = id;
		this.originalTitle = originalTitle;
		this.releaseDate = releaseDate;
		this.posterPath = posterPath;
		this.voteAverage = voteAverage;
		this.voteCount = voteCount;
		this.mediaType = mediaType;
	}
	public KnownForMedia() {
		super();
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
	public String getOriginalTitle() {
		return originalTitle;
	}
	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
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
	public String getMediaType() {
		return mediaType;
	}
	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

}
