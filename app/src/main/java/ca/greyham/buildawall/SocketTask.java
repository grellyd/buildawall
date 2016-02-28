package ca.greyham.buildawall;

import android.os.AsyncTask;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by jimmylin on 2016-02-27.
 *
 * Asynchronous task that sends requests and receives responses
 * Usage: Construct(String IPAdress, int portNubmer, String request)
 *          wait for instance.responseIsReady() == true
 *          response = instance.getResponse();
 */
public class SocketTask extends AsyncTask<Void, Void, Void> {

    //TODO Send Query

    private boolean isFinished = false;
    private String destAddress;
    private int destPort;
    private String request = "";
    private String response = "";

    SocketTask(String address, int port, String request){
        this.destAddress = address;
        this.destPort = port;
        this.request = new String(request);
    }

    @Override
    protected Void doInBackground(Void... arg0) {

        Socket socket = null;

        try {
            socket = new Socket(destAddress, destPort);

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            byte[] buffer = new byte[1024];

            int bytesRead;
            InputStream inputStream = socket.getInputStream();

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            out.println(request);

    /*
     * notice:
     * inputStream.read() will block if no data return
     */
            while ((bytesRead = inputStream.read(buffer)) != -1){
                byteArrayOutputStream.write(buffer, 0, bytesRead);
                response += byteArrayOutputStream.toString("UTF-8");
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
            response = "UnknownHostException: " + e.toString();
        } catch (IOException e) {
            e.printStackTrace();
            response = "IOException: " + e.toString();
        }finally{
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        isFinished = true;
        super.onPostExecute(result);
    }

    public boolean responseIsReady(){
        return isFinished;
    }

    public String getResponse(){

        return new String(response);
    }

}

