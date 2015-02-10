package neu.cs5200.movieTv.people;

import java.util.List;

public class People {
	private String id;
	private String name;
	private List<KnownForMedia> knownFor;
	private String profilePath;
	
	private String bioGraphy;
	private String birthDay;
	private String placeOfBirth;

	public String getBioGraphy() {
		return bioGraphy;
	}

	public void setBioGraphy(String bioGraphy) {
		this.bioGraphy = bioGraphy;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public People(String id, String name, String profilePath, String bioGraphy,
			String birthDay, String placeOfBirth) {
		super();
		this.id = id;
		this.name = name;
		this.profilePath = profilePath;
		this.bioGraphy = bioGraphy;
		this.birthDay = birthDay;
		this.placeOfBirth = placeOfBirth;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<KnownForMedia> getKnownFor() {
		return knownFor;
	}

	public void setKnownFor(List<KnownForMedia> knownFor) {
		this.knownFor = knownFor;
	}

	public String getProfilePath() {
		return profilePath;
	}

	public void setProfilePath(String profilePath) {
		this.profilePath = profilePath;
	}

	public People() {
		super();
	}

	public People(String id, String name, List<KnownForMedia> knownFor,
			String profilePath) {
		super();
		this.id = id;
		this.name = name;
		this.knownFor = knownFor;
		this.profilePath = profilePath;
	}

}
