package rc.qaportal.web.automation.aramark.usercreation;

import rc.qaportal.web.automation.aramark.enums.AramarkEnvs;

/**
 * Created by Affan Hasan on 3/10/15.
 */
public interface AramarkUserCreator {

    void createECPSMenuAdmin1(String userName, String userPassword);

    void createUser(AramarkEnvs env, Object credentials[]);

    String getURL(AramarkEnvs aramarkEnv);
}