package demo.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import demo.domain.Parent.ParentId;

@Entity
public class Child {

	@EmbeddedId
	private ChildId id;

	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="parent_id1", referencedColumnName="id1"),
 		@JoinColumn(name="parent_id2", referencedColumnName="id2")
	})
	@MapsId("parentId")
	private Parent parent;

	private String name;


	public ChildId getId() {
		return id;
	}

	public void setId(ChildId id) {
		this.id = id;
	}

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Embeddable
	public static class ChildId implements Serializable {

		private static final long serialVersionUID = -4274153742103284578L;

		private ParentId parentId;

		@Column(name = "child_id", length = 50)
		private String id;

		public ParentId getParentId() {
			return parentId;
		}

		public void setParentId(ParentId parentId) {
			this.parentId = parentId;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + ((parentId == null) ? 0 : parentId.hashCode());
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
			ChildId other = (ChildId) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (parentId == null) {
				if (other.parentId != null)
					return false;
			} else if (!parentId.equals(other.parentId))
				return false;
			return true;
		}

	}

}
