package me.cxis.agw.chains;

public class SignatureCheckCommand extends AbstractCommand {

    @Override
    public boolean execute(CommonContext context) {
        System.out.println("SignatureCheckCommand...");
        return false;
    }
}
