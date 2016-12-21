package com.ad3bay0.drugverify.activities;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ad3bay0.activities.R;
import com.ad3bay0.drugverify.util.DrugVerifyUtil;
import com.ad3bay0.drugverify.util.IConstants;

public class DrugInfoActivity extends AppCompatActivity {

    private ImageView drugImg;
    private TextView drugName;
    private TextView drugManufacturer;
    private TextView drugDescription;
    private TextView manuDate;
    private TextView expiredDate;
    private TextView batchNo;

    private TextView verificationStatus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drug_info);

        initWidgets();

         String drugCodeString = getIntent().getStringExtra("drugCodeString");

        initDrugDetails(drugCodeString);



    }


    private void initWidgets(){

        drugImg = (ImageView) findViewById(R.id.drugImg);
        drugName = (TextView) findViewById(R.id.drugName);
        drugDescription= (TextView) findViewById(R.id.drugDescription);
        drugManufacturer= (TextView) findViewById(R.id.drugManufacturer);
        manuDate = (TextView) findViewById(R.id.manuDate);
        expiredDate =(TextView)findViewById(R.id.expiredDate);
        batchNo = (TextView)findViewById(R.id.batchNo);

        verificationStatus = (TextView)findViewById(R.id.verificationStatus);


    }


    private void initDrugDetails(String drugCode){

        switch(drugCode){

            case IConstants.AUTHENTIC_DRUG_CODE:

                processAuthenticDrugInfo();

                break;
            case IConstants.EXPIRED_DRUG_CODE:

                processExpiryDrugInfo();

                break;

        }

    }


    private void processExpiryDrugInfo(){

        verificationStatus.setText("Expired Drug!");
        verificationStatus.setTextColor(Color.RED);
        verificationStatus.setAnimation(DrugVerifyUtil.createAnimation());

        drugImg.setImageResource(R.drawable.expired);

        drugName.setText(IConstants.EXPIRED_DRUG_NAME);

        drugDescription.setText(IConstants.EXPIRED_DRUG_DESCRIPTION);

        drugManufacturer.setText(IConstants.MANUFACTURER_LABEL+""+IConstants.EXPIRED_DRUG_MANUFACTURER);

        batchNo.setText(IConstants.BATCH_NO_LABEL+""+IConstants.EXPIRED_DRUG_BATCH_NO);

        manuDate.setText(IConstants.MANUFACTURED_DATE_LABEL+""+IConstants.EXPIRED_DRUG_MANUFACTURED_DATE);

        expiredDate.setText(IConstants.EXPIRY_DATE_LABEL+""+IConstants.EXPIRED_DRUG_EXPIRY_DATE);

    }

    private void processAuthenticDrugInfo(){

        verificationStatus.setText("Valid Drug!");
        verificationStatus.setTextColor(Color.GREEN);
        verificationStatus.setAnimation(DrugVerifyUtil.createAnimation());

        drugImg.setImageResource(R.drawable.authentic);

        drugName.setText(IConstants.AUTHENTIC_DRUG_NAME);

        drugDescription.setText(IConstants.AUTHENTIC_DRUG_DESCRIPTION);

        drugManufacturer.setText(IConstants.MANUFACTURER_LABEL+""+IConstants.AUTHENTIC_DRUG_MANUFACTURER);

        batchNo.setText(IConstants.BATCH_NO_LABEL+""+IConstants.AUTHENTIC_DRUG_BATCH_NO);
        manuDate.setText(IConstants.MANUFACTURED_DATE_LABEL+""+IConstants.AUTHENTIC_DRUG_MANUFACTURED_DATE);
        expiredDate.setText(IConstants.EXPIRY_DATE_LABEL+""+IConstants.AUTHENTIC_DRUG_EXPIRY_DATE);

    }


    @Override
    public void onDestroy() {
        super.onDestroy();

        drugImg.setImageDrawable(null);
    }

}
