package edu.harvard.iq.dataverse.authorization;

import edu.harvard.iq.dataverse.authorization.users.AuthenticatedUser;
import java.util.Map;

/**
 * Objects that can authenticate users - for credentials, they provide persistent user id that can be used to
 * lookup an {@link AuthenticatedUser} using {@link AuthenticatedUserLookup} objects.
 * 
 * {@code AuthenticationPrvider}s are normally registered at startup in {@link AuthenticationServiceBean#startup()}.
 * 
 * @author michael
 */
public interface AuthenticationProvider {
    
    public String getId();
    
    public AuthenticationProviderDisplayInfo getInfo();
    
    /**
     * The main method of this interface - provide a consistent user id, within
     * the scope of this provider, for a user based on the credentials.
     * @param credentials map of credentials, e.g. username, password, domain
     * @return string containing a persistent id of the user, or {@code null} for failed login.
     * @throws AuthorizationException in case, e.g, a connection to the remote server fails.
     */
    public String authenticate( Map<String, String> credentials ) throws AuthorizationException;

}
