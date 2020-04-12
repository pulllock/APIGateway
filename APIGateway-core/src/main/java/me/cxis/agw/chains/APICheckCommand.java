package me.cxis.agw.chains;

public class APICheckCommand extends AbstractCommand {

    @Override
    public boolean execute(CommonContext context) {
        System.out.println("APICheckCommand...");
        return false;
    }
}
