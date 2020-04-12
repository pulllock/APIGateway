package me.cxis.agw.chains;

public class BlackIPCheckCommand extends AbstractCommand {

    @Override
    public boolean execute(CommonContext context) {
        System.out.println("BlackIPCheckCommand...");
        return false;
    }
}
