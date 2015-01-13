/*
 * No license found
 * 
 * 
 */
package session;

import entity.ClubMembers;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jtony_000
 */
@Stateless
public class ClubMembersFacade extends AbstractFacade<ClubMembers> {
    @PersistenceContext(unitName = "cluBbyte_2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClubMembersFacade() {
        super(ClubMembers.class);
    }
    
}
