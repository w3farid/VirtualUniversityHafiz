package com.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
//import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.primefaces.model.UploadedFile;

public class ImageManagement implements Serializable {

    public String copyImage(UploadedFile upFile, String userId) {
        if (upFile != null) {
            try {
                FacesContext fCon = FacesContext.getCurrentInstance();
                ServletContext sCon = (ServletContext) fCon.getExternalContext().getContext();
                String dbPath = sCon.getRealPath("/");
                String mainURLPath = dbPath.substring(0, dbPath.lastIndexOf("\\build"));
                InputStream is = upFile.getInputstream();
                String sourceFileName = upFile.getFileName();
                String extension = sourceFileName.substring(sourceFileName.lastIndexOf("."));
                String destPath = mainURLPath + "\\web\\resources\\images\\userImages\\" + userId + extension;
                File destFile = new File(destPath);
                OutputStream os = new FileOutputStream(destFile);
                //IOUtils.copy(is, os);
                is.close();
                os.close();
                return userId + extension;
            } catch (Exception e) {
                return "exception.jpg";
            }
        }
        return "notFound.jpg";
    }
}