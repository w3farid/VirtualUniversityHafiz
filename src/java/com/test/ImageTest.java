
package com.test;

import com.util.ImageManagement;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.UploadedFile;

@ManagedBean
@RequestScoped
public class ImageTest implements Serializable{
    private UploadedFile upFile;

    public UploadedFile getUpFile() {
        return upFile;
    }

    public void setUpFile(UploadedFile upFile) {
        this.upFile = upFile;
    }
    public void upload(){
        String a=new ImageManagement().copyImage(upFile, "a");
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(a));
    }
}
