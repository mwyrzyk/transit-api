package pl.mwyrzyk.transitapi.transit;

import pl.mwyrzyk.transitapi.transit.entity.Transit;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDate;

@Stateless
public class TransitRepository {

    @PersistenceContext(unitName="Postgres")
    private EntityManager em;

    public Integer create(Transit transit) {
        Transit entity = em.merge(transit);
        return entity.getId();
    }

    public Object[] sumDistanceAndPriceBetweenDates(LocalDate since, LocalDate till) {
       Query q = em.createNamedQuery("Transit.sumDistanceAndPriceBetweenDates");
       q.setParameter("since", since);
       q.setParameter("till", till);

       return (Object[]) q.getSingleResult();
    }
}
