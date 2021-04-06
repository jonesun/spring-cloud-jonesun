package org.jonesun.common.result;

/**
 * @author jone.sun
 * @date 2020-08-21 11:30
 */
public class ResultException extends Exception{

    private ResultStatus resultStatus;

    public ResultException(String message) {
        super(message);
        resultStatus = ResultStatus.INTERNAL_SERVER_ERROR;
    }

    public ResultStatus getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(ResultStatus resultStatus) {
        this.resultStatus = resultStatus;
    }
}
