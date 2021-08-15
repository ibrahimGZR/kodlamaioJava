package adapters;

import java.rmi.RemoteException;

import abstracts.CustomerCheckService;
import entities.concretes.Customer;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapter implements CustomerCheckService {

	@Override
	public boolean checkRealPersonService(Customer customer) {

		KPSPublicSoapProxy client = new KPSPublicSoapProxy();

		try {
			return client.TCKimlikNoDogrula(Long.parseLong(customer.getNationalityId()),
					customer.getFirstName().toUpperCase(), customer.getLastName().toUpperCase(),
					customer.getDateOfBirthday());

		}

		catch (NumberFormatException | RemoteException e) {
			e.printStackTrace();
			return false;

		}

	}

}
