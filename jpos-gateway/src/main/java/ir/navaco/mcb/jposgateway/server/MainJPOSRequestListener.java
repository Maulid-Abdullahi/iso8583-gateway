package ir.navaco.mcb.jposgateway.server;

import org.jpos.core.Configurable;
import org.jpos.core.Configuration;
import org.jpos.core.ConfigurationException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISORequestListener;
import org.jpos.iso.ISOSource;
import org.jpos.space.Space;
import org.jpos.space.SpaceFactory;
import org.jpos.transaction.Context;

/**
 * @author a.khatamidoost
 * */
public class MainJPOSRequestListener implements ISORequestListener, Configurable {

    private Configuration configuration;

    @Override
    public void setConfiguration(Configuration configuration) throws ConfigurationException {
        this.configuration = configuration;
    }

    @Override
    public boolean process(ISOSource isoSource, ISOMsg isoMsg) {
        // Fetching parameters
        String spaceName = configuration.get("space");
        String queueName = configuration.get("queue");
        long spaceTimeout = configuration.getLong("spaceTimeout");

        // context and space
        Context context = new Context();
        Space<String, Context> space = SpaceFactory.getSpace(spaceName);

        // save input into space
        context.put(ContextConstant.REQUEST_KEY, isoMsg);
        context.put(ContextConstant.SOURCE_KEY, isoSource);

        space.out(queueName, context, spaceTimeout);

        return false;
    }
}
