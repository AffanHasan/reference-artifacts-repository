package user;

/**
 *
 * @author Affan Hasan
 */
public class DefaultUserEmailPrincipal implements UserEmailPrincipal {
    
    private final String _email;

    public DefaultUserEmailPrincipal(String email) {
        this._email = email;
    }

    @Override
    public String getEmail() {
        return this._email;
    }

    @Override
    public String getName() {
        return this.getEmail();
    }
    
}