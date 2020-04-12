package me.cxis.agw.chains;

public class DecodeCommand extends AbstractCommand {

    @Override
    public boolean execute(CommonContext context) {
        System.out.println("DecodeCommand...");
        return false;
    }
}
