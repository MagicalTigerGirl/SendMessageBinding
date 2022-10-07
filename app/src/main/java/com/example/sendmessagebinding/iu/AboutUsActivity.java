package com.example.sendmessagebinding.iu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.sendmessagebinding.R;
import com.example.sendmessagebinding.SendMessageAplication;
import com.vansuita.materialabout.builder.AboutBuilder;
import com.vansuita.materialabout.views.AboutView;

public class AboutUsActivity extends AppCompatActivity {

    // La activity que se muestra cuando clicamos sobre el menu y "Sobre mi"
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AboutView view = AboutBuilder.with(this)
                //.setPhoto(R.mipmap.ic_launcher)
                //.setCover(R.drawable.wallpaperaboutus)
                .setName(((SendMessageAplication)getApplication()).getUser().getName())
                .setSubTitle(getResources().getString(R.string.aboutSubTitle))
                .setBrief(getResources().getString(R.string.aboutBrief))
                .setAppIcon(R.mipmap.ic_launcher)
                .setAppName(R.string.app_name)
                .addGooglePlayStoreLink("")
                .addGitHubLink("https://github.com/MagicalTigerGirl")
                //.addFacebookLink("user")
                .addFiveStarsAction()
                .setVersionNameAsAppSubTitle()
                .addShareAction(R.string.app_name)
                .setWrapScrollView(true)
                .setLinksAnimated(true)
                .setShowAsCard(true)
                .build();

        setContentView(view);

        //addContentView(view, layoutParams);
    }
}