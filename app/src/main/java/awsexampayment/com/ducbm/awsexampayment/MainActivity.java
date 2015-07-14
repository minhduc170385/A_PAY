package awsexampayment.com.ducbm.awsexampayment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import adapter.SubjectAdapter;


public class MainActivity extends ActionBarActivity {

    private ListView codeLearnLessons ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SetupListViewSubject();



    }

    private void SetupListViewSubject()
    {
        ListView subjectListView=(ListView) findViewById(R.id.listView);
        // chapterListAdapter = new CodeLearnAdapter();
        SubjectAdapter subAdapter = new SubjectAdapter(this);
        subjectListView.setAdapter(subAdapter);

        subjectListView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position >0 && position <3) {
                    Intent openLanguage = new Intent("com.aws.LANGUAGE");

                    TextView txt = (TextView) parent.getChildAt(position).findViewById(R.id.lblCode);
                    String keyword = txt.getText().toString();
                    openLanguage.putExtra("Subject Choose", keyword);
                    startActivity(openLanguage);
                }
               /* if(position ==3)
                {

                    Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=" + MainActivity.this.getPackageName());
                    Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                    try {
                        MainActivity.this.startActivity(goToMarket);
                       // startActivity(goToMarket);
                    } catch (ActivityNotFoundException e) {
                       // UtilityClass.showAlertDialog(context, ERROR, "Couldn't launch the market", null, 0);
                    }
                }*/




            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.action_refresh) {
            Toast.makeText(this, "Refresh selected", Toast.LENGTH_SHORT)
                    .show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
