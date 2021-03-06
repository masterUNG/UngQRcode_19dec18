package masterung.th.in.androidthai.ungqrcode;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


    public MainFragment() {
        // Required empty public constructor
    }   // Constructor

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Register Controller
        registerController();

//        Check Login
        checkLogin();

//        Login Controller
        loginController();

    }   // Main Method

    private void loginController() {
        Button button = getView().findViewById(R.id.btnLogin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText emailEditText = getView().findViewById(R.id.edtEmail);
                EditText passwordEditText = getView().findViewById(R.id.edtPassword);

                String emailString = emailEditText.getText().toString().trim();
                String passwordString = passwordEditText.getText().toString().trim();

                final MyAlert myAlert = new MyAlert(getActivity());
                if (emailString.isEmpty() || passwordString.isEmpty()) {
                    myAlert.normalDialog("Have Space", "Please Fill All Blank");
                } else {

                    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
                    firebaseAuth.signInWithEmailAndPassword(emailString, passwordString).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                startActivity(new Intent(getActivity(), ServiceActivity.class));
                                getActivity().finish();
                            } else {
                                myAlert.normalDialog("Login False", task.getException().toString());
                            }
                        }
                    });


                }


            }
        });
    }

    private void checkLogin() {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getUid() != null) {
            startActivity(new Intent(getActivity(), ServiceActivity.class));
            getActivity().finish();
        }
    }

    private void registerController() {
        TextView textView = getView().findViewById(R.id.txtRegister);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Replace Fragment
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentMainFragment, new RegisterFragment())
                        .addToBackStack(null).commit();


            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

}   // Main Class
