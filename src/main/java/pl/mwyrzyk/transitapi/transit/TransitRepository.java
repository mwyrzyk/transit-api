package pl.mwyrzyk.transitapi.transit;

import pl.mwyrzyk.transitapi.transit.entity.Transit;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class TransitRepository {

    @PersistenceContext(unitName="Postgres")
    private EntityManager em;

    public Integer create(Transit transit) {
            Transit entity = em.merge(transit);
            return entity.getId();
    }
}
