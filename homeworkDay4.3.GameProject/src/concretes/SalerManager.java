package concretes;

import abstracts.SalerCheckService;
import abstracts.SalerService;
import entities.concretes.Saler;

public class SalerManager implements SalerService {

	private SalerCheckService userCheckService;
	
	public SalerManager(SalerCheckService userCheckService) {
		super();
		this.userCheckService = userCheckService;
	}

	@Override
	public void add(Saler saler) {
		if (userCheckService.CheckIfRealPerson(saler)) {
			System.out.println(saler.getFirstName() + " adlı kullanıcı sisteme eklendi");
		} else {
			System.out.println("kullanıcı doğrulanamadı");
		}
		
	}

	@Override
	public void update(Saler saler) {
		System.out.println(saler.getFirstName() + " adlı kullanıcı bilgileri güncellendi");
		
	}

	@Override
	public void delete(Saler saler) {
		System.out.println(saler.getFirstName() + " adlı kullanıcı silindi");
		
	}

}
