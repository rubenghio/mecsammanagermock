package samManager.request;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import sube.apps.moises.rechargeRequest.entities.Card;
import sube.apps.moises.sam.entities.Sam;

@Stateless
@Local(SamManagerService.class)
public class SamManagerService implements SamManagerServiceResource {
	
	@PersistenceContext
	private EntityManager em;
	
	public CreditResult request(SamCreditRequest request) {
		long start = System.currentTimeMillis();
		CreditResult creditResult = new CreditResult();
		creditResult.setApdu("0700A4000C020D041900340004148074010064000000CD275936656BF25292D6230F");
		creditResult.setStatus(0);
		creditResult.setCommandCounter(2);
		creditResult.setTransactionId(318779580L);
		List<Sam> query = em.createNamedQuery("validateSamM2", Sam.class).setParameter("serialNumber", request.getSerialNumber()).setParameter("issuerId", request.getIssuerId()).setParameter("samType", 2).getResultList();
		if(!query.isEmpty()){
			Sam sam = query.get(0);
			sam.setLtc(sam.getLtc()+1);
			em.merge(sam);
		}
		System.out.println("------- SamManagerService.request: " + (System.currentTimeMillis() - start));
		return creditResult;
		
	}

	@Override
	public SamInformation getInformation() {
		SamInformation samInformation = new SamInformation();
		Map<Integer,Long> emisores = new HashMap<Integer,Long>();
		emisores.put(5, 1000000000000L);
		emisores.put(7, 100000000000000L);
		emisores.put(6, 100000000000000L);
		samInformation.setEmisores(emisores);
		samInformation.setOperations(6);
		return samInformation;
	}

	@Override
	public RechargeCreditResult rechargeRequest(SamRechargeCreditRequest rechargeRequest) {
		RechargeCreditResult rechargeCredit = new RechargeCreditResult();
		rechargeCredit.setSerialNumber(rechargeRequest.getSerialNumber());
		rechargeCredit.setTransactionId(12L);
		rechargeCredit.setStatus(0);
		rechargeCredit.setApdu("040502030405060708090101");
		List<Card> query = em.createNamedQuery("validateCard", Card.class).setParameter("serialNumber", rechargeRequest.getSerialNumber()).getResultList();
		Card card = query.get(0);
		card.setLtc(card.getLtc()+1);
		em.merge(card);
		return rechargeCredit;
	}

	
}
