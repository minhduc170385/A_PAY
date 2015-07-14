package adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List
        ;

import Model.Subject;
import awsexampayment.com.ducbm.awsexampayment.R;


/**
 * Created by hermes on 2/13/15.
 */
public class SubjectAdapter extends BaseAdapter {


    List<Subject> subjects=getDataForListView();
    private LayoutInflater mInflater;
    private Context ctx;
    public SubjectAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        ctx = context;
    }
    public List<Subject> getDataForListView()
    {
        List<Subject> subjects = new ArrayList<Subject>();

        Subject sub= new Subject();
        sub.setTitle("AWS-Archtect, AWS-Developer Associate");
        sub.setCode("Note");
        subjects.add(sub);

        sub= new Subject();
        sub.setTitle("AWS Certified Developer Associate Practice Exam");
        sub.setCode("AWS-Developer");
        subjects.add(sub);

        sub= new Subject();
        sub.setTitle("AWS Certified Solutions Architect - Associate ");
        sub.setCode("AWS-Architect");
        subjects.add(sub);


        //sub= new Subject();
        //sub.setTitle("");
        //sub.setCode("Rate App");
        //subjects.add(sub);

        return subjects;

    }
    @Override
    public int getCount() {
        return subjects.size();
    }

    @Override
    public Subject getItem(int position) {
        return subjects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null)
        {

            LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.rowsubject, parent,false);
        }

        TextView chapterName = (TextView)convertView.findViewById(R.id.lblCode);
        TextView chapterDesc = (TextView)convertView.findViewById(R.id.lblTitle);

        Subject chapter = subjects.get(position);

        if(position==0)
        {
            chapterName.setTextColor(Color.RED);
            chapterDesc.setTextColor(Color.RED);
        }
        else
        {
            chapterName.setTypeface(null, Typeface.BOLD_ITALIC);
            chapterDesc.setTypeface(null, Typeface.ITALIC);
        }


        chapterName.setText(chapter.getCode());
        chapterDesc.setText(chapter.getTitle());

        return convertView;

    }
}
