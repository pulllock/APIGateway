package me.cxis.agw.chains;

import static me.cxis.agw.constants.Constants.RET_MODEL;

public class InvokeServiceCommand extends AbstractCommand {

    @Override
    public boolean execute(CommonContext context) {
        System.out.println("InvokeServiceCommand...");
        context.put(RET_MODEL,"哈哈哈哈");
        return false;
    }
}
