package esensato.a2017nac03;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import java.util.Timer;
import java.util.TimerTask;

public class JogoService extends Service {

    private Timer timer;

    @Override
    public void onCreate() {
        timer = new Timer();
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Jogo.iniciar(intent.getExtras().getInt("tentativas"));
        timer.schedule(new JogoTask(), 0, 10000);
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        timer.cancel();
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
