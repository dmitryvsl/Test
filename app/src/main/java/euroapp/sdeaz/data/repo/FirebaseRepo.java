package euroapp.sdeaz.data.repo;

import android.util.Log;

import euroapp.sdeaz.domain.repo.Repository;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

import javax.inject.Inject;

import io.reactivex.Single;

public class FirebaseRepo implements Repository<String> {

    FirebaseRemoteConfig config;

    @Inject
    public FirebaseRepo(FirebaseRemoteConfig config) {
        this.config = config;
    }

    @Override
    public Single<String> getData() {
        return Single.create(emitter ->
                config.reset().addOnCompleteListener(task ->
                        config.fetchAndActivate().addOnCompleteListener(task1 ->
                                {
                                    if (task1.isSuccessful())
                                        emitter.onSuccess(config.getString("url"));
                                    else
                                        emitter.onError(new Throwable(task1.getException().getMessage()));
                                }
                        ).addOnFailureListener(e -> {
                            Log.e("FirebaseRepo", "onFailure: " + e.getMessage());
                            emitter.onError(e);
                        })
                )
        );
    }
}
