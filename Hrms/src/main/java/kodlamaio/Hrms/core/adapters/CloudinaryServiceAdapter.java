package kodlamaio.Hrms.core.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;

@Service
public class CloudinaryServiceAdapter implements ImageService {
	Cloudinary cloudinary;

	@Autowired
	public CloudinaryServiceAdapter() {
		super();
		this.cloudinary = new Cloudinary(ObjectUtils.asMap("cloud_name", "ibrahimgzr", "api_key", "993766857592223",
				"api_secret", "dH1kQBpinBWghJa66CpauaS8IFQ"));
	}

	@Override
	public String getImage(String imageName, int width, int height) {
		return this.cloudinary.url().transformation(new Transformation().width(width).height(height))
				.generate(imageName);
	}
}
