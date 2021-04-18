package com.swalikh.auto.autobuilder.exception;

import com.swalikh.auto.autobuilder.utils.Result;
import lombok.Data;

/**
 * 全局异常类
 */
@Data
public class GlobalException extends RuntimeException {

    private CodeMsg codeMsg;

    private Result result;

    public GlobalException(CodeMsg codeMsg) {
        super(codeMsg.toString());
        this.codeMsg = codeMsg;
    }

    public GlobalException(Result result) {
        super();
        this.result = result;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}