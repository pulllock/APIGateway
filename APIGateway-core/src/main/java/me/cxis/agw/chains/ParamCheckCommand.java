package me.cxis.agw.chains;

public class ParamCheckCommand extends AbstractCommand {

    @Override
    public boolean execute(CommonContext context) {
        System.out.println("ParamCheckCommand...");
        return false;
    }
}
