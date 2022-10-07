package com.example.sendmessagebinding.iu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.sendmessagebinding.R;

import com.example.sendmessagebinding.SendMessageAplication;
import com.example.sendmessagebinding.data.Message;
import com.example.sendmessagebinding.data.User;
import com.example.sendmessagebinding.databinding.ActivitySendMessageBinding;

/**
 * <h1>Proyecto SendMessage</h1>
 * En este proyecto aprenderemos a realizar las siguientes operaciones
 * <ol>
 *     <li>Crear un evento en un componente Button en código XML</li>
 *     <li>Crear un escuchador/listener del evento <code>OnClick()</code></li>
 *     <li>Crear un Intent y un elemento Bundle para pasar información entre Activity</li>
 *     <li>El cilo de vida de una Activity</li>
 *     <li>Manejar la pila de Actividades</li>
 * </ol>
 *
 * @author Maria Molina Lorenzo
 * @version 1.0
 * @see android.widget.Button
 * @see android.app.Activity
 * @see android.content.Intent
 * @see android.os.Bundle
 */


public class SendMessageActivity extends AppCompatActivity {

    private static final String TAG = "SendMessageActivity";
    private ActivitySendMessageBinding binding;

    @Override
    /*
     * Este método se ejecuta cuando se crea la Activity
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySendMessageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.setMessage(new Message(((SendMessageAplication)getApplication()).getUser()));
        binding.btSend.setOnClickListener(view -> sendMessage());

    }

    /**
     * Crea el menú de opciones en la vista. Se devuelve true para indicar al SO
     * que se ha realizado la opción de modificar el menú
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * Este método callback se llama cuando se pulsa sobre una de las opciones del menú de la
     * aplicación
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.actionAboutUs:
                //Toast.makeText(this, "Se ha pulsado sobre About Us", Toast.LENGTH_SHORT);
                Intent intent = new Intent(this, AboutUsActivity.class);
                startActivity(intent);
                break;
        }
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "SendMessageActivity -> onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "SendMessageActivity -> onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "SendMessageActivity -> onPause()");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "SendMessageActivity -> onStop()");
    }

    /**
     * Este método se ejecuta cuando se destruye la Activity
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
        Log.d(TAG, "SendMessageActivity -> onDestroy()");

    }
    //endregion

    /*
     * Este método es el que se llama cuando se pulsa sobre el botón btSend definido en el XML
     * android.onClick=sendMessage
     * @param view
     * */
    public void sendMessage(View view) {
        sendMessage();
    }

    public void sendMessage() {
        Bundle bundle = new Bundle();

        //1.1 Pasar dato a dato
        //bundle.putString("user", binding.getMessage().getUser().getName());
        //bundle.putString("message", binding.getMessage().getContent());

        //1.2 crear el objeto message
        bundle.putParcelable("message", binding.getMessage());

        Intent intent = new Intent(this, ViewMessageActivity.class);             // el sobre
        intent.putExtras(bundle);                                                            // mensajito en el sobre

        //3. Inicia la transición entre una vista y otra mediante StartActivity
        startActivity(intent);
    }
}