package pl.ether.models;

import java.time.LocalDateTime;

public class WebSite {
	private Long id;
	private String name;
	private String URL;
	private LocalDateTime creationDate;
	private LocalDateTime modyficationDate;
	private Integer refreshInterval;
	private ValidationLevel validationLevel;
	private String hash;
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public LocalDateTime getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}
	public LocalDateTime getModyficationDate() {
		return modyficationDate;
	}
	public void setModyficationDate(LocalDateTime modyficationDate) {
		this.modyficationDate = modyficationDate;
	}
	public Integer getRefreshInterval() {
		return refreshInterval;
	}
	public void setRefreshInterval(Integer refreshInterval) {
		this.refreshInterval = refreshInterval;
	}
	public ValidationLevel getValidationLevel() {
		return validationLevel;
	}
	public void setValidationLevel(ValidationLevel validationLevel) {
		this.validationLevel = validationLevel;
	}
	@Override
	public String toString() {
		return "WebSite [id=" + id + ", name=" + name + ", URL=" + URL + ", creationDate=" + creationDate
				+ ", modyficationDate=" + modyficationDate + ", refreshInterval=" + refreshInterval
				+ ", validationLevel=" + validationLevel + ", hash=" + hash + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((URL == null) ? 0 : URL.hashCode());
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((hash == null) ? 0 : hash.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((modyficationDate == null) ? 0 : modyficationDate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((refreshInterval == null) ? 0 : refreshInterval.hashCode());
		result = prime * result + ((validationLevel == null) ? 0 : validationLevel.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WebSite other = (WebSite) obj;
		if (URL == null) {
			if (other.URL != null)
				return false;
		} else if (!URL.equals(other.URL))
			return false;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (hash == null) {
			if (other.hash != null)
				return false;
		} else if (!hash.equals(other.hash))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (modyficationDate == null) {
			if (other.modyficationDate != null)
				return false;
		} else if (!modyficationDate.equals(other.modyficationDate))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (refreshInterval == null) {
			if (other.refreshInterval != null)
				return false;
		} else if (!refreshInterval.equals(other.refreshInterval))
			return false;
		if (validationLevel != other.validationLevel)
			return false;
		return true;
	}
	
	
	
}
