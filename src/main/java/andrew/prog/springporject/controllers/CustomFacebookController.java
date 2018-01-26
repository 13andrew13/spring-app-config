package andrew.prog.springporject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/connect")
public class CustomFacebookController extends ConnectController{
    /**
     * Constructs a ConnectController.
     *
     * @param connectionFactoryLocator the locator for {@link ConnectionFactory} instances needed to establish connections
     * @param connectionRepository     the current user's {@link ConnectionRepository} needed to persist connections; must be a proxy to a request-scoped bean
     */
    @Autowired
    public CustomFacebookController (ConnectionFactoryLocator connectionFactoryLocator, ConnectionRepository connectionRepository) {
        super (connectionFactoryLocator, connectionRepository);
    }

    @Override
    protected String connectedView (String providerId) {
        return "redirect:/registerFacebook";
    }
}
