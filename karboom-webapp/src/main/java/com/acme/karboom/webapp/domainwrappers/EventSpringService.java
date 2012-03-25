package com.acme.karboom.webapp.domainwrappers;

import org.acmefireworks.Event;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * User: Brett
 * Date: 25/03/12
 * Time: 1:50 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
@Scope("session")
public class EventSpringService extends Event {
    private static final long serialVersionUID = -7921257708748717926L;
}
