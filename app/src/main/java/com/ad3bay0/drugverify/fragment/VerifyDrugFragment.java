package com.ad3bay0.drugverify.fragment;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.ad3bay0.activities.R;
import com.ad3bay0.drugverify.activities.DrugInfoActivity;
import com.ad3bay0.drugverify.util.IConstants;


/**
 * A simple {@link Fragment} subclass.
 */
public class VerifyDrugFragment extends Fragment implements View.OnClickListener {

    private Button verifyBtn;
    private EditText drugCode;


    public VerifyDrugFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_verify_drug,container,false);

        verifyBtn = (Button) view.findViewById(R.id.verifyBtn);
        drugCode = (EditText) view.findViewById(R.id.drugCode);

        verifyBtn.setOnClickListener(this);

        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle(R.string.verify_drug_title);



    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.verifyBtn:
processSubmit(v);
                break;

        }

    }



    private void processSubmit(View v){

       final String drugCodeString = drugCode.getText().toString();

        if(drugCodeString.trim().length()!=0){


            if(drugCodeString.equals(IConstants.EXPIRED_DRUG_CODE)|| drugCodeString.equals(IConstants.AUTHENTIC_DRUG_CODE)){


                final ProgressDialog progressDialog =  new ProgressDialog(getActivity());
                progressDialog.setTitle("Drug Verify");
                progressDialog.setIndeterminate(true);
                progressDialog.setMessage("Verifying drug Please wait....");
                progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                progressDialog.setCancelable(false);
                progressDialog.show();


                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        progressDialog.dismiss();

                        Intent intent =  new Intent(getActivity(), DrugInfoActivity.class);
                        intent.putExtra("drugCodeString",drugCodeString);
                        startActivity(intent);


                    }
                },3000);

            }else{

                Snackbar.make(v,"No drugs found with drug code "+drugCodeString+"",Snackbar.LENGTH_SHORT).show();

            }







        }else{

            Snackbar.make(v,"Please input a drug code",Snackbar.LENGTH_SHORT).show();
        }

    }
}
