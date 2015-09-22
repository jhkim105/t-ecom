package demo;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DateVO {

	private Long timestamp;

	private String dateString;

	public DateVO() {
		Date now = new Date();
		this.timestamp = now.getTime();
		this.dateString = now.toString();
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public String getDateString() {
		return dateString;
	}

	public void setDateString(String dateString) {
		this.dateString = dateString;
	}

}
