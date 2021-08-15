package adapters;

import java.rmi.RemoteException;

import abstracts.SalerCheckService;
import entities.concretes.Saler;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapter implements SalerCheckService {

	@Override
	public boolean CheckIfRealPerson(Saler saler) {
		KPSPublicSoapProxy client = new KPSPublicSoapProxy();

		try {
			return client.TCKimlikNoDogrula(Long.parseLong(saler.getNationalId()), saler.getFirstName(),
					saler.getLastName(), saler.getBirthDate());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

}
