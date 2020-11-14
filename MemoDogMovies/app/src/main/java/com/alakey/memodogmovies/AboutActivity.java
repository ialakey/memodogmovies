package com.alakey.memodogmovies;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class AboutActivity extends AppCompatActivity {

    private String urlTelegram = "https://t.me/kino_narezochka";
    private String urlTikTok = "https://www.tiktok.com/@kino.narezochka?lang=ru&sender_device=pc&sender_web_id=6893835419785020934&is_from_webapp=1";
    private String urlFollow = "https://www.instagram.com/i_alakey";
    private String urlMoreApps = "https://play.google.com/store/apps/developer?id=I_Alakey";
    private String urlApp = "https://play.google.com/store/apps/details?id=com.alakey.memodogmovies";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ActionBar actionBar =getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        setTitle(getString(R.string.about));
    }

    //Кнопка назад
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                restartMainActivity();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void restartMainActivity () {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    //Телеграмм
    public void onClickWatchMovie(View view) {
        Intent intentWatchMovie = new Intent(Intent.ACTION_VIEW, Uri.parse(urlTelegram));
        startActivity(intentWatchMovie);
    }

    //Телеграмм
    public void onClickTikTok(View view) {
        Intent intentTikTok = new Intent(Intent.ACTION_VIEW, Uri.parse(urlTikTok));
        startActivity(intentTikTok);
    }

    //Другие приложения
    public void onClickMoreApps(View view) {
        Intent intentMoreApps = new Intent(Intent.ACTION_VIEW, Uri.parse(urlMoreApps));
        startActivity(intentMoreApps);
    }

    //Разработчик
    public void onClickFollow(View view) {
        Intent intentFollow = new Intent(Intent.ACTION_VIEW, Uri.parse(urlFollow));
        startActivity(intentFollow);
    }

    //Поделиться
    public void onClickShare(View view) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.share) + urlApp);
        sendIntent.setType("text/plain");
        startActivity(Intent.createChooser(sendIntent,"Поделиться"));
    }
}