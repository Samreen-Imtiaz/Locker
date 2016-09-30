package test.screenlocker.com.locker;

/**
 * Created by samreen on 9/25/2016.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



public class HomeFragment extends Fragment {
    TextView t1, t2, t3, t4,t5;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        t1=(TextView) view.findViewById(R.id.textView);
        t2=(TextView) view.findViewById(R.id.textView1);
        t3=(TextView) view.findViewById(R.id.textView2);
        t4=(TextView) view.findViewById(R.id.textView3);
        t5=(TextView) view.findViewById(R.id.textView4);

        return view;

 }

}
