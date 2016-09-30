package test.screenlocker.com.locker;

/**
 * Created by samreen on 9/25/2016.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import test.screenlocker.com.locker.R;



public class UserFregment extends Fragment {

    private EditText etEmailAddrss;
    private EditText etPhoneNumber;
    private Button btnSubmit;

    public UserFregment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  registerViews();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_user, container, false);
        etEmailAddrss= (EditText) view.findViewById(R.id.editText4);
        etPhoneNumber= (EditText) view.findViewById(R.id.editText5);
        btnSubmit=(Button) view.findViewById(R.id.button2);


        etEmailAddrss.addTextChangedListener(new TextWatcher() {
            // after every change has been made to this editText, we would like to check validity
            public void afterTextChanged(Editable s) {
                Validate_profile.isEmailAddress(etEmailAddrss, true);
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){}
        });

        etPhoneNumber.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                Validate_profile.isPhoneNumber(etPhoneNumber, false);
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){}
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                Validation class will check the error and display the error on respective fields
                but it won't resist the form submission, so we need to check again before submit
                 */

                if ( checkValidation () )
                {
                    ////////////////////////////////////////////////////////
                  /*  String n = etPhoneNumber.getText().toString();
                    String e = etEmailAddrss.getText().toString();
                    SharedPreferences.Editor editor = spref.edit();
                    editor.putString(Number, n);
                    editor.putString(Email, e);
                    editor.commit();*/
                    //////////////////////////////////////
                    submitForm();
                }
                else
                {}
                  //  Toast.makeText(User_Profile.this, "Please fill the fields properly!", Toast.LENGTH_LONG).show();
                Toast.makeText(getActivity(), "Please fill the fields properly!", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    private void submitForm() {
        // Submit your form here. your form is valid
     //  Toast.makeText(this, "Profile Created!", Toast.LENGTH_LONG).show();
        Toast.makeText(getActivity(), "Profile Created!", Toast.LENGTH_SHORT).show();
    }

    private boolean checkValidation() {
        boolean ret = true;

        if (!Validate_profile.isEmailAddress(etEmailAddrss, true)) ret = false;
        if (!Validate_profile.isPhoneNumber(etPhoneNumber, true)) ret = false;

        return ret;
    }
}