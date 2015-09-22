package demo.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Parent {
	@EmbeddedId
	private ParentId id;

	private String name;

	public ParentId getId() {
		return id;
	}

	public void setId(ParentId id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Embeddable
	public static class ParentId implements Serializable {

		private static final long serialVersionUID = -5999620331257820208L;

		@Column(length = 50)
		private String id1;

		@Column(length = 50)
		private String id2;

		public String getId1() {
			return id1;
		}

		public void setId1(String id1) {
			this.id1 = id1;
		}

		public String getId2() {
			return id2;
		}

		public void setId2(String id2) {
			this.id2 = id2;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((id1 == null) ? 0 : id1.hashCode());
			result = prime * result + ((id2 == null) ? 0 : id2.hashCode());
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
			ParentId other = (ParentId) obj;
			if (id1 == null) {
				if (other.id1 != null)
					return false;
			} else if (!id1.equals(other.id1))
				return false;
			if (id2 == null) {
				if (other.id2 != null)
					return false;
			} else if (!id2.equals(other.id2))
				return false;
			return true;
		}

	}

}
