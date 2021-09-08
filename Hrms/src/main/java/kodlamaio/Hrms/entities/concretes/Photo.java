package kodlamaio.Hrms.entities.concretes;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","cvs"})
@Table(name = "photos")
public class Photo {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "photo_id")
	    private int photoId;

	    @Column(name = "photo_title")
	    private String photoTitle;

	    @NotBlank
		@NotNull
	    @Column(name = "image")
	    private String image;
	    
	    @JsonIgnore
		@OneToMany(mappedBy = "coverLetter")
		private List<Cv> cvs;
}
