package com.chanchifeng.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.File;
import java.io.IOException;

import static com.opensymphony.xwork2.Action.SUCCESS;

@Controller("uploadAction")
@Scope("prototype")
public class UploadAction extends ActionSupport {

    public String filePage(){
        return SUCCESS;
    }

    private File file;
    private String fileContentType;
    private String fileFileName;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

    public String getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    @Override
    public String execute() throws Exception {
        //得到上传文件在服务器的路径加文件名
        String target= ServletActionContext.getServletContext().getRealPath("/upload/"+fileFileName);
        //获得上传的文件
        File targetFile=new File(target);
        //通过struts2提供的FileUtils类拷贝
        try {
            FileUtils.copyFile(file, targetFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }
}
