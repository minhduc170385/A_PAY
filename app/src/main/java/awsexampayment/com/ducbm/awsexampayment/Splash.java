package awsexampayment.com.ducbm.awsexampayment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by hermes on 2/12/15.
 */
public class Splash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        Thread time = new Thread(){
            @Override
            public void run(){
                try {

                    sleep(2000);


                }catch (InterruptedException e){
                    e.printStackTrace();


                }
                finally {

                    Intent openSubject = new Intent("com.aws.SUBJECT");
                    startActivity(openSubject);

                }
            }
        };
        time.start();
        //Intent openSubject = new Intent("com.MCPExam.SUBJECT");
      //  startActivity(openSubject);
    }
}
