package com.microsoft.graph.connect;

/**
 * The UI options that developer could pass in during interactive sign in.
 */

public enum UiBehavior {

    /**
     * AcquireToken will send prompt=select_account to authorize endpoint and would show a list of users from which can be
     * selected for authentication.
     */
    SELECT_ACCOUNT,

    /**
     * The user will be prompted for credentials by the service. It is achieved by sending prompt=login to the service.
     */
    FORCE_LOGIN,

    /**
     * The user will be prompted to consent even if consent was granted before. It is achieved by sending prompt=consent
     * to the service.
     */
    CONSENT
}
