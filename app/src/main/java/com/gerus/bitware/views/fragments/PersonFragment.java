package com.gerus.bitware.views.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gerus.bitware.R;
import com.gerus.bitware.models.Persona;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by gerus-mac on 22/11/17.
 */

public class PersonFragment extends GeneralFragment {

    @BindView(R.id.name)
    TextInputLayout name;
    @BindView(R.id.firstName)
    TextInputLayout firstName;
    @BindView(R.id.lastName)
    TextInputLayout lastName;
    @BindView(R.id.age)
    TextInputLayout age;
    @BindView(R.id.gender)
    TextInputLayout gender;
    @BindView(R.id.weight)
    TextInputLayout weight;
    @BindView(R.id.height)
    TextInputLayout height;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_person, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mListener.changeTitle(R.string.fragment_persons);

        Persona voPErson = new Persona();
        Log.d("Ger","voPErson "+voPErson.toString());
    }

    @OnClick(R.id.submit)
    public void submit(View view) {
        if(isNotEmptyEditText(name, firstName, lastName, age, gender, weight, height)){
            examenStep1();
            mDialogs.showPositiveMessage(R.string.show_console);
        }
    }

    private void examenStep1() {
        Persona voPersona1 = new Persona(getText(name),
                getText(firstName),
                getText(lastName),
                Integer.valueOf(getText(age)),
                getText(gender).charAt(0),
                Float.valueOf(getText(weight)),
                Float.valueOf(getText(height)));

        Persona voPersona2 = new Persona(getText(name),
                getText(firstName),
                getText(lastName),
                Integer.valueOf(getText(age)),
                getText(gender).charAt(0));

        Persona voPersona3 = new Persona();
        voPersona3.setNombre(getText(name));
        voPersona3.setApPaterno(getText(firstName));
        voPersona3.setApMaterno(getText(lastName));
        voPersona3.setEdad(Integer.valueOf(getText(age)));
        voPersona3.setGenero(getText(gender).charAt(0));
        voPersona3.setPeso(Float.valueOf(getText(weight)));
        voPersona3.setAltura(Float.valueOf(getText(height)));

        try {
            Log.d(TAG, "Persona 1 (Peso ideal): "+voPersona1.calcularIMC());
            Log.d(TAG, "Persona 1 (Mayor edad): "+voPersona1.esMayorEdad());
            Log.d(TAG, "Persona 1 (Información): "+voPersona1.toString());

            Log.d(TAG, "Persona 2 (Peso ideal): "+voPersona2.calcularIMC());
            Log.d(TAG, "Persona 2 (Mayor edad): "+voPersona2.esMayorEdad());
            Log.d(TAG, "Persona 2 (Información): "+voPersona2.toString());

            Log.d(TAG, "Persona 3 (Peso ideal): "+voPersona3.calcularIMC());
            Log.d(TAG, "Persona 3 (Mayor edad): "+voPersona3.esMayorEdad());
            Log.d(TAG, "Persona 3 (Información): "+voPersona3.toString());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private boolean isNotEmptyEditText(TextInputLayout ... inputEditTexts){
        for (TextInputLayout inputEdit: inputEditTexts) {
            if(inputEdit.getEditText().getText().toString().isEmpty()){
                inputEdit.getEditText().setError(getString(R.string.error_empty));
                inputEdit.requestFocus();
                return false;
            }
        }
        return true;
    }

    private String getText(TextInputLayout inputEditTexts){
        return inputEditTexts.getEditText().getText().toString();
    }

}
