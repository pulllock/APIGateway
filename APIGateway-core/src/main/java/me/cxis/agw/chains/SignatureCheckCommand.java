package me.cxis.agw.chains;

import me.cxis.agw.dao.model.OutDO;
import me.cxis.agw.manager.OutManager;
import me.cxis.agw.utils.CodecUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

import static me.cxis.agw.model.ErrorCode.OUT_CHANNEL_NOT_EXIST;
import static me.cxis.agw.model.ErrorCode.SIGNATURE_ERROR;

public class SignatureCheckCommand extends AbstractCommand {

    private static final Logger LOGGER = LoggerFactory.getLogger(SignatureCheckCommand.class);

    @Resource
    private OutManager outManager;

    @Override
    public boolean execute(CommonContext context) {

        String outName = context.getOutName();
        OutDO outDO = outManager.queryByName(outName);
        if (outDO == null) {
            LOGGER.warn("out channel not exist, out: {}", outName);
            context.setRetCode(OUT_CHANNEL_NOT_EXIST.getCode());
            context.setRetMsg(OUT_CHANNEL_NOT_EXIST.getMsg());
            context.setSuccess(false);
            return true;
        }
        String data = context.getParam();
        String nonce = context.getNonce();
        String sig = CodecUtil.sign(outDO.getCode(), data, nonce);
        String requestSig = context.getSignature();

        if (!requestSig.equals(sig)) {
            LOGGER.warn("signature error, out: {}", outName);
            context.setRetCode(SIGNATURE_ERROR.getCode());
            context.setRetMsg(SIGNATURE_ERROR.getMsg());
            context.setSuccess(false);
            return true;
        }
        return false;
    }
}
