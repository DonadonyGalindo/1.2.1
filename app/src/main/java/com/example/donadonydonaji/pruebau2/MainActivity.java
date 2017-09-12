package com.example.donadonydonaji.pruebau2;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final String NAME="NAME";
    private final String CORREO="CORREO";
    private final String NUMC="NUMC";
    private EditText mEditTextName,mEditTextCorreo,mEditTextNumC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView)findViewById(R.id.textView1);
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        String texto = sharedPreferences.getString(NAME,null);
        String texto2 = sharedPreferences.getString(CORREO,null);
        String texto3 = sharedPreferences.getString(NUMC,null);
        if (texto==null) {textView.setText("Hola Mundo");}
        else {textView.setText("Nombre" + texto + "\n"+
                                "Correo" + texto2 + "\n"
                                + "Num. Control" + texto3);}
        mEditTextName = (EditText)findViewById(R.id.editText);
        mEditTextCorreo = (EditText)findViewById(R.id.editText2);
        mEditTextNumC = (EditText)findViewById(R.id.editText3);
    }
    public void saveText(View view) {
        SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit();
        editor.putString(NAME, mEditTextName.getText().toString());
        editor.putString(CORREO, mEditTextCorreo.getText().toString());
        editor.putString(NUMC,mEditTextNumC.getText().toString());
        editor.commit();
    }
}
