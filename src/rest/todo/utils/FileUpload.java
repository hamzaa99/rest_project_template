package rest.todo.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.ws.rs.core.MediaType;

public class FileUpload {
	String location;
	FileUpload(String location){
		this.location=location;
	}
	private void saveToFile(InputStream uploadedInputStream) {
		String uploadedFileLocation = this.location;

	    try {
	        OutputStream out = null;
	        int read = 0;
	        byte[] bytes = new byte[1024];

	        out = new FileOutputStream(new File(uploadedFileLocation));
	        while ((read = uploadedInputStream.read(bytes)) != -1) {
	            out.write(bytes, 0, read);
	        }
	        out.flush();
	        out.close();
	    } catch (IOException e) {

	        e.printStackTrace();
	    }

	}
/*	//@DefaultValue("true") @FormDataParam("enabled") boolean enabled, @FormDataParam("file") InputStream uploadedInputStream,@FormDataParam("file") FormDataContentDisposition fileDetail
	public void uploadFile( boolean enabled, InputStream uploadedInputStream,FormDataContentDisposition fileDetail) {
	     //Your local disk path where you want to store the file
	    String uploadedFileLocation = "D://uploadedFiles/" + fileDetail.getFileName();
	    System.out.println(uploadedFileLocation);
	    // save it
	    File  objFile=new File(uploadedFileLocation);
	    if(objFile.exists())
	    {
	        objFile.delete();

	    }

	    this.saveToFile(uploadedInputStream);

	    String output = "File uploaded via Jersey based RESTFul Webservice to: " + uploadedFileLocation;

	 //   return Response.status(200).entity(output).build();

	}
*/
}
