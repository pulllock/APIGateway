package fun.pullock.agw.chains;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

public abstract class AbstractCommand implements Command {

    @Override
    public boolean execute(Context context) throws Exception {
        CommonContext commonContext = (CommonContext) context;
        return execute(commonContext);
    }

    public abstract boolean execute(CommonContext context);
}
