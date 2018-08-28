package com.boal.wechat.response.user;

import com.boal.wechat.response.BaseResponse;

import java.io.ByteArrayOutputStream;

/**
 * <br/>
 * <br/>
 * <b>Date:</b> 2018/08/20<br/>
 *
 * @author Boal Lin
 * @version 1.0
 */
public class DownloadResponse extends BaseResponse {

    private String fileName;

    private ByteArrayOutputStream outputStream;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public ByteArrayOutputStream getOutputStream() {
        return outputStream;
    }

    public void setOutputStream(ByteArrayOutputStream outputStream) {
        this.outputStream = outputStream;
    }
}
